package com.ewersson.helloworld

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_calc: Button = findViewById(R.id.btn_calculate)
        val result: TextView = findViewById(R.id.result)

        btn_calc.setOnClickListener {

            val grade1 = findViewById<EditText>(R.id.grade1).text.toString().replace(",", "." ).toFloatOrNull()
            val grade2 = findViewById<EditText>(R.id.grade2).text.toString().replace(",", ".").toFloatOrNull()
            val absence = findViewById<EditText>(R.id.absences).text.toString().toFloatOrNull()

            if (grade1 == null || grade2 == null || absence == null) {
                result.setText("Just put numbers!")
                result.setTextColor(Color.YELLOW)
            } else {

                val average = (grade1 + grade2) / 2

                if(average >= 7 && absence <=10){
                    result.setText("Congratulations! You have passed\nFinal grade: $average\nNumber of absences: $absence")
                    result.setTextColor(Color.GREEN)
            } else {
                result.setText("We're sorry! You have failed!\nFinal grade: $average\nNumber of absences: $absence")
                    result.setTextColor(Color.RED)
            }
            }
        }
    }
}