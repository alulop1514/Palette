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
import androidx.palette.graphics.Palette

class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val image = findViewById<ImageView>(R.id.imageView)
        image.setImageResource(intent.extras!!.getInt("LOGO", 0))
        val toolbar = findViewById<Toolbar>(R.id.appbar2)
        setSupportActionBar(toolbar)
        val textView1 = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView4 = findViewById<TextView>(R.id.textView4)


        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, intent.extras!!.getInt("LOGO", 0))

        Palette.from(bitmap).generate { palette ->

            val vibrant: Palette.Swatch? = palette?.vibrantSwatch
            val darkvibrant: Palette.Swatch? = palette?.darkVibrantSwatch
            val lightvibrant: Palette.Swatch? = palette?.lightVibrantSwatch
            val muted: Palette.Swatch? = palette?.mutedSwatch
            val darkmuted: Palette.Swatch? = palette?.darkMutedSwatch
            val lightmuted: Palette.Swatch? = palette?.lightMutedSwatch

            if (vibrant != null) {
                toolbar.setBackgroundColor(vibrant.rgb)
                toolbar.setTitleTextColor(vibrant.titleTextColor)
            }
            if (darkvibrant != null) {
                window.statusBarColor = darkvibrant.rgb
            }
            if (lightvibrant != null) {
                textView1.setBackgroundColor(lightvibrant.rgb)
                textView1.setTextColor(lightvibrant.bodyTextColor)
            }
            if (muted != null) {
                textView2.setBackgroundColor(muted.rgb)
                textView2.setTextColor(muted.bodyTextColor)
            }
            if (darkmuted != null) {
                textView3.setBackgroundColor(darkmuted.rgb)
                textView3.setTextColor(darkmuted.bodyTextColor)
            }
            if (lightmuted != null) {
                textView4.setBackgroundColor(lightmuted.rgb)
                textView4.setTextColor(lightmuted.bodyTextColor)

            }
        }
    }
}