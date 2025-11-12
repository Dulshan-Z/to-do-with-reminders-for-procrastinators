package com.nibm.procrastinatorstodo

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        val searchView = findViewById<SearchView>(R.id.searchView)
        val params = searchView.layoutParams
        params.height = 100
        searchView.layoutParams = params

    }
}