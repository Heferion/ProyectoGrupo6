package com.example.proyectodiccionario.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey (autoGenerate = true) val id: Int,
    val palabraFavorita: String?,
    val palabraTraducida: String?
)