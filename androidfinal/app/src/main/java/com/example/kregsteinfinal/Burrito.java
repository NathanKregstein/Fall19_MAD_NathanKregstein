package com.example.kregsteinfinal;

public class Burrito {
    private String location;
    private String locationURL;


    public String getLocation() {
        return location;
    }

    public String getLocationURL() {
        return locationURL;
    }

    public void setVar(int op) {
        switch (op){
            case 0:
                location = "Illegal Petes";
                locationURL = "http://illegalpetes.com/";
                break;
            case 1:
                location = "Chipotle";
                locationURL = "https://www.chipotle.com/";
                break;
            case 2:
                location = "Bartaco";
                locationURL = "https://bartaco.com/";
                break;
            default:
                location = "Wherever Probably Illegal Petes";
                locationURL = "http://illegalpetes.com/";
                break;
        }

    }
}
