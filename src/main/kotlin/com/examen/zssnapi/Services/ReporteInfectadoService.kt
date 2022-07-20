package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.Tablas.tblReportesInfectados
import com.examen.zssnapi.Repository.ReporteInfectadoRepository
import org.springframework.stereotype.Service

@Service
class ReporteInfectadoService(val bd: ReporteInfectadoRepository){
    fun listaReporteInfectado(): List<tblReportesInfectados> = bd.listaReporteInfectado()
    fun agregarReporteInfectado(reporteInfectado: tblReportesInfectados): tblReportesInfectados{
       return bd.save(reporteInfectado)
    }
}