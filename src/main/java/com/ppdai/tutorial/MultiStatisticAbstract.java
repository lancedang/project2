package com.ppdai.tutorial;

public abstract class MultiStatisticAbstract extends StatisticAbstract {
    protected abstract StatisticAbstract getItem(int i);

    protected abstract int itemCount();

    @Override
    public Sample getWindSpeedAverage() {
        // TODO Auto-generated method stub
        int count = itemCount();
        //空sample表示无效样本
        if (count == 0 || getItem(0).getWindSpeedMinDay().getMonth() == 0) {
            return new Sample();
        }
        double sum = 0;
        int invalid_count = 0;
        for (int i = 0; i < count; i++) {
            //判断dataday是否有效
            Sample tmp = getItem(i).getWindSpeedAverage();
            if(tmp == null || !tmp.isValid()) {
                invalid_count++;
                continue;
            }

            sum += tmp.getValue();
        }
        Sample result = new Sample(sum / (count - invalid_count));
        return result;
    }

    @Override
    public DataDay getWindSpeedMaxDay() {
        // TODO Auto-generated method stub
        int count = itemCount();
        //空dataday表示无效对象
        if (count == 0 || getItem(0).getWindSpeedMinDay().getMonth() == 0) {
            return new DataDay();
        }
        Sample max = new Sample();

        int j;
        //get the first valid sample
        for (j = 0; j < count; j++) {
            Sample max1 = getItem(j).getWindSpeedMaxDay().getWindSpeedMax();
            if (max1.isValid()) {
                max = max1;
                break;
            }
        }

        int dayIndex = 0;
        for (int i = j + 1; i < count; i++) {
            Sample tmp = getItem(i).getWindSpeedMaxDay().getWindSpeedMax();
            if(tmp == null || !tmp.isValid()) {
                continue;
            }
            if (max.isLessThan(tmp)) {
                max = tmp;
                //记录最大值天的index
                dayIndex = i;
            }

        }
        DataDay maxDay = getItem(dayIndex).getWindSpeedMaxDay();
        return maxDay;
    }

    @Override
    public DataDay getWindSpeedMinDay() {
        // TODO Auto-generated method stub
        int count = itemCount();
        //空dataday表示无效对象
        if (count == 0) {
            return new DataDay();
        }
        Sample min = new Sample();
        int j;
        //get the first valid sample
        for (j = 0; j < count; j++) {
            Sample min1 = getItem(j).getWindSpeedMinDay().getWindSpeedMin();
            if (min1.isValid()) {
                min = min1;
                break;
            }
        }

        int dayIndex = 0;
        for (int i = j + 1; i < count; i++) {
            //StatisticAbstract tmpItem = getItem(i);

            //tmpItem = getItem(i);
            Sample tmp = getItem(i).getWindSpeedMinDay().getWindSpeedMin();
            if(tmp == null || !tmp.isValid()) {
                continue;
            }
            if (min.isGreaterThan(tmp)) {
                min = tmp;
                dayIndex = i;
            }

        }
        DataDay minDay = getItem(dayIndex).getWindSpeedMinDay();
        return minDay;
    }

    @Override
    public Sample getSolarRadiationAverage() {
        // TODO Auto-generated method stub
        int count = itemCount();
        //空sample表示无效样本
        if (count == 0 || getItem(0).getWindSpeedMinDay().getMonth() == 0) {
            return new Sample();
        }
        double sum = 0;
        int invalid_count = 0;
        for (int i = 0; i < count; i++) {

            Sample tmp = getItem(i).getSolarRadiationAverage();
            if(tmp == null || !tmp.isValid()) {
                invalid_count++;
                continue;
            }

            sum += tmp.getValue();
        }
        Sample result = new Sample(sum / (count - invalid_count));
        return result;
    }

    @Override
    public DataDay getSolarRadiationMaxDay() {
        // TODO Auto-generated method stub
        int count = itemCount();
        //空dataday表示无效对象
        if (count == 0 || getItem(0).getWindSpeedMinDay().getMonth() == 0) {
            return new DataDay();
        }
        //Sample max = getItem(0).getSolarRadiationMaxDay().getSolarRadiation();
        Sample max = new Sample();
        int j;
        //get the first valid sample
        for (j = 0; j < count; j++) {
            Sample max1 = getItem(j).getSolarRadiationMaxDay().getSolarRadiation();
            if (max1.isValid()) {
                max = max1;
                break;
            }
        }

        int dayIndex = 0;
        for (int i = j + 1; i < count; i++) {
            Sample tmp = getItem(i).getSolarRadiationMaxDay().getSolarRadiation();
            //排除无效sample，确保有效sample之间的比较

            if(tmp == null || !tmp.isValid()) {
                continue;
            }

            if (max.isLessThan(tmp)) {
                max = tmp;
                dayIndex = i;
            }
        }
        DataDay maxDay = getItem(dayIndex).getSolarRadiationMaxDay();
        return maxDay;
    }

    @Override
    public DataDay getSolarRadiationMinDay() {
        // TODO Auto-generated method stub
        int count = itemCount();
        //空dataday表示无效对象
        if (count == 0 || getItem(0).getWindSpeedMinDay().getMonth() == 0) {
            return new DataDay();
        }

        Sample min = new Sample();
        int j;
        //get the first valid sample
        for (j = 0; j < count; j++) {
            Sample min1 = getItem(j).getSolarRadiationMaxDay().getSolarRadiation();
            if (min1.isValid()) {
                min = min1;
                break;
            }
        }

        int dayIndex = 0;
        for (int i = j + 1; i < count; i++) {
            Sample tmp = getItem(i).getSolarRadiationMinDay().getSolarRadiation();
            if(tmp == null || !tmp.isValid()) {
                continue;
            }
            if (min.isGreaterThan(tmp)) {
                min = tmp;
                dayIndex = i;
            }
        }
        DataDay minDay = getItem(dayIndex).getSolarRadiationMinDay();
        return minDay;
    }

}
