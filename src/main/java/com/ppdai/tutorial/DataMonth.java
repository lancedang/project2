package com.ppdai.tutorial;

import java.util.ArrayList;

/**
 * @author CS2334. Modified by: ?????
 *         <p>
 *         Date: 2015-09-10 <BR>
 *         Project 1
 *         <p>
 *         This class represents the data for all of the days within a single
 *         month
 */

public class DataMonth extends MultiStatisticAbstract {
    /**
     * The set of days.
     */
    private ArrayList<DataDay> days;

    private int year;
    private int month;

    private String stationID;

    public DataMonth() {
        // TODO Auto-generated constructor stub
        days = new ArrayList<>();
    }

    public void addDay(DataDay day) {
        //初始化月份的 year, month, stationId 属性
        if (this.year == 0) {
            this.year = day.getYear();
        }
        if (this.month == 0) {
            this.month = day.getMonth();
        }
        if (this.stationID == null) {
            this.stationID = day.getStationID();
        }
        days.add(day);
    }

    //protected-> public
    @Override
    public DataDay getItem(int i) {
        return days.get(i);
    }

    @Override
    public int itemCount() {
        return days.size();
    }

    /**
     * Describe the month
     *
     * @return A string describing all of the days and the statistics for the
     * month
     */
    public String toString() {
        //output like "06"
        DataDay minWindDay = getWindSpeedMinDay();
        DataDay maxWindDay = getWindSpeedMaxDay();

        DataDay minSolarDay = getSolarRadiationMinDay();
        DataDay maxSolarDay = getSolarRadiationMaxDay();

        Sample windA = getWindSpeedAverage();
        Sample solarA = getSolarRadiationAverage();

        //当返回无效dataday时,无效dataday的属性都未初始化
        if (minWindDay == null || minWindDay.getMonth() == 0) {
            return "0000 - 00, null: Wind = [invalid, invalid, invalid], Solar Radiation = [invalid, invalid, invalid]";
        }

        String windMin = String.format("%.4f", minWindDay.getWindSpeedMin().getValue());
        String windAve = String.format("%.4f", windA.getValue());
        String windMax = String.format("%.4f", maxWindDay.getWindSpeedMax().getValue());

        String solarMin = String.format("%.4f", minSolarDay.getSolarRadiation().getValue());
        String solarAve = String.format("%.4f", solarA.getValue());
        String solarMax = String.format("%.4f", maxSolarDay.getSolarRadiation().getValue());

        String mon = this.month < 10 ? "0" + this.month : this.month + "";

        String result = year + " - " + mon + ", " + stationID + ": Wind = [" +
                windMin + ", " + windAve + ", " + windMax + "], Solar Radiation = [" +
                solarMin + ", " + solarAve + ", " + solarMax + "]";
        return result;
    }

}
