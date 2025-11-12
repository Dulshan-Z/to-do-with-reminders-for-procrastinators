package com.nibm.procrastinatorstodo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`splash_screen`)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent= Intent(this@MainActivity,HomePage::class.java)
            startActivity(intent)
            finish()
        },3000)

        }

}