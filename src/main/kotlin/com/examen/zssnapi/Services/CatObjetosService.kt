package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.CatObjetos
import com.examen.zssnapi.Repository.CatObjetosRepository
import org.springframework.stereotype.Service

@Service
class CatObjetosService(val bd: CatObjetosRepository){
    fun listaCatObjetos(): List<CatObjetos> = bd.listaCatObjetos()
}