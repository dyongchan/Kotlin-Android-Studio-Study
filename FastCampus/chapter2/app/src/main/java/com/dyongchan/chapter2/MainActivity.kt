package com.dyongchan.chapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dyongchan.chapter2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var number = 0
//        var : 변수(값 변경 가능) / val : 값 변경 불가

        binding.numberTextView.text = number.toString()

        binding.resetButton.setOnClickListener {
            number = 0
            binding.numberTextView.text = number.toString()
            // Log : 실제 메서드가 실행되는지에 레벨 단위로 정보를 얻을 수 있음
            // d = debugging / e = error / i = information
            Log.d("onClick", "리셋 된 숫자는 $number")
            // $ + 변수 = String 으로 표현
        }

        binding.plusButton.setOnClickListener {
            number += 1
            binding.numberTextView.text = number.toString()
            Log.e("onClick", "플러스 된 숫자는 $number")
        }
    }
}