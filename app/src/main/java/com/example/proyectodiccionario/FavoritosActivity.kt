package com.example.proyectodiccionario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomappbar.BottomAppBar

class FavoritosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)
        var bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        setSupportActionBar(findViewById(R.id.bottomAppBar))
        bottomAppBar.setNavigationOnClickListener {
            val intento= Intent(this, TranslateActivity::class.java)
            startActivity(intento)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_app_bar,menu)
        return  super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.favourite -> {
            val intento= Intent(this, FavoritosActivity::class.java)
            startActivity(intento)
            true
        }

        R.id.conjugation -> {
            val intento= Intent(this, ConjugacionActivity::class.java)
            startActivity(intento)
            true
        }

        R.id.more -> {
            // Handle more item (inside overflow menu) press
            true
        }
        else -> false
    }
}