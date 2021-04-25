package com.example.resi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val spinnerContainerArray: ArrayList<LinearLayout> = ArrayList()
    private var ringsCount = Constants.NUMBER_OF_RINGS_4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.fillSpinnerContainerArray();
        this.initSpinnerAdapter();
        this.setDefaultSpinnerVisibility()

        btn_select_4_rings.setOnClickListener(this)
        btn_select_5_rings.setOnClickListener(this)
        btn_select_6_rings.setOnClickListener(this)
        btn_calculate.setOnClickListener(this)
    }

    private fun fillSpinnerContainerArray(){
        spinnerContainerArray.add(0, colors_spinner_container_1)
        spinnerContainerArray.add(1, colors_spinner_container_2)
        spinnerContainerArray.add(2, colors_spinner_container_3)
        spinnerContainerArray.add(3, colors_spinner_container_mult)
        spinnerContainerArray.add(4, colors_spinner_container_temp)
        spinnerContainerArray.add(5, colors_spinner_container_tol)
    }

    private fun initSpinnerAdapter(){
        colors_spinner_color_1.adapter = CustomColorSpinner(
            this,
            R.layout.color_spinner_item,
            Constants.getResistanceRings(true)
        )

        colors_spinner_color_2.adapter = CustomColorSpinner(
            this,
            R.layout.color_spinner_item,
            Constants.getResistanceRings(false)
        )

        colors_spinner_color_3.adapter = CustomColorSpinner(
            this,
            R.layout.color_spinner_item,
            Constants.getResistanceRings(false)
        )

        colors_spinner_mult.adapter = CustomColorSpinner(
            this,
            R.layout.color_spinner_item,
            Constants.getMultiplierRings()
        )

        colors_spinner_tol.adapter = CustomColorSpinner(
            this,
            R.layout.color_spinner_item,
            Constants.getToleranceRings()
        )

        colors_spinner_temp.adapter = CustomColorSpinner(
            this,
            R.layout.color_spinner_item,
            Constants.getTemperatureCoefficientRings()
        )

    }

    private fun setDefaultSpinnerVisibility(){
        this.setSpinnersVisibility(Constants.NUMBER_OF_RINGS_4);
    }

    private fun setAllSpinnerVisible(){
        for(spinnerContainer in spinnerContainerArray){
            spinnerContainer.isVisible = true
        }
    }

    private fun setSpinnersVisibility(ringsCount: Int) {
        this.setAllSpinnerVisible();

        when(ringsCount){
            Constants.NUMBER_OF_RINGS_4 -> {
                colors_spinner_container_3.isVisible = false
                colors_spinner_container_temp.isVisible = false
            }
            Constants.NUMBER_OF_RINGS_5 -> colors_spinner_container_temp.isVisible = false
        }
    }

    private fun submit(){
        val colorRingOne: Ring = colors_spinner_color_1.selectedItem as Ring
        val colorRingTwo: Ring = colors_spinner_color_2.selectedItem as Ring
        val colorRingThree: Ring = colors_spinner_color_3.selectedItem as Ring
        val colorRingMultiplier: Ring = colors_spinner_mult.selectedItem as Ring
        val colorRingTolerance: Ring = colors_spinner_tol.selectedItem as Ring
        val colorRingTemperatureCoefficients: Ring = colors_spinner_temp.selectedItem as Ring

        val unit: Unit = Unit()

        var resistance  = "${unit.format(colorRingOne)}${unit.format(colorRingTwo)}"

        if(this.ringsCount == Constants.NUMBER_OF_RINGS_5 || this.ringsCount == Constants.NUMBER_OF_RINGS_6){
            resistance = "${resistance}${unit.format(colorRingThree)}"
        }

        resistance = "${resistance.toInt() * colorRingMultiplier.value}"

        val temperatureCoefficients: Boolean = this.ringsCount == Constants.NUMBER_OF_RINGS_6

        val intent: Intent = Intent(this@MainActivity, ResultActivity::class.java)
        intent.putExtra("resistance", resistance.toDouble())
        intent.putExtra("tolerance", colorRingTolerance.value)
        intent.putExtra("temperatureCoefficients", colorRingTemperatureCoefficients.value)
        intent.putExtra("showTemperatureCoefficients", temperatureCoefficients)
        startActivity(intent)
        finish()
    }

    private fun handleRingsChange(ringsCount: Int){
        this.ringsCount = ringsCount
        this.setSpinnersVisibility(ringsCount)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_select_4_rings -> {
                this.handleRingsChange(Constants.NUMBER_OF_RINGS_4)
            }
            R.id.btn_select_5_rings -> {
                this.handleRingsChange(Constants.NUMBER_OF_RINGS_5)
            }
            R.id.btn_select_6_rings -> {
                this.handleRingsChange(Constants.NUMBER_OF_RINGS_6)
            }
            R.id.btn_calculate -> {
                this.submit()
            }
        }
    }

}