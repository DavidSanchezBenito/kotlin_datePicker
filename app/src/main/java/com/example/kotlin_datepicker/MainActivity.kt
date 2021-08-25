package com.example.kotlin_datepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
/*
DatePicker en Kotlin (Selector fecha) - Tutorial Android Studio
https://www.youtube.com/watch?v=GOYIat0QC6A
https://cursokotlin.com/capitulo-26-datepicker-en-kotlin/
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    etxt_fecha.setOnClickListener(){

        showDatePickerDialog()
    }

    }

    private fun showDatePickerDialog() {
    val datePicker = DatePickerFragment({day, month, year -> onDaySelection (day, month, year) })
        datePicker.show(supportFragmentManager, "datePicker")

    }
    fun onDaySelection(day : Int, month : Int, year : Int) {
    etxt_fecha.setText("Has seleccionado el dia $day, mes $month y año: $year")
    }
}