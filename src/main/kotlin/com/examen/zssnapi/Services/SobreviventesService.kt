package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.PorcentajeResonse
import com.examen.zssnapi.BD.SobrevivientesResponse
import com.examen.zssnapi.BD.Tablas.tblSobrevivientes
import com.examen.zssnapi.BD.okResponse
import com.examen.zssnapi.Repository.SobrevivientesRepository
import org.springframework.stereotype.Service

@Service
class SobreviventesService(val bd: SobrevivientesRepository){
    //se hace la conexion con los servicios y se modifican las respuestas para que la app pueda recibir solo los datos que necesita
    //se puede hacer un bd.save para agregar mas facil los datos
    fun listaSobrevivientes(): List<tblSobrevivientes> = bd.listaSobrevivientes()
    fun agregarSobreviviente(sobreviviente: tblSobrevivientes):  SobrevivientesResponse{
        val sobrevivientesResponse = SobrevivientesResponse(
                id_sobreviviente = bd.save(sobreviviente).id_sobreviviente!!.toInt()
        )
       return  sobrevivientesResponse
    }

    fun getUltimaLocacion(id_sobreviviente: String): SobrevivientesResponse{
        val sobrevivientesResponse = SobrevivientesResponse(
                latitud = bd.getUltimaLocacion(id_sobreviviente).latitud!!,
                longitud = bd.getUltimaLocacion(id_sobreviviente).longitud!!
        )
        return  sobrevivientesResponse
    }

    fun updateUltimaLocacion(id_sobreviviente: String, latitud: String, longitud: String): okResponse{
        val okresponse : okResponse
        if(bd.updateUltimaLocacion(id_sobreviviente,latitud,longitud)==1){
            okresponse= okResponse(
                    mensaje = "Ok"
            )
        }else{
            okresponse= okResponse(
                    mensaje = "Error"
            )
        }
        return  okresponse
    }

    fun listaSobrevivientesNoInfectados(): List<tblSobrevivientes> = bd.listaSobrevivientesNoInfectados()

    fun updateInfectado(id_sobreviviente: String): okResponse{
        val okresponse : okResponse
        if(bd.updateInfectado(id_sobreviviente)==1){
            okresponse= okResponse(
                    mensaje = "Ok"
            )
        }else{
            okresponse= okResponse(
                    mensaje = "Error"
            )
        }
        return  okresponse
    }

    fun getPorcentajeInfectados(): PorcentajeResonse {
        val porcentajeResonse = PorcentajeResonse(
            porcentaje="${bd.getPorcentajeInfectados()} %"
        )
        return porcentajeResonse

    }

    fun getPorcentajeBien(): PorcentajeResonse {
        val porcentajeResonse = PorcentajeResonse(
                porcentaje="${bd.getPorcentajeBien()} %"
        )
        return porcentajeResonse
    }


    fun validaInfectado(id_sobreviviente: Int): Int {
        return bd.validaInfectado(id_sobreviviente)
    }


}