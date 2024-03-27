package com.example.btvnb3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var currentValue = ""
    private var result = 0.0
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initButtons()
        updateResult()
        updateView()
    }

    private fun initButtons() {
        val buttons = arrayOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
            R.id.buttonPlus, R.id.buttonMinus, R.id.buttonMultiply, R.id.buttonDivide,
            R.id.buttonEquals, R.id.buttonDot, R.id.buttonClear
        )

        buttons.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener {
                handleButtonClick(it.id)
            }
        }
    }

    private fun handleButtonClick(buttonId: Int) {
        when (buttonId) {
            R.id.button0 -> appendNumber("0")
            R.id.button1 -> appendNumber("1")
            R.id.button2 -> appendNumber("2")
            R.id.button3 -> appendNumber("3")
            R.id.button4 -> appendNumber("4")
            R.id.button5 -> appendNumber("5")
            R.id.button6 -> appendNumber("6")
            R.id.button7 -> appendNumber("7")
            R.id.button8 -> appendNumber("8")
            R.id.button9 -> appendNumber("9")
            R.id.buttonPlus -> appendOperator("+")
            R.id.buttonMinus -> appendOperator("-")
            R.id.buttonMultiply -> appendOperator("*")
            R.id.buttonDivide -> appendOperator("/")
            R.id.buttonEquals -> evaluateExpression()
            R.id.buttonDot -> appendDot()
            R.id.buttonClear -> clear()
        }
        updateView()
    }

    private fun appendNumber(number: String) {
        currentValue += number
        updateView()
    }

    private fun appendOperator(op: String) {
        if (currentValue.isNotEmpty()) {
            operator += op
            currentValue += op
            updateView()
        }
    }

    private fun evaluateExpression() {
        if (currentValue.isNotEmpty() && operator.isNotEmpty()) {
            val operands = currentValue.split(operator)
            if (operands.size == 2) {
                val firstVal = operands[0].toDouble()
                val secondVal = operands[1].toDouble()
                when (operator) {
                    "+" -> result = firstVal + secondVal
                    "-" -> result = firstVal - secondVal
                    "*" -> result = firstVal * secondVal
                    "/" -> result = firstVal / secondVal
                }
                operator = ""
                //currentValue = result.toString()
                updateResult()
            }
        }
    }


    private fun appendDot() {
        if (!currentValue.contains(".")) {
            if (currentValue.isEmpty()) currentValue = "0"
            currentValue += "."
            updateView()
        }
    }

    private fun clear() {
        currentValue = ""
        result = 0.0
        operator = ""
        updateResult()
        updateView()
    }

    private fun updateView() {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "$currentValue"
    }

    private fun updateResult() {
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        textViewResult.text = result.toString()
    }
}
