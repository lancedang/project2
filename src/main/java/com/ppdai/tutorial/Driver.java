package com.ppdai.tutorial;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        DataSet dataSet = new DataSet(new String[]{"data/2013/HINT.csv", "data/2014/HINT.csv", "data/2015/HINT.csv"});
        System.out.println(dataSet.reportStatistics());

    }
}
