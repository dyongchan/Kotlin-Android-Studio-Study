package com.dyongchan.chapter6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.dyongchan.chapter6.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val firstNumberText = StringBuilder("")
    private val secondNumberText = StringBuilder("")
    private val operatorText = StringBuilder("")

    private val decimalFormat = DecimalFormat("#,###")
    // 세자리마다 컴마, 또는 소수점의 표현 등 조절 가능

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun numberClicked(view : View) {
        //   ? : (요소) 일수도 있고 아닐 수도 있다.
        // (view as? button)? : view 또한 Nullable  = null이 아니면 text를 받는다
        val numberString = (view as? Button)?.text?.toString() ?: ""
        // Button이 아닐경우 빈 문자열 받기

        val numberText = if(operatorText.isEmpty()) firstNumberText else secondNumberText

        numberText.append(numberString)
        updateEquationTextView()

    }

    fun clearClicked(view : View) {
        firstNumberText.clear()
        secondNumberText.clear()
        operatorText.clear()
        updateEquationTextView()
        binding.tvResult.text = ""
    }

    fun equalClicked(view : View) {

        if(firstNumberText.isEmpty() || secondNumberText.isEmpty() || operatorText.isEmpty()) {
            Toast.makeText(this,"올바르지 않은 수식 입니다.", Toast.LENGTH_SHORT).show()
            return
        }

        val first = firstNumberText.toString().toBigDecimal()
        val second = secondNumberText.toString().toBigDecimal()
        // BigDecimal : 소수점의 정확한 계산을 사용 / 또는 무한대의 숫자를 받아서 사용가능

        val result = when(operatorText.toString()) {
            "+" -> decimalFormat.format(first + second)
            "-" -> decimalFormat.format(first - second)
            else -> "자롬ㅅ된 수식 입니다."
        }.toString() // 숫자 또는 문자이므로 문자열로통일
        binding.tvResult.text = result

//        val operation = operatorText.toString()
//
//        if(operation == "+") {
//            binding.tvResult.text = (first + second).toString()
//        } else if (operation == "-") {
//            binding.tvResult.text = (first - second).toString()
//        }

    }

    fun operatorClicked(view : View) {
        val operatorString = (view as? Button)?.text?.toString() ?: ""

        if(firstNumberText.isEmpty()) {
            Toast.makeText(this@MainActivity, "먼저 숫자를 입력해주세요.",Toast.LENGTH_SHORT).show()
            return
        }

        if (secondNumberText.isNotEmpty()) {
            Toast.makeText(this@MainActivity, "1개의 연산자에 대해서만 연산이 가능합니다.",Toast.LENGTH_SHORT).show()
            return
        }

        operatorText.append(operatorString)
        updateEquationTextView()
    }

    private fun updateEquationTextView() {
        val firstFormattedNumber = if(firstNumberText.isNotEmpty()) decimalFormat.format(firstNumberText.toString().toBigDecimal()) else ""
        val secondFormattedNumber = if(secondNumberText.isNotEmpty()) decimalFormat.format(secondNumberText.toString().toBigDecimal()) else ""
        binding.tvEquation.text = "$firstFormattedNumber $operatorText $secondFormattedNumber"
    }
}