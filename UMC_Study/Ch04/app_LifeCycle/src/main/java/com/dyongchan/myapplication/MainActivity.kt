package com.dyongchan.myapplication

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.dyongchan.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object var str = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 액티비티 생성 시 호출되며 사용자 인터페이스 초기화 할 때 onCreate 안에 구현
        println("onCreate_print")
        Log.d("onCreate_log", "onCreate_debug" )

        // Override members : ctrl + O

        binding.btnMainSend.setOnClickListener {
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            intent.putExtra("input", binding.etMain.text.toString())
            startActivity(intent)
        }

        // Edit Text 간 문자열 변경
        binding.btnMainChange.setOnClickListener {
            val etMain = binding.etMain.text.toString()
            val etMainLocal = binding.etMainLocal.text.toString()
            binding.etMainLocal.setText(etMain)
            binding.etMain.setText(etMainLocal)
        }

        // 두개의 EditText에 값이 존재하면 종료하지 않고 비어있다면 종료
        binding.btnMainExit.setOnClickListener {
            if(binding.etMain.text.isEmpty() && binding.etMainLocal.text.isEmpty()) {
                ActivityCompat.finishAffinity(this@MainActivity)
            }  else {
                Toast.makeText(this@MainActivity,"문자열 데이터가 존재합니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 생명주기의 해당 단계에서 필요한 로직의 구현을 위해 사용할 수 있음

    override fun onStart() {
        super.onStart()
        // 액티비티가 사용자에게 보여지기 직전에 호출
        println("onStart_print")
        Log.d("onStart_log", "onStart_debug" )
    }

    override fun onResume() {
        super.onResume()
        // 액티비티가 사용자랑 상호작용 하기 직전에 호출 (시작 or 재개 상태)
        println("onResume_print")
        Log.d("onResume_log", "onResume_debug" )
        if (str.isNotEmpty()) {
            binding.etMain.setText(str)
        }
    }

    override fun onPause() {
        super.onPause()
        // 다른 액티비티가 보여지게 될때 호출 (중지 상태)
        println("onPause_print")
        Log.d("onPause_log", "onPause_debug" )

        str = binding.etMainLocal.text.toString()
    }

    override fun onStop() {
        super.onStop()
        // 액티비티가 사용자에게 완전히 보여지지 않을 때 호출 : 보여지는 화면이 다른 액티비티로의 대체
        println("onStop_print")
        Log.d("onStop_log", "onStop_debug" )
    }

    override fun onDestroy() {
        super.onDestroy()
        // 액티비티가 소멸(제거) 될 때 호출 (변수, 메모리 할당, 초기화 관련된 처리 시 사용)
        println("onDestroy_print")
        Log.d("onDestroy_log", "onDestroy_debug" )

    }

    override fun onRestart() {
        super.onRestart()
        // 액티비티가 멈췄다가 다시 시직할 때 호출
        println("onRestart_print")
        Log.d("onRestart_log", "onRestart_debug" )

        val builder = AlertDialog.Builder(this)
            .setTitle("안내메세지")
            .setMessage("다시 쓰고싶어?")
            .setPositiveButton("넹",DialogInterface.OnClickListener{ dialog, which ->
                str = ""
                binding.etMainLocal.setText(str)
                Toast.makeText(this@MainActivity, "다시 작성하신데요~",Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("아니요", DialogInterface.OnClickListener {dialog, which ->
                Toast.makeText(this@MainActivity,"안하신데요~",Toast.LENGTH_SHORT).show()
            })
        builder.show()
    }
}