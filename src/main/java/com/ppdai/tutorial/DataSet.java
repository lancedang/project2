package com.ppdai.tutorial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dangdang on 2017/6/21.
 */
public class DataSet extends MultiStatisticAbstract {
    private List<DataYear> years;

    public DataSet(String[] fileNames) throws IOException {
        years = new ArrayList<>();
        int len = fileNames.length;
        DataYear dataYear;

        for (int i = 0; i < len; i++) {
            dataYear = new DataYear(fileNames[i]);
            years.add(dataYear);
        }

    }

    protected DataYear getItem(int i) {
        return years.get(i);
    }

    protected int itemCount() {
        return years.size();
    }

    public String reportStatistics() {
        DataDay minWindDay = getWindSpeedMinDay();
        DataDay maxWindDay = getWindSpeedMaxDay();

        DataDay minSolarDay = getSolarRadiationMinDay();
        DataDay maxSolarDay = getSolarRadiationMaxDay();

        Sample windA = getWindSpeedAverage();
        Sample solarA = getSolarRadiationAverage();

        Sample windMin = minWindDay.getWindSpeedMin();
        Sample windMax = maxWindDay.getWindSpeedMax();
        Sample solarMin = minSolarDay.getSolarRadiation();
        Sample solarMax = maxSolarDay.getSolarRadiation();

        String result = "Max Wind Speed:\n" +
                maxWindDay + "\n" +
                "Average Wind Speed:\n" +
                windA + "\n"+
                "Min Wind Speed:\n" +
                minWindDay + "\n" +
                "Max Solar Radiation:\n"+
                maxSolarDay + "\n"+
                "Average Solar Radiation:\n" +
                solarA+"\n" +
                "Min Solar Radiation:\n" +
                minSolarDay;


        return result;
    }

    @Override
    public String toString() {
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

        String result = "Data Set: Wind = [" +
                windMin + ", " + windA + ", " + windMax + "], Solar Radiation = [" +
                solarMin + ", " + solarA + ", " + solarMax + "]";

        return result;
    }

    public static void main(String[] args) throws IOException {

        DataSet dataSet = new DataSet(new String[]{"data/2013/HINT.csv", "data/2014/HINT.csv", "data/2015/HINT.csv"});
        System.out.println(dataSet);

        System.out.println(dataSet.reportStatistics());
    }
}
