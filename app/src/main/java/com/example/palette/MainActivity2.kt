package com.example.palette

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.palette.graphics.Palette

class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val image = findViewById<ImageFilterView>(R.id.imageView)
        image.setImageResource(intent.extras!!.getInt("LOGO", 0))
        val toolbar = findViewById<Toolbar>(R.id.appbar2)
        setSupportActionBar(toolbar)
        val textView1 = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
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
    }
}