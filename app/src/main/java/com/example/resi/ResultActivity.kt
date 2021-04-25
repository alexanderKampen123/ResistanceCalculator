package com.example.resi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val unit: Unit = Unit()
        val resistance = intent.getDoubleExtra("resistance", 0.0)
        val tolerance = intent.getDoubleExtra("tolerance", 0.0)
        val temperatureCoefficients = intent.getDoubleExtra("temperatureCoefficients", 0.0)
        val showTemperatureCoefficients = intent.getBooleanExtra("showTemperatureCoefficients", false)

        tv_resistance.text = unit.getResistance(resistance)
        tv_tolerance.text = unit.getTolerance(tolerance)
        tv_temperature_coefficients.text = unit.formatNumber(temperatureCoefficients)

        ctn_temperature_coefficient.isVisible = showTemperatureCoefficients

        btn_back.setOnClickListener {
            val intent: Intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}