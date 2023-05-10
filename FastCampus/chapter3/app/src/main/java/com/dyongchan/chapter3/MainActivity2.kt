package com.dyongchan.chapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.dyongchan.chapter3.databinding.ActivityMain2Binding

/*
findViewById : id로 선언은 되어 있지만 다른 xml의 id값도 받아올 수 있으므로
               접근이 불가한 nullpointException 발생할 수 있음
 */

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    // Binding 클래스가 생성 = binding 객체의 타입으로 선언됨
    // lateinit : 언젠가는 반드시 할당되어야 하는 변수에 대한 지연 초기화 (할당을 늦춘다)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
//        inflate : 불러일으키다 / 터뜨리다 = 화면을 제작하겠다.
//        layoutInflater : 레이아웃의 정보를 받아오는 객체
        val view = binding.root // view요소를 받아옴 (root = constraintLayout : 최상단 부모의 레이아웃)
        setContentView(view) // 화면을 그림

        val inputEditText = binding.inputEditText
        val inputUnitTextView = binding.inputUnitTextView
        var outputTextView = binding.outputTextView
        val outputUnitTextView = binding.outputUnitTextView
        val swapImageButton = binding.swapImageButton

        var inputNumber : Int = 0
        var cmToM = true

        // 문자열이 변경이 되면 알려주는 메소드
        inputEditText.addTextChangedListener { text ->

            // text는 editable한 nullable 값
            inputNumber = if(text.isNullOrEmpty()) {
                0
            } else {
                text.toString().toInt()
                // 받은 문자열을 숫자로 변경
            }

            /*
            Int의 참조 범위를넘어설 때
            - try catch 문 작성
            - Long 타입으로 변경
            - 입력받는 문자열의 길이 조절 (가장 베스트) = 다른사람이 사용했을 때 예외에 대한 확실한 처리
            inputNumber = try {
                text.toString().toInt()
            } catch (e: NumberFormatException {
                0
            }
            // NumberFormatException 오류가 발생 시 0을 할당
             */

            /*
            text의 String이 비어있을때 = 숫자로의 표현 불가
            - isNullOrEmpty 사용 : Null 이거나 비어있다면?
            inputNumber = if(text.isNullOrEmpty()) {
                0
             } else {
                  text.toString.toInt()
             }
             */

            Log.d("inputNumber", inputNumber.toString())

            // var outputNumber  = inputNumber.times(0.01)
            // times : 곱하기 연산자의 확장함수
            // outputTextView.text = outputNumber.toString()
            if (cmToM) {
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                outputTextView.text = inputNumber.times(100).toString()
            }
        }

        swapImageButton.setOnClickListener {
            cmToM = cmToM.not() // 반대값 or !쓰기

            if (!cmToM) {
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
                // Int 값의 범위를 위해 maxlength : 7 까지 선언
            } else {
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"
                outputTextView.text = inputNumber.times(0.01).toString()
            }
        }

    }
}