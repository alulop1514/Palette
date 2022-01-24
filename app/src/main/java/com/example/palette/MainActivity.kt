package com.example.palette

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.appbar)
        setSupportActionBar(toolbar)

        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.drawable.image1))
        items.add(Tarjeta(R.drawable.image2))
        items.add(Tarjeta(R.drawable.image3))
        items.add(Tarjeta(R.drawable.image4))
        items.add(Tarjeta(R.drawable.image5))
        items.add(Tarjeta(R.drawable.image6))
        items.add(Tarjeta(R.drawable.image7))
        items.add(Tarjeta(R.drawable.image8))

        val recView = findViewById<RecyclerView>(R.id.recview)

        recView.setHasFixedSize(true)

        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick  = {
            val intent = Intent(this, MainActivity2::class.java)
            val sharedImageView = it.findViewById<ImageView>(R.id.image1)
            val item = items.get(recView.getChildAdapterPosition(it))
            intent.putExtra("LOGO", item.imagen)
            val p1 = Pair.create<View, String>(sharedImageView, sharedImageView.transitionName)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedImageView, sharedImageView.transitionName).toBundle()
            //Añadimos la información al Intent
            options!!.putInt("LOGO", item.imagen)
            startActivity(intent, options)
        }
    }
}