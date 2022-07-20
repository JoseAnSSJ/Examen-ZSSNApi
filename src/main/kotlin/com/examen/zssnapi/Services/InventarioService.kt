package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.Tablas.tblInventario
import com.examen.zssnapi.BD.promedioObjetos
import com.examen.zssnapi.Repository.InventarioRepository
import org.springframework.stereotype.Service

@Service
class InventarioService(val bd: InventarioRepository){
    fun listaInventario(): List<tblInventario> = bd.listaInventario()
    fun agregarInventario(inventario: tblInventario): tblInventario{
        return bd.save(inventario)
    }

    fun getPromedio(): ArrayList<promedioObjetos> = bd.getPromedio()

    fun getPromedioById(id_objeto: Int): promedioObjetos = bd.getPromedioById(id_objeto)

    fun getPuntosPerdidios(): Int {
        return bd.getPuntosPerdidios().sum()
    }
}