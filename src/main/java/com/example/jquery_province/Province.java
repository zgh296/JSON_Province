package com.example.jquery_province;

public class Province {
    private String cityname;
    private String cityvalue;
    public Province() {}
    public Province(String cityname, String cityvalue) {
        super();
        this.cityname = cityname;
        this.cityvalue = cityvalue;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCityvalue() {
        return cityvalue;
    }

    public void setCityvalue(String cityvalue) {
        this.cityvalue = cityvalue;
    }

}