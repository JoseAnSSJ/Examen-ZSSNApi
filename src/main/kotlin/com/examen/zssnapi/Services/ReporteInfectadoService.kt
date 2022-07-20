package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.ReporteInfectado
import com.examen.zssnapi.Repository.ReporteInfectadoRepository
import org.springframework.stereotype.Service

@Service
class ReporteInfectadoService(val bd: ReporteInfectadoRepository){
    fun listaReporteInfectado(): List<ReporteInfectado> = bd.listaReporteInfectado()
    fun agregarReporteInfectado(reporteInfectado: ReporteInfectado){
        bd.save(reporteInfectado)
    }
}