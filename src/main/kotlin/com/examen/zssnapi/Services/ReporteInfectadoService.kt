package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.ReporteInfectadoResonse
import com.examen.zssnapi.BD.Tablas.tblReportesInfectados
import com.examen.zssnapi.Repository.ReporteInfectadoRepository
import org.springframework.stereotype.Service

@Service
class ReporteInfectadoService(val bd: ReporteInfectadoRepository){
    //se hace la conexion con los servicios y se modifican las respuestas para que la app pueda recibir solo los datos que necesita
    //se puede hacer un bd.save para agregar mas facil los datos
    fun listaReporteInfectado(): List<tblReportesInfectados> = bd.listaReporteInfectado()
    fun agregarReporteInfectado(reporteInfectado: tblReportesInfectados): ReporteInfectadoResonse {
        val reporteInfectadoResponse = ReporteInfectadoResonse(
                id_reporte = bd.save(reporteInfectado).id_reporte!!.toInt()
        )
       return reporteInfectadoResponse
    }
}