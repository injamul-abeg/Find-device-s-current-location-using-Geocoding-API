package com.example.Find_Device_Location;

public class YourRequestBody{
    public String activation_date_online;
    public String battery;
    public String brand;
    public String device_id;
    public String fingerprint;
    public String imei_1;
    public String imei_2;
    public String latitude;
    public String location;
    public String longitude;
    public String manufacturer;
    public String model;
    public String os_version;
    public String processor;
    public String ram;
    public String rom;
    public String sdk;
    public String serial_no;


    public String getActivation_date_online() {
        return activation_date_online;
    }

    public void setActivation_date_online(String activation_date_online) {
        this.activation_date_online = activation_date_online;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getImei_1() {
        return imei_1;
    }

    public void setImei_1(String imei_1) {
        this.imei_1 = imei_1;
    }

    public String getImei_2() {
        return imei_2;
    }

    public void setImei_2(String imei_2) {
        this.imei_2 = imei_2;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    @Override
    public String toString() {
        return "YourRequestBody{" +
                "activation_date_online='" + activation_date_online + '\'' +
                ", battery='" + battery + '\'' +
                ", brand='" + brand + '\'' +
                ", device_id='" + device_id + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", imei_1='" + imei_1 + '\'' +
                ", imei_2='" + imei_2 + '\'' +
                ", latitude='" + latitude + '\'' +
                ", location='" + location + '\'' +
                ", longitude='" + longitude + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", os_version='" + os_version + '\'' +
                ", processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                ", sdk='" + sdk + '\'' +
                ", serial_no='" + serial_no + '\'' +
                '}';
    }

    public YourRequestBody(String activation_date_online, String battery, String brand, String device_id, String fingerprint, String imei_1, String imei_2, String latitude, String location, String longitude, String manufacturer, String model, String os_version, String processor, String ram, String rom, String sdk, String serial_no) {
        this.activation_date_online = activation_date_online;
        this.battery = battery;
        this.brand = brand;
        this.device_id = device_id;
        this.fingerprint = fingerprint;
        this.imei_1 = imei_1;
        this.imei_2 = imei_2;
        this.latitude = latitude;
        this.location = location;
        this.longitude = longitude;
        this.manufacturer = manufacturer;
        this.model = model;
        this.os_version = os_version;
        this.processor = processor;
        this.ram = ram;
        this.rom = rom;
        this.sdk = sdk;
        this.serial_no = serial_no;
    }
}
