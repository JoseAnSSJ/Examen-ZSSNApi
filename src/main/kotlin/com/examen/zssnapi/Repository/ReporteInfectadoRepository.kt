package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.Tablas.tblReportesInfectados
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ReporteInfectadoRepository : CrudRepository<tblReportesInfectados, String> {
    //Se crean los querys para consultarlos de la base de datos
    @Query("SELECT * FROM tblReportesInfectados")
    fun listaReporteInfectado(): List<tblReportesInfectados>
}