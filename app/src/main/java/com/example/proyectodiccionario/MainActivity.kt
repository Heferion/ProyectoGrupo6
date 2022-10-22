package com.example.proyectodiccionario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onLogin(btn_join: View){
        val intento= Intent(this, TranslateActivity::class.java)
        startActivity(intento)
    }
}