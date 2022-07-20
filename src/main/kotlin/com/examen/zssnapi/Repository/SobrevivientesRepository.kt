package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.Tablas.tblSobrevivientes
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface SobrevivientesRepository: CrudRepository<tblSobrevivientes, String> {
    @Query("SELECT * FROM TBLSOBREVIVIENTES")
    fun listaSobrevivientes(): List<tblSobrevivientes>

    @Query("SELECT latitud,longitud FROM TBLSOBREVIVIENTES WHERE id_sobreviviente = :id_sobreviviente")
    fun getUltimaLocacion(id_sobreviviente: String): tblSobrevivientes

    @Query("UPDATE TBLSOBREVIVIENTES SET latitud =?2 ,longitud=?3 WHERE id_sobreviviente = ?1")
    fun updateUltimaLocacion(id_sobreviviente: String, latitud: String, longitud: String): tblSobrevivientes

    @Query("SELECT * FROM TBLSOBREVIVIENTES WHERE es_infectado = 0")
    fun listaSobrevivientesNoInfectados(): List<tblSobrevivientes>

    @Query("UPDATE TBLSOBREVIVIENTES SET es_infectado=1 WHERE id_sobreviviente = ?1")
    fun updateInfectado(id_sobreviviente: String): tblSobrevivientes

    @Query("SELECT (SELECT COUNT(*) FROM TBLSOBREVIVIENTES WHERE es_infectado = 1)/(SELECT COUNT(*) FROM TBLSOBREVIVIENTES ) * as porcentaje FROM TBLSOBREVIVIENTES")
    fun getPorcentajeInfectados(): Double

    @Query("SELECT (SELECT COUNT(*) FROM TBLSOBREVIVIENTES WHERE es_infectado = 0)/(SELECT COUNT(*) FROM TBLSOBREVIVIENTES ) * as porcentaje FROM TBLSOBREVIVIENTES")
    fun getPorcentajeBien(): Double

}