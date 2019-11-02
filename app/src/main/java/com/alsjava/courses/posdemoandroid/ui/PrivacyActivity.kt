package com.alsjava.courses.posdemoandroid.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alsjava.courses.posdemoandroid.R
import com.alsjava.courses.posdemoandroid.utils.SharedPreferencesTool
import kotlinx.android.synthetic.main.activity_privacy.*
import java.io.BufferedReader
import java.io.InputStream

class PrivacyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        tvPrivacyPolicy.setText(loadPrivacy(resources.openRawResource(R.raw.privacy)))
        switchAccept.setOnCheckedChangeListener { _, value ->
            run {
                btnOK.isEnabled = value
            }
        }
        btnOK.setOnClickListener {
            openLogin()
        }
    }

    private fun openLogin() {
        val sharedPreferencesTool = SharedPreferencesTool(this)
        sharedPreferencesTool.showPrivacy = false
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    private fun loadPrivacy(inputStream: InputStream): String {
        val reader = BufferedReader(inputStream.reader())
        var content = ""
        try {
            content = reader.readText()
        } finally {
            reader.close()
        }
        return content;
    }
}
