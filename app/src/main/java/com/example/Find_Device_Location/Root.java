package com.example.Find_Device_Location;

import java.util.ArrayList;

public class Root {

    @Override
    public String toString() {
        return "Root{" +
                "status=" + status +
                ", activation=" + activation +
                ", data=" + data +
                '}';
    }

    public int status;
    public boolean activation;
    public ArrayList<ApiResponse> data;
}
