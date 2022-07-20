package com.examen.zssnapi

import com.examen.zssnapi.BD.*
import com.examen.zssnapi.BD.Tablas.tblReportesInfectados
import com.examen.zssnapi.BD.Tablas.tblInventario
import com.examen.zssnapi.BD.Tablas.catObjetos
import com.examen.zssnapi.BD.Tablas.tblSobrevivientes
import com.examen.zssnapi.Services.CatObjetosService
import com.examen.zssnapi.Services.InventarioService
import com.examen.zssnapi.Services.ReporteInfectadoService
import com.examen.zssnapi.Services.SobreviventesService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.rmi.ServerException
import javax.websocket.server.PathParam


@SpringBootApplication
class ZssnApiApplication

fun main(args: Array<String>) {
    runApplication<ZssnApiApplication>(*args)
}


@RestController
class SobrevivientesResource(val serviceSobreviventes: SobreviventesService) {
    @GetMapping("/sobrevivientes/getSobrevivientes")
    fun getSobrevivientes(): List<tblSobrevivientes> = serviceSobreviventes.listaSobrevivientes()

    @PostMapping("/sobrevivientes/addSobreviviente")
    fun addSobrevivientes(@RequestBody sobrevivienteRequesst: tblSobrevivientes): SobrevivientesResponse {
        return serviceSobreviventes.agregarSobreviviente(sobrevivienteRequesst)
    }
    @RequestMapping("/sobrevivientes/getUltimaLocacion")
    fun getUltimaLocacion(@RequestParam id_sobreviviente: String): SobrevivientesResponse  {
        return serviceSobreviventes.getUltimaLocacion(id_sobreviviente)
    }

    @RequestMapping("/sobrevivientes/updateUltimaLocacion")
    fun updateUltimaLocacion(@RequestParam id_sobreviviente: String,@RequestParam latitud: String,@RequestParam longitud: String): okResponse  {
        return serviceSobreviventes.updateUltimaLocacion(id_sobreviviente,latitud,longitud)
    }

    @GetMapping("/sobrevivientes/getSobrevivientesNoInfectados")
    fun getSobrevivientesNoInfectados(): List<tblSobrevivientes> = serviceSobreviventes.listaSobrevivientesNoInfectados()

    @RequestMapping("/sobrevivientes/updateInfectado")
    fun updateInfectado(@RequestParam id_sobreviviente: String): okResponse  {
        return serviceSobreviventes.updateInfectado(id_sobreviviente)
    }

    @GetMapping("/sobrevivientes/getPorcentajeInfectados")
    fun getPorcentajeInfectados(): PorcentajeResonse = serviceSobreviventes.getPorcentajeInfectados()

    @GetMapping("/sobrevivientes/getPorcentajeBien")
    fun getPorcentajeBien(): PorcentajeResonse = serviceSobreviventes.getPorcentajeBien()

}
@RestController
class CatObjetosResource(val catObjetos: CatObjetosService) {
    @GetMapping("/catalogo/getObjetosCatalogo")
    fun getCatalogos(): List<catObjetos> = catObjetos.listaCatObjetos()
}

@RestController
class InventarioResource(val serviceInventarioService: InventarioService) {
    @PostMapping("/inventario/addInventario")
    fun addInventario(@RequestBody inventarioRequesst: tblInventario): okResponse {
        return serviceInventarioService.agregarInventario(inventarioRequesst)
    }

    @RequestMapping("/inventario/getPromedioById")
    fun getPromedioById(@RequestParam id_objeto: Int): promedioObjetos {
        return serviceInventarioService.getPromedioById(id_objeto)
    }

    @GetMapping("/inventario/getPromedio")
    fun getPromedio(): ArrayList<promedioObjetos> {
        var list: ArrayList<promedioObjetos> = arrayListOf()

        for(it in 1..4){
            var item: promedioObjetos = getPromedioById(it)
            list.add(item)
        }


        return list
    }

    @GetMapping("/inventario/getPuntosPerdidios")
    fun getPuntosPerdidios(): okResponse {
        return serviceInventarioService.getPuntosPerdidios()
    }

}

@RestController
class ReporteInfectadoResource(val reporteInfectadoService: ReporteInfectadoService) {
    @PostMapping("/reporteInfectado/addInfectado")
    fun agregarReporteInfectado(@RequestBody reporteInfectado: tblReportesInfectados): ReporteInfectadoResonse {
        return reporteInfectadoService.agregarReporteInfectado(reporteInfectado)
    }

}