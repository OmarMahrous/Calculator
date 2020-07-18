package com.example.omar.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var isNewOperation = true
    fun clickNumber(view: View)
    {
        if(isNewOperation){tvShowNumber.text = ""}
        isNewOperation = false

        var tvNumber:String = tvShowNumber.text.toString()
        val btnSelect = view as Button

        when(btnSelect.id)
        {
            btnNegativeNum.id -> {tvNumber = "-" + tvNumber}
            btnDot.id -> {tvNumber+= "."}
            btnNum0.id -> {tvNumber+= "0"}
            btnNum1.id -> {tvNumber+= "1"}
            btnNum2.id -> {tvNumber+= "2"}
            btnNum3.id -> {tvNumber+= "3"}
            btnNum4.id -> {tvNumber+= "4"}
            btnNum5.id -> {tvNumber+= "5"}
            btnNum6.id -> {tvNumber+= "6"}
            btnNum7.id -> {tvNumber+= "7"}
            btnNum8.id -> {tvNumber+= "8"}
            btnNum9.id -> {tvNumber+= "9"}
        }

        tvShowNumber.text = tvNumber

    }

    var oldNumber = ""
    var operation = "+"
    fun clickMakeOperation(view: View)
    {
        oldNumber = tvShowNumber.text.toString()
        isNewOperation = true
        var tvOperationSign:String = tvShowNumber.text.toString()
        val btnSelect = view as Button
        when(btnSelect.id)
        {
            btnAdd.id -> {operation = "+"
                         tvOperationSign+= "+"}
            btnSubtract.id -> {operation = "-"
                              tvOperationSign+= "-"}
            btnMultiple.id -> {operation = "*"
                              tvOperationSign+= "*"}
            btnDivide.id -> {operation = "/"
                            tvOperationSign+= "/"}
        }
    }


    var finalResult:Double ?= null
    fun clickShowResult(view: View)
    {
        val newNumber = tvShowNumber.text.toString()
        var finalResult:Double ?= null
        when(operation)
        {
            "/" -> {finalResult = oldNumber.toDouble() / newNumber.toDouble()}
            "*" -> {finalResult = oldNumber.toDouble() * newNumber.toDouble()}
            "-" -> {finalResult = oldNumber.toDouble() - newNumber.toDouble()}
            "+" -> {finalResult = oldNumber.toDouble() + newNumber.toDouble()}
        }

        tvShowNumber.text= finalResult.toString()
        isNewOperation = true

    }

    fun clickClear(view: View)
    {
        isNewOperation = true
        tvShowNumber.text = "0"
    }
}
