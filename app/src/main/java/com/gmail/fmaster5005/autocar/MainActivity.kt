package com.gmail.fmaster5005.autocar

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import android.widget.Button
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import kotlinx.coroutines.delay
import kotlin.concurrent.timer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resourceId2 = resources.getIdentifier("status_bar_height", "dimen", "android")
        var statusBarHeight = 0
        if (resourceId2 > 0) {
            statusBarHeight = resources.getDimensionPixelSize(resourceId2)
        }

        val resourceId1: Int = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        var navigationBarHeight = 0
        if (resourceId1 > 0) {
            navigationBarHeight = resources.getDimensionPixelSize(resourceId1)
        }

        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        val dpi = metrics.densityDpi

        val btn: Button = findViewById(R.id.button)
        val txt: TextView = findViewById(R.id.textView)

        btn.setOnTouchListener { view, event ->

            view.x = event.rawX
            view.y = event.rawY - statusBarHeight

            txt.text = "(${event.rawX}, ${event.rawY})"

            true
        }
    }
}