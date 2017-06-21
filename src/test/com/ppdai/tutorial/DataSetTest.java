package com.ppdai.tutorial;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * DataSet Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 22, 2017</pre>
 */
public class DataSetTest {
    /**
     * Method: reportStatistics()
     */
    @Test
    public void testReportStatistics() throws Exception {
        DataSet dataSet = new DataSet(new String[]{"data/2013/HINT.csv", "data/2014/HINT.csv", "data/2015/HINT.csv"});

        String result = "Max Wind Speed:\n" +
                "2015-12-26, HINT: Wind = [1.5700, 20.3200, 41.0500], Solar Radiation = 0.4900\n" +
                "Average Wind Speed:\n" +
                "12.0708\n" +
                "Min Wind Speed:\n" +
                "2014-10-28, HINT: Wind = [0.0000, 9.6000, 23.3800], Solar Radiation = 13.1900\n" +
                "Max Solar Radiation:\n" +
                "2013-06-09, HINT: Wind = [1.1900, 6.9500, 18.7200], Solar Radiation = 31.2500\n" +
                "Average Solar Radiation:\n" +
                "17.6787\n" +
                "Min Solar Radiation:\n" +
                "2015-12-26, HINT: Wind = [1.5700, 20.3200, 41.0500], Solar Radiation = 0.4900";
        Assert.assertEquals(result, dataSet.reportStatistics());
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
        DataSet dataSet = new DataSet(new String[]{"data/2013/HINT.csv", "data/2014/HINT.csv", "data/2015/HINT.csv"});
        String result = "Data Set: Wind = [0.0000, 12.0708, 41.0500], Solar Radiation = [0.4900, 17.6787, 31.2500]";
        Assert.assertEquals(result, dataSet.toString());
    }


}
