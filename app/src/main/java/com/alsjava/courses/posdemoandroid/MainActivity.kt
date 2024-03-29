package com.alsjava.courses.posdemoandroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.alsjava.courses.posdemoandroid.ui.IntroActivity
import com.alsjava.courses.posdemoandroid.ui.LoginActivity
import com.alsjava.courses.posdemoandroid.ui.PrivacyActivity
import com.alsjava.courses.posdemoandroid.utils.Constants
import com.alsjava.courses.posdemoandroid.utils.NetworkTool
import com.alsjava.courses.posdemoandroid.utils.SharedPreferencesTool
import com.alsjava.courses.posdemoandroid.utils.db.POSDemoDB
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        val sharedPreferencesTool = SharedPreferencesTool(this)
        // Subo el net watcher
        NetworkTool.get().prepare(this)
        // Instancio la DB
        val databaseBuilder = Room.databaseBuilder(
                applicationContext,
                POSDemoDB::class.java, POSDemoDB.DB_NAME
        )
        Constants.get().posDemoDB = databaseBuilder.build()
        // Espero unos segundos para mostrar mi logo
        Handler().postDelayed(
                {
                    if (sharedPreferencesTool.showIntro) {
                        openIntro()
                    } else if (sharedPreferencesTool.showPrivacy) {
                        openPrivacy()
                    } else {
                        openLogin()
                    }
                }, TimeUnit.SECONDS.toMillis(1)
        )
    }

    fun openLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    fun openIntro() {
        val intent = Intent(this, IntroActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    fun openPrivacy() {
        val intent = Intent(this, PrivacyActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
