package com.example.Find_Device_Location;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Emi {
    @SerializedName("model")
    @Expose
    String model;
    @SerializedName("customer_name")
    @Expose
    String customer_name;
    @SerializedName("next_Paybale")
    @Expose
    String next_payment_amount;



    @SerializedName("emi_status")
    @Expose
    int emi_running;




    @SerializedName("next_payment_date")
    @Expose
    String next_payment_date;

    @SerializedName("Password")
    @Expose
    String emi_password;

    @SerializedName("hit_api_after_minutes")
    @Expose
    String hit_api_after_minutes;



    @SerializedName("lock")
    @Expose
    int acknowledment;



    public int notification_frequency;
    public int notify_user_day_count;
    public int dayslefttolock;
    public int immediate_lock;


    public String getHit_api_after_minutes() {
        return hit_api_after_minutes;
    }

    public void setHit_api_after_minutes(String hit_api_after_minutes) {
        this.hit_api_after_minutes = hit_api_after_minutes;
    }

    @Override
    public String toString() {
        return "Emi{" +
                "model='" + model + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", next_payment_amount='" + next_payment_amount + '\'' +
                ", emi_running=" + emi_running +
                ", next_payment_date='" + next_payment_date + '\'' +
                ", emi_password='" + emi_password + '\'' +
                ", acknowledment=" + acknowledment +
                ", notification_frequency=" + notification_frequency +
                ", notify_user_day_count=" + notify_user_day_count +
                ", dayslefttolock=" + dayslefttolock +
                ", immediate_lock=" + immediate_lock +
                '}';
    }

    public int getNotification_frequency() {
        return notification_frequency;
    }

    public void setNotification_frequency(int notification_frequency) {
        this.notification_frequency = notification_frequency;
    }

    public int getNotify_user_day_count() {
        return notify_user_day_count;
    }

    public void setNotify_user_day_count(int notify_user_day_count) {
        this.notify_user_day_count = notify_user_day_count;
    }

    public int getDayslefttolock() {
        return dayslefttolock;
    }

    public void setDayslefttolock(int dayslefttolock) {
        this.dayslefttolock = dayslefttolock;
    }

    public int getImmediate_lock() {
        return immediate_lock;
    }

    public void setImmediate_lock(int immediate_lock) {
        this.immediate_lock = immediate_lock;
    }



    public int getAcknowledment() {
        return acknowledment;
    }

    public void setAcknowledment(int acknowledment) {
        this.acknowledment = acknowledment;
    }






    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmi_password() {
        return emi_password;
    }

    public void setEmi_password(String emi_password) {
        this.emi_password = emi_password;
    }

    public String getNext_payment_amount() {
        return next_payment_amount;
    }

    public void setNext_payment_amount(String next_payment_amount) {
        this.next_payment_amount = next_payment_amount;
    }

    public String getNext_payment_date() {
        return next_payment_date;
    }

    public void setNext_payment_date(String next_payment_date) {
        this.next_payment_date = next_payment_date;
    }

    public int getEmi_running() {
        return emi_running;
    }

    public void setEmi_running(int emi_running) {
        this.emi_running = emi_running;
    }






}

