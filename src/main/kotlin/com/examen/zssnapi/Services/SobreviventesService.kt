package com.examen.zssnapi.Services

import com.examen.zssnapi.BD.Sobreviviente
import com.examen.zssnapi.Repository.SobrevivientesRepository
import org.springframework.stereotype.Service

@Service
class SobreviventesService(val bd: SobrevivientesRepository){
    fun listaSobrevivientes(): List<Sobreviviente> = bd.listaSobrevivientes()
    fun agregarSobreviviente(sobreviviente: Sobreviviente){
        bd.save(sobreviviente)
    }
}