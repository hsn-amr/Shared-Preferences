package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key),
                                                            Context.MODE_PRIVATE)

        val tv = findViewById<TextView>(R.id.textView)
        val et = findViewById<EditText>(R.id.editText)

        val activityButton = findViewById<Button>(R.id.btnActivity)
        val sharedButton = findViewById<Button>(R.id.btnShared)
        val goButton = findViewById<Button>(R.id.btnGo)

        activityButton.setOnClickListener {
            tv.text = et.text
        }
        sharedButton.setOnClickListener {
            with(sharedPreferences.edit()) {
                putString("text", et.text.toString())
                apply()
            }
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
        }
        goButton.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }
    }
}