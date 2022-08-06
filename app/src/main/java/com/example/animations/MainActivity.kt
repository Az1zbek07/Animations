package com.example.animations

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    private fun initViews(){
        animations()
    }
    private fun animations(){
        val blink = AnimationUtils.loadAnimation(this, R.anim.blink)
        val bounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        val move = AnimationUtils.loadAnimation(this, R.anim.move)
        val sequentual = AnimationUtils.loadAnimation(this, R.anim.sequentual)
        val slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        val together = AnimationUtils.loadAnimation(this, R.anim.together)
        val zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        val zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)

        imageView = findViewById(R.id.imageView)
        var btnBounce: MaterialButton = findViewById(R.id.btnBounce)
        var btnBlink: MaterialButton = findViewById(R.id.btnBlink)
        var btnFadeIn: MaterialButton = findViewById(R.id.btnFadeiN)
        var btnFadeOut: MaterialButton = findViewById(R.id.btnFadeOut)
        var btnMove: MaterialButton = findViewById(R.id.btnMove)
        var btnPotate: MaterialButton = findViewById(R.id.btnPotate)
        var btnSequento: MaterialButton = findViewById(R.id.btnSequento)
        var btnSlideShow: MaterialButton = findViewById(R.id.btnSlideShow)
        var btnSlideUp: MaterialButton = findViewById(R.id.btnSlideUp)
        var btnTogether: MaterialButton = findViewById(R.id.btnTogether)
        var btnZoomIn: MaterialButton = findViewById(R.id.btnZoomIn)
        var btnZoomOut: MaterialButton = findViewById(R.id.btnZoomOut)
        var btnGo: MaterialButton = findViewById(R.id.btnGo)

        btnBlink.setOnClickListener {
            imageView.startAnimation(blink)
        }
        btnBounce.setOnClickListener {
            imageView.startAnimation(bounce)
        }
        btnFadeIn.setOnClickListener {
            imageView.startAnimation(fadeIn)
        }
        btnFadeOut.setOnClickListener {
            imageView.startAnimation(fadeOut)
        }
        btnMove.setOnClickListener {
            imageView.startAnimation(move)
        }
        btnSequento.setOnClickListener {
            imageView.startAnimation(sequentual)
        }
        btnSlideShow.setOnClickListener {
            imageView.startAnimation(slideDown)
        }
        btnSlideUp.setOnClickListener {
            imageView.startAnimation(slideUp)
        }
        btnTogether.setOnClickListener {
            imageView.startAnimation(together)
        }
        btnZoomIn.setOnClickListener {
            imageView.startAnimation(zoomIn)
        }
        btnZoomOut.setOnClickListener {
            imageView.startAnimation(zoomOut)
        }

        btnGo.setOnClickListener {
            val intent = Intent(this, LottiActivity::class.java)
            startActivity(intent)
        }
    }

    private fun alphaAnimation(){
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.apply {
            duration = 80
            startOffset = 20
            repeatCount = Animation.INFINITE
            repeatMode = Animation.REVERSE
        }
        imageView.startAnimation(anim)
    }

    private fun objectAnimation(){
        val obj = ObjectAnimator.ofFloat(imageView, "rotation", 1000f)
        obj.duration = 2000
        obj.repeatCount = Animation.INFINITE
        obj.start()
    }

    private fun scaleX(){
        val scaleAnim = ObjectAnimator.ofFloat(imageView, "ScaleX", 1.0f, 2.0f)
        scaleAnim.apply {
            duration = 3000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            start()
        }
    }

    private fun move(){
        val moveAnim = ObjectAnimator.ofFloat(imageView, "Y", 1000f)
        moveAnim.apply {
            duration = 2000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            interpolator = BounceInterpolator()
            start()
        }
    }
}