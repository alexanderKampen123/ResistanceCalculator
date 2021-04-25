package com.example.resi

object ValueMapping {
    fun getResistanceMapping(): HashMap<String, Double> {
        val values: HashMap<String, Double> = HashMap();

        values["black"] = 0.0;
        values["brown"] = 1.0;
        values["red"] = 2.0;
        values["orange"] = 3.0;
        values["yellow"] = 4.0;
        values["green"] = 5.0;
        values["blue"] = 6.0;
        values["violet"] = 7.0;
        values["gray"] = 8.0;
        values["white"] = 9.0;

        return values;
    }

    fun getMultiplierMapping(): HashMap<String, Double> {
        val values: HashMap<String, Double> = HashMap();

        values["silver"] = 0.01;
        values["gold"] = 0.1;
        values["black"] = 1.0;
        values["brown"] = 10.0;
        values["red"] = 100.0;
        values["orange"] = 1000.0;
        values["yellow"] = 10000.0;
        values["green"] = 100000.0;
        values["blue"] = 1000000.0;
        values["violet"] = 10000000.0;
        values["gray"] = 100000000.0;
        values["white"] = 1000000000.0;

        return values;
    }

    fun getToleranceMapping(): HashMap<String, Double> {
        val values: HashMap<String, Double> = HashMap();

        values["silver"] = 10.0;
        values["gold"] = 5.0;
        values["brown"] = 1.0;
        values["red"] = 2.0;
        values["green"] = 0.5;
        values["blue"] = 0.25;
        values["violet"] = 0.1;
        values["gray"] = 0.05;

        return values;
    }

    fun getTemperatureCoefficientsMapping(): HashMap<String, Double> {
        val values: HashMap<String, Double> = HashMap();

        values["brown"] = 100.0;
        values["red"] = 50.0;
        values["orange"] = 15.0;
        values["yellow"] = 25.0;
        values["blue"] = 10.0;
        values["violet"] = 5.0;
        values["white"] = 1.0;

        return values;
    }

    fun getColorMapping(): HashMap<String, Int> {
        val values: HashMap<String, Int> = HashMap();

        values["silver"] = R.drawable.circle_silver;
        values["gold"] = R.drawable.circle_gold;
        values["black"] = R.drawable.circle_black;
        values["brown"] = R.drawable.circle_brown;
        values["red"] = R.drawable.circle_red;
        values["orange"] = R.drawable.circle_orange;
        values["yellow"] = R.drawable.circle_yellow;
        values["green"] = R.drawable.circle_green;
        values["blue"] = R.drawable.circle_blue;
        values["violet"] = R.drawable.circle_violet;
        values["gray"] = R.drawable.circle_gray;
        values["white"] = R.drawable.circle_white;
        return values;
    }
}