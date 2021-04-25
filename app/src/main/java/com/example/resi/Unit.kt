package com.example.resi

class Unit {
    private val suffixes: Array<String> = arrayOf("k", "M", "G")
    private val kilo: Int = 1000
    private val mega: Int = kilo * kilo
    private val giga: Int = mega * kilo

    fun format(ring: Ring): String{
        return when (ring.type) {
            Constants.RING_TYPE_MULTIPLIER -> {
                return getMultiplier(ring.value)
            }
            Constants.RING_TYPE_TOLERANCE -> {
                return getTolerance(ring.value)
            }
            else -> ring.value.toInt().toString()
        }
    }

    fun getTolerance(value: Double): String {
        return "+/- ${formatNumber(value)}%"
    }

    fun getMultiplier(value: Double): String {
        return "x ${getResistance(value)}"
    }

    fun getResistance(value: Double): String{
        return "${formatString(convertNumberReadable(value))} Ω"
    }

    private fun formatString(value: String): String {
        val formatted: String =  value.replace(".", ",")
        val split: List<String> = formatted.split(",")

        if(split.size > 1){
            var decimal: String = split[1]
            val lastChar = decimal.last().toString()

            var suffix: String = ""

            if (lastChar in suffixes){
                suffix = lastChar
                decimal = decimal.removeSuffix(suffix)
            }

            if(decimal == "0" || decimal == "00"){
                return "${split[0]}${suffix}"
            }
        }

        return formatted
    }

    fun formatNumber(value: Double): String {
        return formatString(value.toString())
    }

    private fun convertNumberReadable(value: Double): String {
        val k = value / kilo
        val mb = value / mega
        val gb = value / giga

        return if(value >= kilo && value < mega){
            String.format("%.2f", k) + "k";
        } else if(value >= mega && value < giga){
            String.format("%.2f", mb) + "M";
        } else if(value >= giga){
            String.format("%.2f", gb) + "G";
        } else {
            value.toString()
        }
    }

}