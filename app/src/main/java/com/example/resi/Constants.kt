package com.example.resi

object Constants {
    const val NUMBER_OF_RINGS_4 = 4
    const val NUMBER_OF_RINGS_5 = 5
    const val NUMBER_OF_RINGS_6 = 6

    const val RING_TYPE_RESISTANCE = 1
    const val RING_TYPE_MULTIPLIER = 2
    const val RING_TYPE_TOLERANCE = 3
    const val RING_TYPE_TEMPERATURE_COEFFICIENT = 4

    fun getColors(): HashMap<String, Color>{
        val colors: HashMap<String, Color> = HashMap()

        colors["silver"] = Color("silver", "Silber")
        colors["gold"] = Color("gold", "Gold")
        colors["black"] = Color("black", "Schwarz")
        colors["brown"] = Color("brown", "Braun")
        colors["red"] = Color("red", "Rot")
        colors["orange"] = Color("orange", "Orange")
        colors["yellow"] = Color("yellow", "Gelb")
        colors["green"] = Color("green", "Grün")
        colors["blue"] = Color("blue", "Blau")
        colors["violet"] = Color("violet", "Violett")
        colors["gray"] = Color("gray", "Grau")
        colors["white"] = Color("white", "Weiß")

        return colors;
    }

    fun getResistanceRings(isFirst: Boolean): ArrayList<Ring> {
        val rings: ArrayList<Ring> = this.getRings(ValueMapping.getResistanceMapping(), RING_TYPE_RESISTANCE);

        if(isFirst){
            rings.removeAt(0);
        }

        return rings;
    }

    fun getMultiplierRings(): ArrayList<Ring> {
        return this.getRings(ValueMapping.getMultiplierMapping(), RING_TYPE_MULTIPLIER);
    }

    fun getToleranceRings(): ArrayList<Ring> {
        return this.getRings(ValueMapping.getToleranceMapping(), RING_TYPE_TOLERANCE)
    }

    fun getTemperatureCoefficientRings(): ArrayList<Ring> {
        return this.getRings(ValueMapping.getTemperatureCoefficientsMapping(), RING_TYPE_TEMPERATURE_COEFFICIENT)
    }

    fun getRings(values: HashMap<String, Double>, type: Int): ArrayList<Ring> {
        val rings: ArrayList<Ring> = ArrayList()
        var colors = getColors()
        var sortedMap = values.toList().sortedBy { (_, value) -> value}.toMap()

        for(key in sortedMap.keys){
            rings.add(Ring(colors[key], sortedMap[key]!!, type))
        }

        return rings;
    }

}