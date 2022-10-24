package com.example.proyectodiccionario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.google.android.material.bottomappbar.BottomAppBar

class TranslateActivity : AppCompatActivity() {
    private var idioma: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)
        var bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        setSupportActionBar(findViewById(R.id.bottomAppBar))
        bottomAppBar.setNavigationOnClickListener {
            val intento= Intent(this, TranslateActivity::class.java)
            startActivity(intento)
        }

    }

    fun cambiarIdioma(btnChange: View){
        var botonIngles = findViewById<Button>(R.id.containerButtonEn)
        var botonEspanol = findViewById<Button>(R.id.containerButtonEs)
        if (idioma == false){
            this.idioma=true
            botonIngles.setText(R.string.txt_es)
            botonEspanol.setText(R.string.txt_en)
        }
        else{
            this.idioma=false
            botonIngles.setText(R.string.txt_en)
            botonEspanol.setText(R.string.txt_es)
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


