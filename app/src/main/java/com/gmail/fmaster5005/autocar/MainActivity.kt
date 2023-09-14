package com.gmail.fmaster5005.autocar

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tmp: Float = 0f
        var tmp1: Float = 0f

        val textField = findViewById<TextView>(R.id.textView3)
        val button: Button = findViewById(R.id.buttonControllers)
        button.setOnTouchListener { view, event ->

            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    tmp = event.rawX - view.x
                    tmp1 = event.rawY - 72f - view.y
                }

                MotionEvent.ACTION_MOVE -> {
                    view.x = event.rawX - tmp
                    view.y = event.rawY  - 72f - tmp1
                }
            }


            textField.text = "(${tmp}, ${tmp1})"



            true
        }

        val joystick_fc: Button = findViewById(R.id.joystick_fc)

        val joystick: Button = findViewById(R.id.joystick)
        joystick.setOnTouchListener { view, event ->

            val joystickCoordX = (event.rawX  - joystick.width/2f - view.x).toDouble()
            val joystickCoordY = (event.rawY - 72f - joystick.width/2f - view.y).toDouble()
            val joystickRadius = (joystick.width/2f).toDouble()

            if(Math.pow(joystickCoordX, 2.0) + Math.pow(joystickCoordY, 2.0) <= Math.pow(joystickRadius, 2.0)){
                when(event.action) {
                    MotionEvent.ACTION_MOVE -> {
                        joystick_fc.y = event.rawY - 72f - joystick_fc.width/2f
                        joystick_fc.x = event.rawX - joystick_fc.width/2f
                    }

                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                        joystick_fc.y = view.y + joystick.width/2f - joystick_fc.width/2f
                        joystick_fc.x = view.x + joystick.width/2f - joystick_fc.width/2f
                    }
                }
            }
            else{
                joystick_fc.y = view.y + joystick.width/2f - joystick_fc.width/2f
                joystick_fc.x = view.x + joystick.width/2f - joystick_fc.width/2f
            }

            true
        }
        joystick.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                joystick_fc.y
                1 +1
            }
        }
    }
}