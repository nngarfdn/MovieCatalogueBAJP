package com.nanangarifudin.moviecatalogue.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.ui.home.HomeActivity

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)

    }
}