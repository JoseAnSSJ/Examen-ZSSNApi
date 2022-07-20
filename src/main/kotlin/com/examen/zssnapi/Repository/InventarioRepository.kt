package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.Inventario
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface InventarioRepository : CrudRepository<Inventario, String> {
    @Query("SELECT * FROM tblSobrevivientes")
    fun listaInventario(): List<Inventario>
}