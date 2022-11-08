package com.example.proyectodiccionario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.navigation.NavigationView

class FavoritosActivity : AppCompatActivity() {
    private lateinit var appbarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)
        var bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        setSupportActionBar(findViewById(R.id.bottomAppBar))
        bottomAppBar.setNavigationOnClickListener {
            val intento= Intent(this, TranslateActivity::class.java)
            startActivity(intento)
        }

        val fab: View = findViewById(R.id.fab)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        appbarConfiguration = AppBarConfiguration(setOf(R.id.nav_todo), drawerLayout)
        setupActionBarWithNavController(navController, appbarConfiguration)
        navView.setupWithNavController(navController)

        bottomAppBar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        if(savedInstanceState ==null){
            val datos = Bundle()
            datos.putString("txtListFavP", "Árbol")
            datos.putString("txtListFavS","Tree")
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, ToDoFragment::class.java,  datos, "todo")
                .commit()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_app_bar,menu)
        return  super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.favourite -> {
            val intentoFav= Intent(this, FavoritosActivity::class.java)
            startActivity(intentoFav)
            true
        }

        R.id.conjugation -> {
            val intentoConj= Intent(this, ConjugacionActivity::class.java)
            startActivity(intentoConj)
            true
        }

        R.id.more -> {
            // Handle more item (inside overflow menu) press
            true
        }
        else -> false
    }
}