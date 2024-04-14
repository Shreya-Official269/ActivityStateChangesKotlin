package com.example.activitystatechangeskotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG = "DailyCoding"
    private lateinit var txtTotal: TextView
    private lateinit var btnIncrement: Button
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTotal = findViewById(R.id.txt_total)
        btnIncrement = findViewById(R.id.btn_increment)
        counter = 0

        btnIncrement.setOnClickListener {
            counter++
            txtTotal.text = counter.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("key_counter", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt("key_counter", 0)
        txtTotal.text = counter.toString()
    }
}