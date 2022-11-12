package com.example.proyectodiccionario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.navigation.NavigationView

class ConjugacionActivity : AppCompatActivity() {

    private lateinit var appbarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conjugacion)
        var bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        setSupportActionBar(findViewById(R.id.bottomAppBar))
        bottomAppBar.setNavigationOnClickListener {
            val intento= Intent(this, TranslateActivity::class.java)
            startActivity(intento)
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        appbarConfiguration = AppBarConfiguration(setOf(R.id.nav_translate,R.id.nav_todo,R.id.nav_profile), drawerLayout)
        setupActionBarWithNavController(navController, appbarConfiguration)
        navView.setupWithNavController(navController)

        bottomAppBar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_translate -> {
                    val intento = Intent(this, TranslateActivity::class.java)
                    startActivity(intento)
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