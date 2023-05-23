package com.dyongchan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dyongchan.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvMain2.text = intent.getStringExtra("input")

    }
}