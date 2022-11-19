package com.example.proyectodiccionario.room_database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//2. herecia de SQLITEOPENHELPER
class miSQLiteHelper(context: Context):SQLiteOpenHelper(context,"diccionario.db",null,1) {



    override fun onCreate(db: SQLiteDatabase?) {
        //3. orden de creacion de la tabla
        val ordenCreacionUsuario="CREATE TABLE usuario"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT, email TEXT UNIQUE,password TEXT)"
        db!!.execSQL(ordenCreacionUsuario)

        val ordenCreacionFav="CREATE TABLE favorito"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT, usuario TEXT,email TEXT)"
        db!!.execSQL(ordenCreacionFav)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {  //detecta el numero de vercion
                 val ordenBorrado="DROP TABLE IF EXISTS amigos"
                 db!!.execSQL(ordenBorrado)
                 onCreate(db)

    }

    fun registrarUsuario(nombre:String, email:String, password:String){
        val datos=ContentValues()  //mainipulacion de datos Clave Valor
        datos.put("nombre",nombre)
        datos.put("email",email)
        datos.put("password",password)

    //guardar los datos
       val db=this.writableDatabase  // la base de datos se pone en modo de escritura
        db.insert("usuario",null,datos)
        db.close()
    }

    fun borrardato(id:Int):Int{
        val args= arrayOf(id.toString())
        //guardar los datos
        val db=this.writableDatabase  // la base de datos se pone en modo de escritura
        val borrados=db.delete("usuario","_id=?",args) // id igual a args osea el tercer parametro
        db.close()
        return borrados     // devuele el numero de elementos borrados
    }
    fun editardato(id:Int,nombre:String, email:String, password: String){
        val args= arrayOf(id.toString())

        val datos=ContentValues()  //Nuevos parametros para actualizar
        datos.put("nombre",nombre)
        datos.put("email",email)
        datos.put("password",password)

        //guardar los datos
        val db=this.writableDatabase  // la base de datos se pone en modo de escritura
        db.update("usuario",datos,"_id=?",args)
        db.close()
    }














}


