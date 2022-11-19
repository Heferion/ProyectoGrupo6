package com.example.proyectodiccionario

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.proyectodiccionario.room_database.miSQLiteHelper

import com.google.android.material.textfield.TextInputLayout
import com.example.proyectodiccionario.databinding.ActivityMainBinding
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    private var edtUserName: EditText? = null
    private var edtPassword: EditText? = null

    lateinit var usuarioDBHelper: miSQLiteHelper
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUserName = findViewById(R.id.textUser)
        edtPassword = findViewById(R.id.textPassword)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioDBHelper = miSQLiteHelper (this)
    }

    fun onLogin(btn_join: View) {
        val userLayout = findViewById<TextInputLayout>(R.id.outlinedTexUser)
//        var usuario = edtUserName!!.text.toString().lowercase().replace("\\s+".toRegex(), "")
        val passwordLayout = findViewById<TextInputLayout>(R.id.outlinedTextPassword)

        var usuarioEmail = binding.textUser!!.text.toString().lowercase().replace("\\s+".toRegex(), "")
        var contrasena =  binding.textPassword!!.text.toString()

//        val user=binding.textUser!!.text.toString()

        if (usuarioEmail!=""){
            val db:SQLiteDatabase =usuarioDBHelper.readableDatabase
            val cursor=db.rawQuery("SELECT * FROM usuario WHERE email = '${usuarioEmail}'",null)
            if(cursor.moveToFirst()){
                if (cursor.getString(3).toString().equals(contrasena)) {
                    userLayout.error = null
                    passwordLayout.error = null
                    val intento = Intent(this, TranslateActivity::class.java)
                    intento.putExtra("usuario",cursor.getString(1).toString())
                    startActivity(intento)
                } else {
                    passwordLayout.error = getString(R.string.password_error)
                    userLayout.error = null
                }
            }else {
                userLayout.error = getString(R.string.user_error)
                passwordLayout.error = null
            }
        }else {
            userLayout.error = getString(R.string.user_error)
            passwordLayout.error = null
        }


//        val intento= Intent(this, TranslateActivity::class.java)
//        startActivity(intento)

    }

    fun signUp(btn_sing_up: View) {
        val intento = Intent(this, RegistrarUsuarioActivity::class.java)
        startActivity(intento)
    }
}