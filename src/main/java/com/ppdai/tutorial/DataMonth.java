package com.ppdai.tutorial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents the data for all of the days within a single
 * month
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
        //初始化月份的 year, month, stationId 属性,year为0表明第一次添加dataday
        if (this.year == 0) {
            this.year = day.getYear();
            this.month = day.getMonth();
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

        Sample windMin = minWindDay.getWindSpeedMin();
        Sample windMax = maxWindDay.getWindSpeedMax();
        Sample solarMin = minSolarDay.getSolarRadiation();
        Sample solarMax = maxSolarDay.getSolarRadiation();

        String mon = this.month < 10 ? "0" + this.month : this.month + "";

        String result = year + " - " + mon + ", " + stationID + ": Wind = [" +
                windMin + ", " + windA + ", " + windMax + "], Solar Radiation = [" +
                solarMin + ", " + solarA + ", " + solarMax + "]";
        return result;
    }

    public static void main(String[] args) throws IOException {

        //TODO: Test goes here...
        DataMonth month = new DataMonth();

        FileReader fileReader = new FileReader("data/test.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        DataDay dataDay;

        String dayLine = bufferedReader.readLine();
        //dayLine = bufferedReader.readLine();
        boolean flag = true;

        while (dayLine != null) {
            // get every item
            System.out.println(dayLine);
            String[] items = dayLine.split(",");

            int year = Integer.parseInt(items[0]);
            int mon = Integer.parseInt(items[1]);
            int day = Integer.parseInt(items[2]);

            String stationID = items[3];

            Sample solarRadiation = new Sample(Double.parseDouble(items[4]));

            Sample windSpeedMax = new Sample(Double.parseDouble(items[5]));
            Sample windSpeedMin = new Sample(Double.parseDouble(items[6]));
            Sample windSpeedAverage = new Sample(Double.parseDouble(items[7]));

            //无效sample导致无效dataday
            dataDay = new DataDay(year, mon, day, stationID, solarRadiation, windSpeedMax, windSpeedMin,
                    windSpeedAverage);

            //months.get(month-1).addDay(dataDay);
            month.addDay(dataDay);

            // read next line
            dayLine = bufferedReader.readLine();
        }

        // close file
        fileReader.close();
        bufferedReader.close();

        String result = "2015 - 11, TISH: Wind = [0.0000, 8.9807, 28.8100], " +
                "Solar Radiation = [0.9000, 8.8883, 15.2500]";
        System.out.println("--------------------");

        System.out.println(month.toString());

        DataMonth emptyMonth = new DataMonth();
        System.out.println(emptyMonth.toString());


    }


}
