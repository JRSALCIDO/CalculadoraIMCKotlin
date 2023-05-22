package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculate: Button
    private lateinit var btnClear: Button
    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val username = "Usuario"
        supportActionBar?.title = "Bienvenido: $username"

        etWeight = findViewById(R.id.et_weight)
        etHeight = findViewById(R.id.et_height)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate = findViewById(R.id.btn_calculate)
        btnClear = findViewById(R.id.btn_clear)
        btnExit = findViewById(R.id.btn_exit)

        btnCalculate.setOnClickListener {
            val num1 = etWeight.text.toString().trim()
            val num2 = etHeight.text.toString().trim()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                // Ambos campos contienen valores no vacíos
                calculateBMI()
            }  else {
                Toast.makeText(this, "Ingrese Ambos Numeros", Toast.LENGTH_SHORT).show()
            }


        }

        btnClear.setOnClickListener {
            clearFields()
        }

        btnExit.setOnClickListener {
            finish()
        }
    }

    private fun calculateBMI() {
        val weight = etWeight.text.toString().toDouble()
        val height = etHeight.text.toString().toDouble() / 100.0
        val bmi = weight / (height * height)
        val result = String.format("Tu IMC es %.2f", bmi)
        tvResult.text = result
    }

    private fun clearFields() {
        etWeight.text.clear()
        etHeight.text.clear()
        tvResult.text = ""
    }
}

