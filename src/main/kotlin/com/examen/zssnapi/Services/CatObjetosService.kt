package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.Tablas.catObjetos
import com.examen.zssnapi.Repository.CatObjetosRepository
import org.springframework.stereotype.Service

@Service
class CatObjetosService(val bd: CatObjetosRepository){
    //se hace la conexion con los servicios
    fun listaCatObjetos(): List<catObjetos> = bd.listaCatObjetos()
}