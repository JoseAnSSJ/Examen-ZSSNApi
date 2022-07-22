package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.Tablas.tblSobrevivientes
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jdbc.repository.QueryMappingConfiguration
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.repository.CrudRepository

interface SobrevivientesRepository: CrudRepository<tblSobrevivientes, String> {
    //Se crean los querys para consultarlos de la base de datos
    //Se agrega el Modifying para poder hacer los updates
    @Query("SELECT * FROM TBLSOBREVIVIENTES")
    fun listaSobrevivientes(): List<tblSobrevivientes>

    @Query("SELECT latitud,longitud FROM TBLSOBREVIVIENTES WHERE id_sobreviviente = :id_sobreviviente")
    fun getUltimaLocacion(id_sobreviviente: String): tblSobrevivientes

    @Modifying
    @Query("UPDATE TBLSOBREVIVIENTES SET latitud =:latitud ,longitud=:longitud WHERE id_sobreviviente = :id_sobreviviente")
    fun updateUltimaLocacion(id_sobreviviente: String, latitud: String, longitud: String): Int

    @Query("SELECT * FROM TBLSOBREVIVIENTES WHERE es_infectado = false")
    fun listaSobrevivientesNoInfectados(): List<tblSobrevivientes>

    @Modifying
    @Query("UPDATE TBLSOBREVIVIENTES SET es_infectado=true WHERE id_sobreviviente =:id_sobreviviente")
    fun updateInfectado(id_sobreviviente: String): Int

    @Query("SELECT TOP 1 ((SELECT COUNT(*) FROM TBLSOBREVIVIENTES WHERE es_infectado = true) * 100) /SELECT COUNT(*) FROM TBLSOBREVIVIENTES as porcentaje FROM TBLSOBREVIVIENTES")
    fun getPorcentajeInfectados(): Double

    @Query("SELECT TOP 1 ((SELECT COUNT(*) FROM TBLSOBREVIVIENTES WHERE es_infectado = false) * 100)/SELECT COUNT(*) FROM TBLSOBREVIVIENTES as porcentaje FROM TBLSOBREVIVIENTES")
    fun getPorcentajeBien(): Double

    @Query("SELECT count(*) FROM tblReportesInfectados where id_sobreviviente_infectado=:id_sobreviviente")
    fun validaInfectado(id_sobreviviente: Int): Int

}