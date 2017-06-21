package com.ppdai.tutorial;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * DataYear Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 22, 2017</pre>
 */
public class DataYearTest {
    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
        DataYear year = new DataYear("data/2015/TISH.csv");
        DataYear year2 = new DataYear("data/2013/HINT.csv");

        String result = "2015, TISH: Wind = [0.0000, 7.8934, 40.5300], Solar Radiation = [0.4000, 15.7975, 30.3500]";
        Assert.assertEquals(result, year.toString());

        String result2 = "2013, HINT: Wind = [0.0700, 12.1837, 39.1700], Solar Radiation = [1.7500, 18.3217, 31.2500]";
        Assert.assertEquals(result2, year2.toString());
    }


} 
