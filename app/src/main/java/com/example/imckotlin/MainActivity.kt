package com.example.imckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var botonLimpiar: Button
    private lateinit var botonSalir: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPeso = findViewById(R.id.editTextPeso)
        editTextAltura = findViewById(R.id.editTextAltura)
        val botonCalcular: Button = findViewById(R.id.botonCalcular)
        botonLimpiar = findViewById(R.id.botonLimpiar)
        botonSalir = findViewById(R.id.botonSalir)
        textViewResultado = findViewById(R.id.textViewResultado)

        botonCalcular.setOnClickListener {
            calcularIMC()
        }

        botonLimpiar.setOnClickListener {
            limpiarCampos()
        }

        botonSalir.setOnClickListener {
            finish()
        }
    }

    private fun calcularIMC() {
        val pesoString = editTextPeso.text.toString()
        val alturaString = editTextAltura.text.toString()

        if (!pesoString.isEmpty() && !alturaString.isEmpty()) {
            val peso = pesoString.toFloat()
            val altura = alturaString.toFloat()

            val imc = peso / (altura * altura)

            val resultado: String

            resultado = when {
                imc < 18.5 -> "Bajo peso"
                imc >= 18.5 && imc < 25 -> "Peso normal"
                imc >= 25 && imc < 30 -> "Sobrepeso"
                else -> "Obesidad"
            }

            textViewResultado.text = "IMC: ${"%.2f".format(imc)}\n$resultado"
        } else {
            textViewResultado.text = "Por favor, ingresa un peso y altura válidos"
        }
    }

    private fun limpiarCampos() {
        editTextPeso.text.clear()
        editTextAltura.text.clear()
        textViewResultado.text = ""
    }
}
