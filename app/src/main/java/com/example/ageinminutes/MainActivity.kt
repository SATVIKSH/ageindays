package com.example.ageinminutes

import android.app.DatePickerDialog
import android.icu.util.UniversalTimeScale.toLong
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.reflect.Array.get
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
import java.util.Calendar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener {view->
        datepicker(view)

        }
    }
    fun datepicker(view: View){
        val mycalender=Calendar.getInstance()
        val year=mycalender.get(YEAR)
        val month=mycalender.get(MONTH)
        val day=mycalender.get(DAY_OF_MONTH)
    DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth,  selectedday ->
    val selecteddate="$selectedday/${selectedmonth+1}/$selectedyear"
        val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val theDate=sdf.parse(selecteddate)
       val selectedateinminutes=theDate!!.time /86400000
        val currentdate=sdf.parse(sformatdf.(System.currentTimeMillis()))
        val currentdateinminutes=currentdate.time/86400000
//        val currentdateinminutes=System.currentTimeMillis()/86400000
//        Toast.makeText(this,currentdateinminutes.toString(),Toast.LENGTH_LONG).show()
        val minutespassed=currentdateinminutes-selectedateinminutes
        val date=findViewById<TextView>(R.id.date)
        val age=findViewById<TextView>(R.id.age)
        date.setText(selecteddate)
        age.setText(minutespassed.toString())
    }
        ,year
        , month
        ,day).show()
    }

    }
