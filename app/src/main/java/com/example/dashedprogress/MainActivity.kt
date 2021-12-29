package com.example.dashedprogress

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.shahnavaz.dashedprogress.customProgress.CustomLineDashedProgressBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progress = findViewById<CustomLineDashedProgressBarView>(R.id.progressBar)
        val progressBar2 = findViewById<CustomLineDashedProgressBarView>(R.id.progressBar2)
        progress.setProgress(70.0f)
        val animation = ValueAnimator.ofFloat( 0f, 100f);
        animation.addUpdateListener {
            progressBar2.setProgress(it.animatedValue as Float)
        }
        animation.duration = 5000L;
        animation.interpolator = LinearInterpolator();
        animation.start();
    }
}