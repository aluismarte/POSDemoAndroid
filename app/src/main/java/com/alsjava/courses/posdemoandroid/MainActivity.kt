package com.alsjava.courses.posdemoandroid

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMiBoton.setOnClickListener {
            Toast.makeText(this, "Mi dieron click", Toast.LENGTH_LONG).show()
        }
    }
}
