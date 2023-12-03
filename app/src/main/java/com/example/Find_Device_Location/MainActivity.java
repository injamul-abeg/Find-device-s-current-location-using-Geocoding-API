package com.example.Find_Device_Location;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobipay_abeg.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Double latVal = 0.0, longVal= 0.0;

    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t = (TextView) findViewById(R.id.address);
        Button activeBtn = (Button) findViewById(R.id.active_btn);
        Button sendInfoBtn = findViewById(R.id.sendInfo_btn);

        Context context = this;

        SharedPrefs prefs = SharedPrefs.getInstance(context);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPreferences.getAll();

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("SharedPreferences", entry.getKey() + ": " + entry.getValue().toString());
        }


        //................ Device system info .....................

        String imei_1 = "365728104435363", imei_2 = "243156542310978";
        String device_id = Build.ID;
        String fingerprint = Build.FINGERPRINT;
        String brand = Build.BRAND;
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        String os_version = Build.VERSION.RELEASE;
        String sdk = String.valueOf(Build.VERSION.SDK_INT);
        String serial_no = Build.SERIAL;
        String activation_date_online = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        ;

        //..........................Battery...................................

        BatteryManager bm = (BatteryManager) context.getSystemService(BATTERY_SERVICE);
        String battery = String.valueOf(bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY));


        //.............................. location ...................


        MyLocation myLocation = new MyLocation(this); // or: getApplicationContext(),// context
        TextView textView = findViewById(R.id.loc);
        textView.setText("Latitude: "+myLocation.getLatVal() + "\nLongitude: " + myLocation.getLongVal());

        TextView textView1 = findViewById(R.id.address);
        textView1.setText("Address: "+ AddressLatLong.getAddressFromCoordinates(this,myLocation.getLatVal(), myLocation.getLongVal()));

        // .............RAM....................

// Declaring and Initializing the ActivityManager
        ActivityManager actManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

// Declaring MemoryInfo object
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();

// Fetching the data from the ActivityManager
        actManager.getMemoryInfo(memInfo);

