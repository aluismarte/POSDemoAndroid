package com.alsjava.courses.posdemoandroid.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alsjava.courses.posdemoandroid.BuildConfig
import com.alsjava.courses.posdemoandroid.R
import com.alsjava.courses.posdemoandroid.model.communication.request.LoginRequest
import com.alsjava.courses.posdemoandroid.utils.Constants
import com.alsjava.courses.posdemoandroid.utils.ServiceTool
import com.alsjava.courses.posdemoandroid.utils.security.HashTools
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        tvVersion.text = BuildConfig.VERSION_NAME
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            ServiceTool.get().login(LoginRequest(username, HashTools.encodeSHA512(password))) {
                if (it != null && it.code == 0) {
                    Constants.get().session = it.session;
                    Constants.get().terminal = it.terminal;
                    Constants.get().terminalName = it.terminalName;
                    openApp()
                }
            }
        }
    }

    fun openApp() {
        val intent = Intent(this, AppActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
