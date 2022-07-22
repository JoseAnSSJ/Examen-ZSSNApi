package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.*
import com.examen.zssnapi.BD.Tablas.tblInventario
import com.examen.zssnapi.Repository.InventarioRepository
import org.springframework.stereotype.Service

@Service
class InventarioService(val bd: InventarioRepository){
    //se hace la conexion con los servicios y se modifican las respuestas para que la app pueda recibir solo los datos que necesita
    //se puede hacer un bd.save para agregar mas facil los datos
    fun listaInventario(): List<tblInventario> = bd.listaInventario()
    fun agregarInventario(inventario: tblInventario): okResponse{
        bd.save(inventario)
        return okResponse(mensaje = "Ok")
    }

    fun getInventarioById(id_sobreviviente: String): List<InventarioResponse> = bd.getInventarioById(id_sobreviviente)

    fun getPromedio(): ArrayList<promedioObjetos> = bd.getPromedio()

    fun getPromedioById(id_objeto: Int): promedioObjetos = bd.getPromedioById(id_objeto)

    fun getPuntosPerdidios(): okResponse {
        return okResponse(mensaje = "Puntos perdidos: ${bd.getPuntosPerdidios().sum()}")
    }

    //fun addInventarioIndividual(inventario: tblInventario): tblInventario = bd.save(tblInventario)
}