// Fetching the available and total memory and converting into Giga Bytes
        //double availMemory = memInfo.availMem / (1024.0 * 1024.0 * 1024.0);
        double totalMemory = memInfo.totalMem / (1024.0 * 1024.0 * 1024.0);

        String processor = null;
        try {
            processor = this.getCPUInfo().toString();
            Log.e(TAG, "Processor Info:"+ processor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String ram = String.valueOf(totalMemory);

        //................ROM....................

        File root = Environment.getDataDirectory();
        StatFs stat = new StatFs(root.getPath());


        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        long availableBlocks = stat.getAvailableBlocks();

        long totalROMSize = totalBlocks * blockSize;
        long availableROMSize = availableBlocks * blockSize;
        String rom = String.valueOf(totalROMSize);
        Log.d(TAG, "ROM: "+rom);

       //Active Button
        activeBtn.setOnClickListener(i -> {
            ProgressDialog bar = new ProgressDialog(context);
            bar.setMessage("Please wait!!!");
            bar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            bar.show();
            Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitClient.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            IEmi emi = retrofit.create(IEmi.class);
            Log.e("TAG", "onCreate: imei - " +SharedPrefs.getStringValue(context, SharedPrefs.IMEI01) );
            Call<WEmi> emiCall = emi.getEmiInfo(SharedPrefs.getStringValue(context, SharedPrefs.IMEI01), prefs.getStringValue(context, SharedPrefs.SERIAL_NO));
            emiCall.enqueue(new Callback<WEmi>() {
                @Override
                public void onResponse(Call<WEmi> call, Response<WEmi> response) {

                    if (response.code() == 404) {

                        Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
                        bar.dismiss();
                    }
                    Log.e("TAG", "onResponse:-------====----  " + response.toString());
                    if (!response.isSuccessful()) return;
                    Log.e("TAG", "onResponse:-----------  " + response.body().toString());
                    //bar.dismiss();

                    Log.e("TAG", "onResponse:-----------  " + response.body().toString());
                    Log.e("TAG", "onResponse:-------===----  " + response.toString());
                    Log.e("TAG", "onResponse: " + response.body().getEmiArrayList().toString());
                    if (response.body().getEmiArrayList() == null) {
                        Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (response.body().getEmiArrayList().toString().contains("not Found")) {
                        Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (response.body().getEmiArrayList().size() == 0) {
                        Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                @Override
                public void onFailure(Call<WEmi> call, Throwable t) {
                    Log.e("TAG", "onFailure: " + t.toString() );
                    Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();

                    bar.dismiss();
                }
            });
        });



        // Send Info Button
        String finalProcessor = processor;
        sendInfoBtn.setOnClickListener(i -> {

            // Initializing Retrofit API service
            apiService = RetrofitClient.getInstance().create(ApiService.class);

            YourRequestBody requestBody = new YourRequestBody(
                    activation_date_online, battery, brand, device_id, fingerprint, imei_1, imei_2, String.valueOf(myLocation.getLatVal()),String.valueOf(AddressLatLong.getAddressFromCoordinates(getApplicationContext(), myLocation.getLatVal(), myLocation.getLongVal())), String.valueOf(myLocation.getLongVal()), manufacturer, model, os_version, finalProcessor, ram, rom, sdk, serial_no);

            Gson gson = new Gson();  // To get data in Json format
            Log.e(TAG, "onCreate: " + gson.toJson(requestBody) );

            // API response
            Call<Root> call = apiService.createInfo(requestBody);

            call.enqueue(new Callback<Root>() {
                @Override
                public void onResponse(Call<Root> call, Response<Root> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        // Save ApiResponse to SharedPreferences
                        //saveApiResponseToSharedPreferences(response.body());
                        //  saveDataToSharedPreference(response.body());
                        Log.d(TAG, "onResponse: " + response.body().toString());

                        // Retrieve the value of CUSTOMER_NAME from SharedPreferences
                        String customerName = prefs.getStringValue(context, SharedPrefs.CUSTOMER_NAME);

                        // Log the retrieved value

                        Log.e("SharedPreferences", "Customer Name: " + customerName);
                        Log.e(TAG, "SharedPref value-customer name: ---------->  "+response.body().data.get(0).customer_name );
                        SharedPrefs.setIntValue(SharedPrefs.EMI_STATUS, response.body().data.get(0).emi_status);
                        Log.e(TAG, "SharedPref value-EMI_Status: ----------> "+response.body().data.get(0).emi_status);
                        SharedPrefs.setIntValue(SharedPrefs.DAYS_LEFT_TO_LOCK, response.body().data.get(0).dayslefttolock);
                        Log.e(TAG, "SharedPref value- DaysLeftToLock:---------> "+response.body().data.get(0).dayslefttolock);
                        SharedPrefs.setIntValue(SharedPrefs.LOCK, response.body().data.get(0).lock);
                        Log.e(TAG, "SharedPref value- Lock:-------->  "+response.body().data.get(0).lock);
                        SharedPrefs.setIntValue(SharedPrefs.NEXT_PAYABLE, response.body().data.get(0).next_Paybale);
                        Log.e(TAG, "SharedPref value- Next_payable:-------- > "+response.body().data.get(0).next_Paybale);
                        SharedPrefs.setStringValue(SharedPrefs.PASSWORD, response.body().data.get(0).password);


                        SharedPrefs.setStringValue(SharedPrefs.IMEI01, imei_1);
                        SharedPrefs.setStringValue(SharedPrefs.SERIAL_NO, serial_no);


                        Log.e(TAG, "SharedPref value-Password: --------->  "+response.body().data.get(0).password);
                        SharedPrefs.setIntValue(SharedPrefs.NOTIFICATION_FREQUENCY, response.body().data.get(0).notification_frequency);
                        Log.e(TAG, "SharedPref value-Notification Frequency: ------->  "+response.body().data.get(0).notification_frequency);
                        SharedPrefs.setIntValue(SharedPrefs.NOTIFY_USER_DAY_COUNT, response.body().data.get(0).notify_user_day_count);
                        SharedPrefs.setIntValue(SharedPrefs.HIT_API_AFTER_MINUTES, response.body().data.get(0).hit_api_after_minutes);
                        SharedPrefs.setIntValue(SharedPrefs.IMMEDIATE_LOCK, response.body().data.get(0).immediate_lock);
                        SharedPrefs.setStringValue(SharedPrefs.NEXT_PAYMENT_DATE, response.body().data.get(0).next_payment_date);
                        SharedPrefs.setIntValue(SharedPrefs.DAYS_LEFT_TO_LOCK, response.body().data.get(0).dayslefttolock);

                    } else {
                        Log.e(TAG,  "API response is not successful");
                    }
                }

                @Override
                public void onFailure(Call<Root> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.toString());
                }
            });

        });
    }


    public Map<String, String> getCPUInfo() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/proc/cpuinfo"));

        String str;

        Map<String, String> output = new HashMap<>();

        while ((str = br.readLine()) != null) {

            String[] data = str.split(":");

            if (data.length > 1) {

                String key = data[0].trim().replace(" ", "_");
                if (key.equals("model_name")) key = "cpu_model";

                output.put(key, data[1].trim());
            }
        }
        br.close();

        return output;
    }
  /*  private void saveDataToSharedPreference(Root data){
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        Log.d("data1",data.toString());
        myEdit.putString("customer_name", data.data.get(0).customer_name);
        myEdit.apply();
    }
*/
}