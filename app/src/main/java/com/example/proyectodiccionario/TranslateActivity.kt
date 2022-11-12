package com.example.proyectodiccionario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyectodiccionario.R.drawable
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputEditText

class TranslateActivity : AppCompatActivity() {
    private var idioma: Boolean = false
    private var edtTranslate: EditText? = null
    private lateinit var appbarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)

        var bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        setSupportActionBar(findViewById(R.id.bottomAppBar))

        val fab: View = findViewById(R.id.fab)
        edtTranslate = findViewById(R.id.textFieldTrasn)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        appbarConfiguration = AppBarConfiguration(setOf(R.id.nav_translate,R.id.nav_todo,R.id.nav_profile), drawerLayout)
        setupActionBarWithNavController(navController, appbarConfiguration)
        navView.setupWithNavController(navController)



        fab.setOnClickListener {
            edtTranslate!!.text = null

        }

        bottomAppBar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_translate -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_todo -> {
                    val intento = Intent(this, FavoritosActivity::class.java)
                    startActivity(intento)
                    true
                }
                R.id.nav_profile -> {
                    val intento = Intent(this, ConjugacionActivity::class.java)
                    startActivity(intento)
                    true
                }
                else -> false
            }


        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        return navController.navigateUp(appbarConfiguration) || super.onSupportNavigateUp()
    }

    fun cambiarIdioma(btnChange: View) {
        var botonIngles = findViewById<Button>(R.id.containerButtonEn)
        var botonEspanol = findViewById<Button>(R.id.containerButtonEs)
        if (idioma == false) {
            this.idioma = true
            botonIngles.setText(R.string.txt_es)
            botonEspanol.setText(R.string.txt_en)
        } else {
            this.idioma = false
            botonIngles.setText(R.string.txt_en)
            botonEspanol.setText(R.string.txt_es)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.favourite -> {
            val intento = Intent(this, FavoritosActivity::class.java)
            startActivity(intento)

            true
        }

        R.id.conjugation -> {
            val intento = Intent(this, ConjugacionActivity::class.java)
            startActivity(intento)
            true
        }

        R.id.more -> {
            // Handle more item (inside overflow menu) press
            true
        }
        else -> false
    }

    fun traducir(btnTraslate: View) {
        var txt_traducir = edtTranslate?.text.toString().lowercase()
        var traduccion = findViewById<TextView>(R.id.txtTraslate)
        var imgTraduccion = findViewById<ImageView>(R.id.imgTraslate)

        txt_traducir= txt_traducir.replace("\\s+".toRegex(), "")

        if (txt_traducir != null){
            if (txt_traducir == "arbol"){
                traduccion.setText("Tree")
                imgTraduccion.setImageResource(R.drawable.arbol)
            }else if (txt_traducir == "árbol"){
                traduccion.setText("Tree")
                imgTraduccion.setImageResource(R.drawable.arbol)
            }else if(txt_traducir == "correr"){
                traduccion.setText("Run")
                imgTraduccion.setImageResource(R.drawable.correr)
            }

        }

    }

}



