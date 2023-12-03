package com.example.Find_Device_Location;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPrefs {

    private static final String PREFERENCES_NAME = "MyPrefs";
    private static final String API_RESPONSE_KEY = "apiResponse";

    // Keys for individual preferences
    public static final String IMEI01 = "imei_1";
    public static final String IMEI02 = "imei_2";
    public static final String SERIAL_NO = "SERIAL_NO";
    public static final String EMI_STATUS = "EMI_Status";
    public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String LOCK = "lock";
    public static final String NEXT_PAYABLE = "NEXT_PAYABLE";
    public static final String PASSWORD = "PASSWORD";
    public static final String NOTIFICATION_FREQUENCY = "NOTIFICATION_FREQUENCY";
    public static final String NOTIFY_USER_DAY_COUNT = "NOTIFY_USER_DAY_COUNT";
    public static final String DAYS_LEFT_TO_LOCK = "DAYS_LEFT_TO_CLOCK";
    public static final String HIT_API_AFTER_MINUTES = "HIT_API_AFTER_MINUTES";
    public static final String IMMEDIATE_LOCK = "IMMEDIATE_LOCK";
    public static final String NEXT_PAYMENT_DATE = "NEXT_PAYMENT_DATE";

    private static SharedPreferences prefs;
    private static Gson gson;

    private SharedPrefs(Context context) {
        prefs = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public static SharedPrefs getInstance(Context context) {
        return new SharedPrefs(context);
    }
    public static String getStringValue(Context context, String key) {
        return prefs.getString(key, "");
    }
    public static void setStringValue(String key, String value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void setIntValue(String key, int value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getIntValue(String key) {
        return prefs.getInt(key, 0);
    }

    public void setLongValue(String key, long value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public long getLongValue(String key) {
        return prefs.getLong(key, 0);
    }
}
