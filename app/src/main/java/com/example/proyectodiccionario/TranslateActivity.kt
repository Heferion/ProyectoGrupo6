package com.example.proyectodiccionario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.navigation.NavigationView

class TranslateActivity : AppCompatActivity() {
    private var idioma: Boolean = false
    private var edtTranslate: EditText? =null
//    private lateinit var appbarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)

        var bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        setSupportActionBar(findViewById(R.id.bottomAppBar))

        val fab: View = findViewById(R.id.fab)
        edtTranslate = findViewById(R.id.textFieldTrasn)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)


//        appbarConfiguration = AppBarConfiguration(setOf(R.id.nav_translate,R.id.nav_favorite), drawerLayout)

//        if(edtTranslate!!.text.toString() != ""){
//            fab.visibility= View.VISIBLE
//        }

        fab.setOnClickListener{
            edtTranslate!!.text = null
//            fab.visibility= View.GONE
        }


        bottomAppBar.setNavigationOnClickListener {
            val intento= Intent(this, TranslateActivity::class.java)
            startActivity(intento)
        }

        navView.setNavigationItemSelectedListener {menuItem -> when (menuItem.itemId){
            R.id.nav_favorite -> {
                val intento = Intent(this, FavoritosActivity::class.java)
                startActivity(intento)
                true
            }
            R.id.nav_translate -> {
                val intento = Intent(this, TranslateActivity::class.java)
                startActivity(intento)
                true
            }
            else -> false
        }


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


