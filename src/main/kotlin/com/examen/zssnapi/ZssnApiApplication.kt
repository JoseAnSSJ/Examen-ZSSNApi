package com.examen.zssnapi

import com.examen.zssnapi.BD.CatObjetos
import com.examen.zssnapi.BD.Sobreviviente
import com.examen.zssnapi.Services.CatObjetosService
import com.examen.zssnapi.Services.SobreviventesService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ZssnApiApplication

fun main(args: Array<String>) {
    runApplication<ZssnApiApplication>(*args)
}


@RestController
class SobrevivientesResource(val serviceSobreviventes: SobreviventesService) {
    @GetMapping("/sobrevivientes/getSobrevivientes")
    fun getSobrevivientes(): List<Sobreviviente> = serviceSobreviventes.listaSobrevivientes()
}
@RestController
class CatObjetosResource(val catObjetos: CatObjetosService) {
    @GetMapping("/catalogo/getObjetosCatalogo")
    fun getCatalogos(): List<CatObjetos> = catObjetos.listaCatObjetos()
}