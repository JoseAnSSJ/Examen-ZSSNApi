package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.Tablas.tblInventario
import com.examen.zssnapi.BD.okResponse
import com.examen.zssnapi.BD.promedioObjetos
import com.examen.zssnapi.Repository.InventarioRepository
import org.springframework.stereotype.Service

@Service
class InventarioService(val bd: InventarioRepository){
    fun listaInventario(): List<tblInventario> = bd.listaInventario()
    fun agregarInventario(inventario: tblInventario): okResponse{
        return okResponse(mensaje = "Ok")
    }

    fun getPromedio(): ArrayList<promedioObjetos> = bd.getPromedio()

    fun getPromedioById(id_objeto: Int): promedioObjetos = bd.getPromedioById(id_objeto)

    fun getPuntosPerdidios(): okResponse {
        return okResponse(mensaje = "Puntos perdidos: ${bd.getPuntosPerdidios().sum()}")
    }
}