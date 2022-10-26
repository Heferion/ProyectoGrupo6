package com.example.proyectodiccionario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private var edtUserName: EditText? =null
    private var edtPassword: EditText? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtUserName = findViewById(R.id.textUser)
        edtPassword = findViewById(R.id.textPassword)
    }
    fun onLogin(btn_join: View){
        val  userLayout= findViewById<TextInputLayout>(R.id.outlinedTexUser)
        val passwordLayout = findViewById<TextInputLayout>(R.id.outlinedTextPassword)
        if (edtUserName!!.text.toString() =="jeff@gmail.com"){
            if (edtPassword!!.text.toString() == "1234") {
                userLayout.error = null
                passwordLayout.error = null
                val intento= Intent(this, TranslateActivity::class.java)
                startActivity(intento)
            }
            else{
                passwordLayout.error = getString(R.string.password_error)
                userLayout.error = null
            }
        }
        else{
            userLayout.error = getString(R.string.user_error)
            passwordLayout.error = null
        }

//        val intento= Intent(this, TranslateActivity::class.java)
//        startActivity(intento)

    }
}