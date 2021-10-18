package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val sharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key),
            Context.MODE_PRIVATE)

        val tv = findViewById<TextView>(R.id.textView2)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            tv.text = sharedPreferences.getString("text", "")
        }
    }
}