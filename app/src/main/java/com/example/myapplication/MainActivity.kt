package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextA: EditText = findViewById(R.id.editTextA)
        val editTextB: EditText = findViewById(R.id.editTextB)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val inputA = editTextA.text.toString()
            val inputB = editTextB.text.toString()

            if (inputA.isNotEmpty() && inputB.isNotEmpty()) {
                try {
                    val a = inputA.toInt()
                    val b = inputB.toInt()

                    if (a <= b) {
                        val count = countEvenNumbers(a, b)
                        Toast.makeText(this, "Кількість парних чисел: $count", Toast.LENGTH_SHORT).show()
                    } else {
                        showToast("Помилка: A має бути менше або дорівнювати B")
                    }
                } catch (e: NumberFormatException) {
                    showToast("Помилка: Введені дані не є цілими числами")
                }
            } else {
                showToast("Помилка: Введіть обидва числа")
            }
        }
    }

    private fun countEvenNumbers(a: Int, b: Int): Int {
        var count = 0
        for (num in a..b) {
            if (num % 2 == 0) {
                count++
            }
        }
        return count
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
