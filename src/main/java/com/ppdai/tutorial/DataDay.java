package com.ppdai.tutorial;

/**
 * @author CS2334. Modified by: ?????
 *         <p>
 *         Date: 2015-09-10 <BR>
 *         Project 1
 *         <p>
 *         This class represents a summary of one day's data from a single
 *         Mesonet station.
 */

public class DataDay extends StatisticAbstract {
    /**
     * Year in which the data were sampled
     */
    private int year;
    /**
     * Month in which  the data were sampled
     */
    private int month;
    /**
     * The day on which the data were sampled (1=January, 2=February, etc
     */
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
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    //继承自父类同自身属性
    public Sample getWindSpeedAverage() {
        // TODO Auto-generated method stub
        return windSpeedAverage;
    }

    @Override
    //继承自父类
    public Sample getSolarRadiationAverage() {
        // TODO Auto-generated method stub
        return solarRadiation;
    }

    @Override
    public DataDay getSolarRadiationMinDay() {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public DataDay getSolarRadiationMaxDay() {
        // TODO Auto-generated method stub
        return this;
    }

    /**
     * Describe the data for the day
     *
     * @return String describing the day
     */
    public String toString() {
        // TODO: complete the implementation
        if (this.getMonth() == 0) {
            return "0000 - 00, null: Wind = [invalid, invalid, invalid], Solar Radiation = invalid";
        }
        String mon = this.month < 10 ? "0" + this.month : this.month + "";
        String day = this.day < 10 ? "0" + this.day : this.day + "";


        return this.year + "-" + mon + "-" + day + ", " + this.stationID + ": Wind = [" + this.windSpeedMin + ", "
                + this.windSpeedAverage + ", " + this.windSpeedMax + "], " + "Solar Radiation = " + this.solarRadiation;
    }
}
