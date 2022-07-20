package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.Inventario
import com.examen.zssnapi.Repository.InventarioRepository
import org.springframework.stereotype.Service

@Service
class InventarioService(val bd: InventarioRepository){
    fun listaInventario(): List<Inventario> = bd.listaInventario()
    fun agregarInventario(inventario: Inventario){
        bd.save(inventario)
    }
}