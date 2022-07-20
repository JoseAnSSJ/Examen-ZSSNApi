package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.Tablas.catObjetos
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface CatObjetosRepository : CrudRepository<catObjetos, String> {
    @Query("SELECT * FROM catObjetos")
    fun listaCatObjetos(): List<catObjetos>
}