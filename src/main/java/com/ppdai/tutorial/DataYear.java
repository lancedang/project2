package com.ppdai.tutorial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataYear extends MultiStatisticAbstract {
    private int year;
    private String stationID;
    private List<DataMonth> months;

    public DataYear(String fileName) throws IOException {
        months = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            months.add(new DataMonth());
        }

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        DataDay dataDay;

        String dayLine = bufferedReader.readLine();
        dayLine = bufferedReader.readLine();
        boolean flag = true;

        while (dayLine != null) {
            // get every item
            String[] items = dayLine.split(",");

            int year = Integer.parseInt(items[0]);
            int month = Integer.parseInt(items[1]);
            int day = Integer.parseInt(items[2]);

            String stationID = items[3];

            // initialize the DataMonth's year and month only once
            if (flag) {
                this.year = year;
                this.stationID = stationID;
                flag = false;
            }

            Sample solarRadiation = new Sample(Double.parseDouble(items[4]));

            Sample windSpeedMax = new Sample(Double.parseDouble(items[5]));
            Sample windSpeedMin = new Sample(Double.parseDouble(items[6]));
            Sample windSpeedAverage = new Sample(Double.parseDouble(items[7]));

            //无效sample导致无效dataday
            dataDay = new DataDay(year, month, day, stationID, solarRadiation, windSpeedMax, windSpeedMin,
                    windSpeedAverage);

            //months.get(month-1).addDay(dataDay);
            addDay(dataDay);

            // read next line
            dayLine = bufferedReader.readLine();
        }

        // close file
        fileReader.close();
        bufferedReader.close();
    }

    /**
     * 根据日期所属月份，将其放入相应month中
     *
     * @param day
     */
    protected void addDay(DataDay day) {
        int month_index = day.getMonth();
        months.get(month_index - 1).addDay(day);
    }

    @Override
    protected DataMonth getItem(int i) {
        return months.get(i);
    }

    @Override
    protected int itemCount() {
        return months.size();
    }

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

        String result = year + ", " + this.stationID + ": Wind = [" +
                windMin + ", " + windA + ", " + windMax + "], Solar Radiation = [" +
                solarMin + ", " + solarA + ", " + solarMax + "]";
        return result;
    }

    public static void main(String[] args) throws IOException {
        DataYear year = new DataYear("data/2015/TISH.csv");
        DataYear year2 = new DataYear("data/2013/HINT.csv");
        System.out.println(year);
        System.out.println(year2);
    }
}
