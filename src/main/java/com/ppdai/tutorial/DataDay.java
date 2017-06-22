package com.ppdai.tutorial;

public class DataDay extends StatisticAbstract {

    private int year;
    private int month;
    private int day;

    // TODO: Fill in remaining components
    private String stationID;

    private Sample windSpeedMax;
    private Sample windSpeedMin;
    private Sample windSpeedAverage;
    private Sample solarRadiation;

    public DataDay() {
        // TODO Auto-generated constructor stub
    }

    /**
     * DataDay constructor
     *
     * @param year             Year of the sample
     * @param month            Month of the sample
     * @param day              Day of the sample
     * @param solarRadiation   Amount of solar radiation (in Mj/m^2)
     * @param stationID        Station identifier
     * @param windSpeedMin     Minimum wind speed
     * @param windSpeedAverage Average wind speed
     * @param windSpeedMax     Maximum wind speed
     */
    public DataDay(int year, int month, int day, String stationID, Sample solarRadiation, Sample windSpeedMax, Sample windSpeedMin,
                   Sample windSpeedAverage) {
        // TODO: complete implementation
        this.year = year;
        this.month = month;
        this.day = day;
        this.stationID = stationID;
        this.solarRadiation = solarRadiation; //column ATOT in csv file
        this.windSpeedMin = windSpeedMin;
        this.windSpeedAverage = windSpeedAverage;
        this.windSpeedMax = windSpeedMax;
    }

    // TODO: supply the getters

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getStationID() {
        return stationID;
    }

    //自身get属性
    public Sample getWindSpeedMax() {
        return windSpeedMax;
    }

    //自身get属性
    public Sample getWindSpeedMin() {
        return windSpeedMin;
    }

    //自身get属性
    public Sample getSolarRadiation() {
        return solarRadiation;
    }

    @Override
    public DataDay getWindSpeedMinDay() {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public DataDay getWindSpeedMaxDay() {
        return this;
    }

    @Override
    //继承自父类同自身属性
    public Sample getWindSpeedAverage() {
        return windSpeedAverage;
    }

    @Override
    //继承自父类
    public Sample getSolarRadiationAverage() {
        return solarRadiation;
    }

    @Override
    public DataDay getSolarRadiationMinDay() {
        return this;
    }

    @Override
    public DataDay getSolarRadiationMaxDay() {
        // TODO Auto-generated method stub
        return this;
    }

    public String toString() {
        // 当为无效dataday时
        if (this.getYear() == 0) {
            return "0000 - 00, null: Wind = [invalid, invalid, invalid], Solar Radiation = invalid";
        }
        String mon = this.month < 10 ? "0" + this.month : this.month + "";
        String day = this.day < 10 ? "0" + this.day : this.day + "";

        return this.year + "-" + mon + "-" + day + ", " + this.stationID + ": Wind = [" + this.windSpeedMin + ", "
                + this.windSpeedAverage + ", " + this.windSpeedMax + "], " + "Solar Radiation = " + this.solarRadiation;
    }
}
