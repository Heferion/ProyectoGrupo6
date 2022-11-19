package com.example.proyectodiccionario

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectodiccionario.room_database.ToDo
import com.example.proyectodiccionario.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NewTaskActivity: AppCompatActivity(){
    lateinit var editTextFavorito: EditText
    lateinit var editTextTraduccion: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_to_do)
        editTextFavorito = findViewById(R.id.txtListFavP)
        editTextFavorito = findViewById(R.id.txtListFavS)
    }

    fun onSave(view: View){
        val db = ToDoDatabase.getDatabase(this)
        val todoDAO = db.todoDao()
        val task =  ToDo(0,editTextFavorito.text.toString(), editTextTraduccion.text.toString())
        runBlocking {
            launch {
                var result = todoDAO.insertTask(task)
                if(result!=-1L){
                    setResult(Activity.RESULT_OK)
                    finish()
                }
            }
        }
    }

}














































