package com.example.calculator_app

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var canAddoperation = false
    private var canAddDecimal = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun onDigitClick(view: View) {
        if (view is Button) {
            val buttonText = view.text.toString()
            binding.panel.append(buttonText)

            if (buttonText == ".") {
                if (canAddDecimal) {
                    binding.panel.append(buttonText)
                }
                canAddDecimal = false
            } else {
                canAddoperation = true
            }
        }
    }


    fun onOperatorClick(view: View) {
        if (view is Button && canAddoperation) {
            binding.panel.append(view.text)
            canAddoperation = false
        }
    }

    fun onClearClick(view: View) {
        binding.panel.text = ""
        binding.result.text = ""
    }

    fun backspaceClick(view: View) {
        val length = binding.panel.length()
        if (length > 0) {
            binding.panel.text = binding.panel.text.subSequence(0, length - 1)
        }

    }

    fun onEqualClick(view: View) {
        binding.result.text = calculateresult()
    }

    private fun calculateresult(): String {
        val digitOperator = digitoperators()
        if (digitOperator.isEmpty()) return ""

        val timeDivision = mulDivPowModCalculate(digitOperator)
        if (timeDivision.isEmpty()) return ""

        val res = addSubtractCalclate(timeDivision)
        return res.toString()

    }

    private fun addSubtractCalclate(passedList: MutableList<Any>): Float {

        var res = passedList[0] as Float
        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex) {
                val operator = passedList[i]
                val nextDigit = passedList[i + 1] as Float
                if (operator == '+')
                    res += nextDigit
                if (operator == '-')
                    res -= nextDigit


            }
        }
        return res
    }

    private fun mulDivPowModCalculate(passedList: MutableList<Any>): MutableList<Any> {

        var list = passedList
        while (list.contains('*') || list.contains('/') || list.contains('^') || list.contains('%')) {
            list = calMulDivPowMod(list)
        }
        return list
    }

    private fun calMulDivPowMod(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()
        var restartIndex = passedList.size
        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex && i < restartIndex) {

                val operator = passedList[i]
                val prevDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                when (operator) {
                    '*' -> {
                        newList.add(prevDigit * nextDigit)
                        restartIndex = i + 1
                    }

                    '/' -> {
                        newList.add(prevDigit / nextDigit)
                        restartIndex = i + 1
                    }

                    '^' -> {
                        newList.add(Math.pow(prevDigit.toDouble(), nextDigit.toDouble()).toFloat())
                        restartIndex = i + 1
                    }

                    '%' -> {
                        newList.add(prevDigit % nextDigit)
                    }

                    else -> {
                        newList.add(prevDigit)
                        newList.add(operator)
                    }
                }
            }
            if (i > restartIndex) {
                newList.add(passedList[i])
            }
        }
        return newList
    }

    private fun digitoperators(): MutableList<Any> {

        val list = mutableListOf<Any>()
        var currentDigit = ""
        for (character in binding.panel.text) {
            if (character.isDigit() || character == '.')
                currentDigit += character
            else {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
        }
        if (currentDigit != "")
            list.add(currentDigit.toFloat())
        return list
    }
}


