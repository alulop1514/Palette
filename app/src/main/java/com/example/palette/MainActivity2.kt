package com.example.palette

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.palette.graphics.Palette
import android.graphics.drawable.BitmapDrawable

import android.R.drawable
import android.graphics.ColorMatrixColorFilter

import android.graphics.ColorMatrix







class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val image = findViewById<ImageFilterView>(R.id.imageView)
        image.setImageResource(intent.extras!!.getInt("LOGO", 0))
        val toolbar = findViewById<Toolbar>(R.id.appbar2)
        setSupportActionBar(toolbar)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val seekBar2 = findViewById<SeekBar>(R.id.seekBar2)
        val contraste = image.contrast
        val warmth = image.warmth
        image.setOnClickListener {
            if (image.saturation == 1f) {
                image.saturation = 0f
            } else {
                image.saturation = 1f
            }
        }
        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, intent.extras!!.getInt("LOGO", 0))

        Palette.from(bitmap).generate { palette ->

            val vibrant: Palette.Swatch? = palette?.vibrantSwatch
            val darkvibrant: Palette.Swatch? = palette?.darkVibrantSwatch

            if (vibrant != null) {
                toolbar.setBackgroundColor(vibrant.rgb)
                toolbar.setTitleTextColor(vibrant.titleTextColor)
            }
            if (darkvibrant != null) {
                window.statusBarColor = darkvibrant.rgb
            }
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                image.contrast = (contraste + p1 * 0.05).toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
        seekBar.max = 10
        seekBar2.max = 10
        seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                image.warmth = (warmth + p1 * 0.1).toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }
}