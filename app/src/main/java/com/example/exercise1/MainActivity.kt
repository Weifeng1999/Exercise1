package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculateCarLoan(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            resetText(it)
        }
    }

    private fun calculateCarLoan(view: View){
        val finalLoan = findViewById<TextView>(R.id.textViewLoan)
        val finalInterest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val carLoan = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toInt() - findViewById<EditText>(R.id.editTextDownPayment).text.toString().toInt()
        val loanInterest = carLoan * findViewById<EditText>(R.id.editTextInterestRate).text.toString().toDouble() * findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toInt()
        val carMonthlyRepay = (carLoan + loanInterest) / findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toInt() / 12
        finalLoan.text = carLoan.toString()
        finalInterest.text = loanInterest.toString()
        monthlyRepay.text = carMonthlyRepay.toString()
    }

    private fun resetText(view: View){
        findViewById<EditText>(R.id.editTextCarPrice).text.clear()
        findViewById<EditText>(R.id.editTextDownPayment).text.clear()
        findViewById<EditText>(R.id.editTextLoanPeriod).text.clear()
        findViewById<EditText>(R.id.editTextInterestRate).text.clear()
        findViewById<TextView>(R.id.textViewLoan).text = "Loan:"
        findViewById<TextView>(R.id.textViewInterest).text = "Interest:"
        findViewById<TextView>(R.id.textViewMonthlyRepayment).text = "Monthly Repayment:"
    }
}
