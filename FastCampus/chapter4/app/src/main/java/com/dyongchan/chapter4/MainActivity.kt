package com.dyongchan.chapter4

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.dyongchan.chapter4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.mainEditButton.setOnClickListener {
            val intent = Intent(this@MainActivity, EditActivity::class.java) // 명시적
            startActivity(intent)
        }

        binding.deleteButton.setOnClickListener {
            deleteData()
        }

        binding.emergencyPhoneLayer.setOnClickListener {
            with(Intent(Intent.ACTION_VIEW)) {
                val phoneNumber = binding.emergecyNumValueTextview.text.toString()
                    .replace("-", "")
                data = Uri.parse("tel:$phoneNumber")
                startActivity(this)
            } // 암시적
        }

    }

    // 다른 액티비티의 종료 후 다시 돌아온다 - Resume

    override fun onResume() {
        super.onResume()
        getDataUiUpdate()
    }

    private fun getDataUiUpdate() {
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE)) {
            binding.nameValueTextView.text = getString(NAME, "미정")
            binding.birthDateValueTextView.text = getString(BIRTHDATE, "미정")
            binding.bloodTypeValueTextView.text = getString(BLOOD_TYPE, "미정")
            binding.emergecyNumValueTextview.text = getString(EMERGENCYNUMBER, "미정")

            val notice = getString(NOTICE, "")
            // 아래 if문 축약 비어있다면 보여주지 않는다
            binding.NoticeValueTextview.isVisible = notice.isNullOrEmpty().not()
            binding.NoticeTextview.isVisible = notice.isNullOrEmpty().not()

            if(!notice.isNullOrBlank()) {
                binding.NoticeValueTextview.text = notice
            }

//            if(notice.isNullOrBlank()) {
//                binding.NoticeValueTextview.isVisible = false
//                binding.NoticeTextview.isVisible = false
//            } else {
//                binding.NoticeValueTextview.isVisible = true
//                binding.NoticeTextview.isVisible = true
//                binding.NoticeValueTextview.text = notice
//            }


        }
    }

    private fun deleteData() {
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE).edit()) {
            clear()
            apply() // 실행에 관한 코드 꼭 쓰기
            getDataUiUpdate()
        }
        Toast.makeText(this,"초기화를 완료했습니다.",Toast.LENGTH_SHORT).show()
    }
}