package com.manu.memeappretrofitmvvm

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.manu.memeappretrofitmvvm.activities.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                finish()
            },
            2000
        )
    }
}