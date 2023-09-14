package com.gmail.fmaster5005.autocar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class ControllersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controllers)

        val button: Button = findViewById(R.id.buttonMenu)
        button.setOnClickListener {
            finish()
        }
    }
}