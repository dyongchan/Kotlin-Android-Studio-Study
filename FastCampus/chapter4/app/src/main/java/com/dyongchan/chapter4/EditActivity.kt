package com.dyongchan.chapter4

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.location.GnssAntennaInfo.Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import com.dyongchan.chapter4.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // Adapter 사용 : list 형 데이터를 UI로 연결해주는 역할 (반복된 데이터의 표현 시 유용)
        // ArrayAdapter 사용 : 배열의 데이터를 adapter에 넣어줌
        binding.bloodTypeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            // textArrayResId : spinner에 들어갈 text를 갖고있는 res id를 넣어라
            // 추후 표현된 textView의 res id를 추가로 넣어라
            R.array.blood_types,
            android.R.layout.simple_list_item_1 // 안드로이드에서 제공하는 기본적인 리스트아이템 텍스트뷰

        )

        binding.birthDateLayer.setOnClickListener {
            // listener에 받은 값을 text로 변환 후 설정
            val listener = OnDateSetListener{ _, year, month, dayOfMonth ->
                binding.birthDateValueTextView.text = "$year-$month-$dayOfMonth"
            }

            // 날짜를 선택할 수 있는 Dialog
            DatePickerDialog(
                this,
                listener,
                2000,
                1,
                1
                ).show()
            // Dialog의 표현을 위헤 show 꼭 해주기

        }
        
        // 체크되었는지 확인하는 리스너
        binding.noticeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            binding.noticeValueEditText.isVisible = isChecked
        }

        binding.noticeValueEditText.isVisible = binding.noticeCheckBox.isChecked

        binding.saveButton.setOnClickListener {
            saveDate()
            finish() // 액티비티의 종료
        }

    }

    private fun saveDate() {
        // sharedPreferences : 작은 사이즈의 데이터를 저장할 떄 사용할 수 있는 API
        // key을 갖고있는 파일로 저장


        /*
        val editor = getSharedPreferences("userInformation", Context.MODE_PRIVATE).edit()

        Private : 이 파일을 생성한 앱에서만 접근할 수 있음
        값을 넣기 위한 edit를 선언 후 변수에 할당

        editor.putString("name", binding.nameValueEditText.text.toString())
        editor.putString("bloodType", )
        editor.putString("emergecyNumber", binding.emergecyNumValueEditText.text.toString())
        editor.putString("birthDate",binding.birthDateValueTextView.text.toString())
        editor.putString("notice", )
        editor.apply()

        동작의 실행 후 return 값이 필요 없으므로 scope function 사용
         */

       with(getSharedPreferences(USER_INFORMATION, MODE_PRIVATE).edit()) {
           putString(NAME, binding.nameValueEditText.text.toString())
           putString(BLOOD_TYPE, getBloodType())
           putString(EMERGENCYNUMBER, binding.emergecyNumValueEditText.text.toString())
           putString(BIRTHDATE,binding.birthDateValueTextView.text.toString())
           putString(NOTICE, getNotice())
           apply()
        }

        // 쓰레드 : 작업이 이루어지는 공간
        // commit : 현 쓰레드를 중지 후 데이터 저장 후 다음 쓰레드 동작 가능 (사용자의 동작도 막힘) - 다른 쓰레드를 열어준다
        // apply : 비동기적인 동작으로 다른 쓰레드를 열어 저장함 (현 쓰레드의 동작 막지 않음)

        Toast.makeText(this,"저장을 완료했습니다.",Toast.LENGTH_SHORT).show()
    }

    private fun getBloodType() : String { // String type의 return
        // String 배열 중 지금 선택한 아이템 : selectedItem + toString (다른 타입일 수 있으므로)
        val bloodAlphabet = binding.bloodTypeSpinner.selectedItem.toString()
        val bloodSign = if(binding.bloodTypePlus.isChecked) "+" else "-"

        return "$bloodSign$bloodAlphabet"
    }

    private fun getNotice() : String {
        return if(binding.noticeCheckBox.isChecked) binding.noticeValueEditText.text.toString() else ""

    }

}