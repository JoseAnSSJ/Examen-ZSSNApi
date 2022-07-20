package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.CatObjetos
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface CatObjetosRepository : CrudRepository<CatObjetos, String> {
    @Query("SELECT * FROM catObjetos")
    fun listaCatObjetos(): List<CatObjetos>
}