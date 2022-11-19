package com.example.proyectodiccionario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectodiccionario.databinding.ActivityRegistrarUsuarioBinding
import com.example.proyectodiccionario.room_database.miSQLiteHelper

class RegistrarUsuarioActivity : AppCompatActivity() {
    //    lateinit var editTextNombreUsuario: EditText
    //    lateinit var editTextUsuario: EditText
    //    lateinit var editTextPassword: EditText

    lateinit var usuarioDBHelper: miSQLiteHelper
    lateinit var binding: ActivityRegistrarUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)

        binding = ActivityRegistrarUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioDBHelper = miSQLiteHelper (this)

        binding.btnRegistrar.setOnClickListener {
            if (binding.createName.text!!.isNotBlank() && binding.createUser.text!!.isNotBlank() && binding.createPassword.text!!.isNotBlank()) {
                usuarioDBHelper.registrarUsuario(
                    binding.createName.text.toString(),
                    binding.createUser.text.toString(),
                    binding.createPassword.text.toString()
                )
                binding.createName.text!!.clear()
                binding.createUser.text!!.clear()
                binding.createPassword.text!!.clear()
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()


            } else {
                Toast.makeText(this, "No se pudo guardar", Toast.LENGTH_LONG).show()
            }
        }
    }
}