package test.com.ppdai.tutorial;

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

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addDay(DataDay day)
     */
    @Test
    public void testAddDay() throws Exception {
        //TODO: Test goes here...
        DataMonth month = new DataMonth();
        Sample solarRadation = new Sample(30.1234);
        Sample windMin = new Sample(3.1234);
        Sample windAve = new Sample(13.1234);
        Sample windMax = new Sample(23.1234);
        DataDay dataDay1 = new DataDay(2017, 6, 3, "station", solarRadation, windMax, windMin, windAve);
        DataDay dataDay2 = new DataDay(2017, 6, 3, "station", solarRadation, windMax, windMin, windAve);

        month.addDay(dataDay1);
        month.addDay(dataDay2);

        Assert.assertEquals(dataDay1, month.getItem(0));
        Assert.assertEquals(dataDay2, month.getItem(1));
        //Assert.assertEquals(2017, mon);
    }

    /**
     * Method: getItem(int i)
     */
    @Test
    public void testGetItem() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: itemCount()
     */
    @Test
    public void testItemCount() throws Exception {
        //TODO: Test goes here...
    }

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
        System.out.print(dayLine);
        while (dayLine != null) {
            // get every item
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
            if (!solarRadiation.isValid()) {
                dataDay = new DataDay();
            } else {
                dataDay = new DataDay(year, mon, day, stationID, solarRadiation, windSpeedMax, windSpeedMin,
                        windSpeedAverage);
            }
            //months.get(month-1).addDay(dataDay);
            month.addDay(dataDay);

            // read next line
            dayLine = bufferedReader.readLine();
        }

        // close file
        fileReader.close();
        bufferedReader.close();

        /*
        Sample solarRadation = new Sample(30.1234);
        Sample windMin = new Sample(3.1234);
        Sample windAve = new Sample(13.1234);
        Sample windMax = new Sample(23.1234);
        DataDay dataDay1 = new DataDay(2017, 6, 3, "station", solarRadation, windMax, windMin, windAve);
        DataDay dataDay2 = new DataDay(2017, 6, 3, "station", solarRadation, windMax, windMin, windAve);

        month.addDay(dataDay1);
        month.addDay(dataDay2);



        String result = "2017 - 06, station: Wind = " +
                "[3.1234, 13.1234, 23.1234], Solar Radiation = " +
                "[30.1234, 30.1234, 30.1234]";

        */

        String result = "2015 - 11, TISH: Wind = [0.0000, 8.9807, 28.8100], " +
                "Solar Radiation = [0.9000, 8.8883, 15.2500]";

        Assert.assertEquals(result, month.toString());

        /*
        DataDay day_invalid1 = new DataDay();
        DataDay day_invalid2 = new DataDay();

        DataMonth month2 = new DataMonth();
        month2.addDay(day_invalid1);
        month2.addDay(day_invalid2);

        String result2 = "0000 - 00, null: Wind = [invalid, invalid, invalid], " +
                "Solar Radiation = [invalid, invalid, invalid]";

        Assert.assertEquals(result2, month2.toString());
        */
    }


} 
