package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.Tablas.catObjetos
import com.examen.zssnapi.Repository.CatObjetosRepository
import org.springframework.stereotype.Service

@Service
class CatObjetosService(val bd: CatObjetosRepository){
    fun listaCatObjetos(): List<catObjetos> = bd.listaCatObjetos()
}