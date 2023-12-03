package com.example.Find_Device_Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WEmi {
    @SerializedName("data")
    @Expose
    ArrayList<Emi> emiArrayList;

    public ArrayList<Emi> getEmiArrayList() {
        return emiArrayList;
    }

    public void setEmiArrayList(ArrayList<Emi> emiArrayList) {
        this.emiArrayList = emiArrayList;
    }

    @Override
    public String toString() {
        return "WEmi{" +
                "emiArrayList=" + emiArrayList +
                '}';
    }
}
