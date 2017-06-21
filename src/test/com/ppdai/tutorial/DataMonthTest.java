package com.ppdai.tutorial;

import com.ppdai.tutorial.DataDay;
import com.ppdai.tutorial.DataMonth;
import com.ppdai.tutorial.Sample;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * DataMonth Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 18, 2017</pre>
 */
public class DataMonthTest {

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
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
            //System.out.println(dayLine);
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

        //System.out.println(month.toString());
        Assert.assertEquals(result, month.toString());
        //test empyt month
        DataMonth emptyMonth = new DataMonth();
        String result2 = "0000 - 00, null: Wind = [invalid, invalid, invalid], Solar Radiation = [invalid, invalid, invalid]";
        Assert.assertEquals(result2, emptyMonth.toString());
    }


} 
