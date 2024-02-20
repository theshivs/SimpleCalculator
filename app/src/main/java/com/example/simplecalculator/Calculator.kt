package com.example.simplecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.simplecalculator.databinding.ActivityCalculatorBinding
import kotlin.math.log

class Calculator : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var number1 = 0;
        var number2 = 0;

        var edit_text1 = findViewById<EditText>(R.id.number1);
        var edit_text2 = findViewById<EditText>(R.id.number2);
        var answer_text = findViewById<TextView>(R.id.answer);
        var addition_button = findViewById<Button>(R.id.addition);
        var subtraction_button = findViewById<Button>(R.id.subtraction);
        var multiplication_button = findViewById<Button>(R.id.multiply);
        var division_button = findViewById<Button>(R.id.division);
        var modulo_button = findViewById<Button>(R.id.modulo);


        addition_button.setOnClickListener {
            if(edit_text1.text.toString().isEmpty() || edit_text2.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter both number", Toast.LENGTH_LONG).show();
            }else{
                number1 = edit_text1.text.toString().toInt();
                number2 = edit_text2.text.toString().toInt();
                Log.d("---------", number1.toString()+"" +number2.toString())
                Log.d("_--------",calculate(number1, number2, "ADD").toString() )

                answer_text.text = calculate(number1, number2, "ADD").toString();
            }

        }

        subtraction_button.setOnClickListener {
            if(edit_text1.text.isBlank() || edit_text2.text.isBlank()){
                Toast.makeText(this, "Please enter both number", Toast.LENGTH_LONG).show();
            }else{
                number1 = edit_text1.text.toString().toInt();
                number2 = edit_text2.text.toString().toInt();
                answer_text.text = calculate(number1, number2, "SUBTRACT").toString();
            }
        }

        multiplication_button.setOnClickListener {
            if(edit_text1.text.isBlank() || edit_text2.text.isBlank()){
                Toast.makeText(this, "Please enter both number", Toast.LENGTH_LONG).show();
            }else{
                number1 = edit_text1.text.toString().toInt();
                number2 = edit_text2.text.toString().toInt();
                answer_text.text = calculate(number1, number2, "MULTIPLY").toString();
            }
        }

        division_button.setOnClickListener {
            if(edit_text1.text.isBlank() || edit_text2.text.isBlank()){
                Toast.makeText(this, "Please enter both number", Toast.LENGTH_LONG).show();
            }else{
                number1 = edit_text1.text.toString().toInt();
                number2 = edit_text2.text.toString().toInt();
                if(number2 == 0){
                    Toast.makeText(this, "Number 2 can't be zero!", Toast.LENGTH_LONG).show();
                }else{
                    answer_text.text = calculate(number1, number2, "DIVIDE").toString();
                }
            }
        }

        modulo_button.setOnClickListener {
            if(edit_text1.text.isBlank() || edit_text2.text.isBlank()){
                Toast.makeText(this, "Please enter both number", Toast.LENGTH_LONG).show();
            }else{
                number1 = edit_text1.text.toString().toInt();
                number2 = edit_text2.text.toString().toInt();
                if(number2 == 0){
                    Toast.makeText(this, "Number 2 can't be zero!", Toast.LENGTH_LONG).show();
                }else{
                    answer_text.text = calculate(number1, number2, "MOD").toString();
                }
            }
        }

    }

    fun calculate(num1:Int, num2:Int, op:String): Int{
        when (op) {
            "ADD" -> return num1 + num2
            "SUBTRACT" -> return num1 - num2
            "DIVIDE" -> return num1 / num2
            "MULTIPLY" -> return num1 * num2
            "MOD" -> return num1 % num2
            else -> 0
        }
        return 0
    }
}