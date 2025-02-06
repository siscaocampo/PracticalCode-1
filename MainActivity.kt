package com.example.problem2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.problem2.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        val inputQuiz = findViewById<EditText>(R.id.inputQuiz)
        val inputAssignment = findViewById<EditText>(R.id.inputAssignment)
        val inputExam = findViewById<EditText>(R.id.inputExam)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val outputGrade = findViewById<TextView>(R.id.outputGrade)

        btnCalculate.setOnClickListener {
            // Get input values
            val quiz = inputQuiz.text.toString().toDoubleOrNull() ?: 0.0
            val assignment = inputAssignment.text.toString().toDoubleOrNull() ?: 0.0
            val exam = inputExam.text.toString().toDoubleOrNull() ?: 0.0

            // Create a StudentGrade object
            val studentGrade = SG(quiz, assignment, exam)

            // Calculate and display the final grade
            val finalGrade = studentGrade.calculateFinalGrade()
            outputGrade.text = "Final Grade: %.2f".format(finalGrade)
        }
    }
}