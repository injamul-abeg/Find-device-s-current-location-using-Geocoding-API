package com.example.Find_Device_Location;

public class ApiResponse{
    public int emi_status;
    public String customer_name;
    public int lock;
    public int next_Paybale;

    public String password;
    public int notification_frequency;
    public int notify_user_day_count;
    public int dayslefttolock;
    public int hit_api_after_minutes;
    public int immediate_lock;
    public String next_payment_date;

    @Override
    public String toString() {
        return "Root{" +
                "emi_status=" + emi_status +
                ", customer_name='" + customer_name + '\'' +
                ", lock=" + lock +
                ", next_Paybale=" + next_Paybale +
                ", password='" + password + '\'' +
                ", notification_frequency=" + notification_frequency +
                ", notify_user_day_count=" + notify_user_day_count +
                ", dayslefttolock=" + dayslefttolock +
                ", hit_api_after_minutes=" + hit_api_after_minutes +
                ", immediate_lock=" + immediate_lock +
                ", next_payment_date='" + next_payment_date + '\'' +
                '}';
    }

    public ApiResponse(int emi_status, String customer_name, int lock, int next_Paybale, String password, int notification_frequency, int notify_user_day_count, int dayslefttolock, int hit_api_after_minutes, int immediate_lock, String next_payment_date) {
        this.emi_status = emi_status;
        this.customer_name = customer_name;
        this.lock = lock;
        this.next_Paybale = next_Paybale;
        this.password = password;
        this.notification_frequency = notification_frequency;
        this.notify_user_day_count = notify_user_day_count;
        this.dayslefttolock = dayslefttolock;
        this.hit_api_after_minutes = hit_api_after_minutes;
        this.immediate_lock = immediate_lock;
        this.next_payment_date = next_payment_date;
    }

    public int getEmi_status() {
        return emi_status;
    }

    public void setEmi_status(int emi_status) {
        this.emi_status = emi_status;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }

    public int getNext_Paybale() {
        return next_Paybale;
    }

    public void setNext_Paybale(int next_Paybale) {
        this.next_Paybale = next_Paybale;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getHit_api_after_minutes() {
        return hit_api_after_minutes;
    }

    public void setHit_api_after_minutes(int hit_api_after_minutes) {
        this.hit_api_after_minutes = hit_api_after_minutes;
    }

    public int getImmediate_lock() {
        return immediate_lock;
    }

    public void setImmediate_lock(int immediate_lock) {
        this.immediate_lock = immediate_lock;
    }

    public String getNext_payment_date() {
        return next_payment_date;
    }

    public void setNext_payment_date(String next_payment_date) {
        this.next_payment_date = next_payment_date;
    }

}