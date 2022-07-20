package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.Sobreviviente
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface SobrevivientesRepository: CrudRepository<Sobreviviente, String> {
    @Query("SELECT * FROM tblSobrevivientes")
    fun listaSobrevivientes(): List<Sobreviviente>
}