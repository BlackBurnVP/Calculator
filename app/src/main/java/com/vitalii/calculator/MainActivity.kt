package com.vitalii.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var operation="*"
    var oldNumber=""
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnHandler(view: View){

        if(isNewOperation){
            txt_numbers.text.clear()
        }
        isNewOperation = false
        val btnSelected = view as Button
        var btnValue:String = txt_numbers.text.toString()

        when(btnSelected.id){
            btnOne.id -> btnValue += "1"
            btnTwo.id -> btnValue += "2"
            btnThre.id -> btnValue += "3"
            btnFour.id -> btnValue += "4"
            btnFive.id -> btnValue += "5"
            btnSix.id -> btnValue += "6"
            btnSeven.id -> btnValue += "7"
            btnEight.id -> btnValue += "8"
            btnNine.id -> btnValue += "9"
            btnZero.id -> btnValue += "0"
            btnDot.id ->
                if (!btnValue.contains("."))btnValue += "."
            btnNegative.id -> {
                if(btnValue.contains("-")){
                    btnValue = btnValue.replace("-"," ")
                };else{ btnValue = "-$btnValue"}
            }
            btnClear.id -> btnValue = ""
        }
        txt_numbers.setText(btnValue)
    }

    fun onOperations(view:View){

        val btnSelected = view as Button
        when(btnSelected.id){
            btnPlus.id -> operation = "+"
            btnMinus.id -> operation = "-"
            btnDiv.id -> operation = "/"
            btnMultiply.id -> operation = "*"
            btnPercents.id -> operation = "%"
        }
        oldNumber = txt_numbers.text.toString()
        isNewOperation=true
    }

    fun onResult(view:View){
        val newNumber = txt_numbers.text.toString()
        var result:Double?=null
        when(operation){
            "+" -> result = oldNumber.toDouble() + newNumber.toDouble()
            "-" -> result = oldNumber.toDouble() - newNumber.toDouble()
            "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
            "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
            "%" -> result = oldNumber.toDouble() * (newNumber.toDouble()/100)
        }
        txt_numbers.setText(result.toString())
        isNewOperation=true
    }
}
