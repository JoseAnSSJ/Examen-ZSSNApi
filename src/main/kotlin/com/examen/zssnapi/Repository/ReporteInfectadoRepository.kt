package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.ReporteInfectado
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ReporteInfectadoRepository : CrudRepository<ReporteInfectado, String> {
    @Query("SELECT * FROM tblReportesInfectados")
    fun listaReporteInfectado(): List<ReporteInfectado>
}