package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.ReporteInfectadoResonse
import com.examen.zssnapi.BD.Tablas.tblReportesInfectados
import com.examen.zssnapi.Repository.ReporteInfectadoRepository
import org.springframework.stereotype.Service

@Service
class ReporteInfectadoService(val bd: ReporteInfectadoRepository){
    fun listaReporteInfectado(): List<tblReportesInfectados> = bd.listaReporteInfectado()
    fun agregarReporteInfectado(reporteInfectado: tblReportesInfectados): ReporteInfectadoResonse {
        val reporteInfectadoResponse = ReporteInfectadoResonse(
                id_reporte = bd.save(reporteInfectado).id_reporte!!.toInt()
        )
       return reporteInfectadoResponse
    }
}