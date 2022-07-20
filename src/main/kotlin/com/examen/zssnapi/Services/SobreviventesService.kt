package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.Tablas.tblSobrevivientes
import com.examen.zssnapi.Repository.SobrevivientesRepository
import org.springframework.stereotype.Service

@Service
class SobreviventesService(val bd: SobrevivientesRepository){
    fun listaSobrevivientes(): List<tblSobrevivientes> = bd.listaSobrevivientes()
    fun agregarSobreviviente(sobreviviente: tblSobrevivientes): tblSobrevivientes{
       return  bd.save(sobreviviente)
    }

    fun getUltimaLocacion(id_sobreviviente: String): tblSobrevivientes{
        return  bd.getUltimaLocacion(id_sobreviviente)
    }

    fun updateUltimaLocacion(id_sobreviviente: String, latitud: String, longitud: String): tblSobrevivientes{
        return  bd.updateUltimaLocacion(id_sobreviviente,latitud,longitud)
    }

    fun listaSobrevivientesNoInfectados(): List<tblSobrevivientes> = bd.listaSobrevivientesNoInfectados()

    fun updateInfectado(id_sobreviviente: String): tblSobrevivientes{
        return  bd.updateInfectado(id_sobreviviente)
    }

    fun getPorcentajeInfectados(): Double = bd.getPorcentajeInfectados()

    fun getPorcentajeBien(): Double = bd.getPorcentajeBien()
}