package com.example.kotlin_datepicker

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.kotlin_datepicker.R.*
import java.util.*

class DatePickerFragment(val listener : (day: Int, month: Int, year: Int) -> Unit) : DialogFragment(),

    DatePickerDialog.OnDateSetListener {
    //sobreescribe el original
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        listener(dayOfMonth,month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)   no me interesa la funcion original

        val c = Calendar.getInstance()  //aqui tenemos un calendario
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get((Calendar.YEAR))

        //creo un theme especifico con el color que quiera, y lo pongo como atributos: ,
         val picker = DatePickerDialog(activity as Context, this, year, month, day)  //le doy el contexto y el listener

        picker.datePicker.minDate = c.timeInMillis   // fecha mínima hoy,
        c.add(Calendar.MONTH, +2 )   //+dos meses al mes del calendario y le decimos que se lo ponga a la fecha máxima.
        picker.datePicker.maxDate=c.timeInMillis
        return picker
    }
    //extiendo de DialogFragment: muestra dialogos con los q vamos a trabajar
    //DatePickerDialog.OnDateSetListener: implementamos esta funcion para q nos de la fecha avisandome
}