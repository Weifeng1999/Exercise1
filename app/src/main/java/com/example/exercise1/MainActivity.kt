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
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)
        val finalLoan = findViewById<TextView>(R.id.textViewLoan)
        val finalInterest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val carLoan = carPrice.text.toString().toInt() - downPayment.text.toString().toInt()
        val loanInterest = carLoan * interestRate.text.toString().toDouble() * loanPeriod.text.toString().toInt()
        val carMonthlyRepay = (carLoan + loanInterest) / loanPeriod.text.toString().toInt() / 12
        finalLoan.text = carLoan.toString()
        finalInterest.text = loanInterest.toString()
        monthlyRepay.text = carMonthlyRepay.toString()
    }

    private fun resetText(view: View){
        findViewById<EditText>(R.id.editTextCarPrice).getText().clear()
        findViewById<EditText>(R.id.editTextDownPayment).getText().clear()
        findViewById<EditText>(R.id.editTextLoanPeriod).getText().clear()
        findViewById<EditText>(R.id.editTextInterestRate).getText().clear()
        findViewById<TextView>(R.id.textViewLoan).setText("Loan:")
        findViewById<TextView>(R.id.textViewInterest).setText("Interest:")
        findViewById<TextView>(R.id.textViewMonthlyRepayment).setText("Monthly Repayment:")
    }
}
