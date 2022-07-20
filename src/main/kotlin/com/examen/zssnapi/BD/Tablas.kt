package com.examen.zssnapi.BD

import org.springframework.data.relational.core.mapping.Table

class Tablas {

    @Table("tblSobrevivientes")
    data class tblSobrevivientes(val id_sobreviviente: Int, val nombre_sobreviviente: String, val edad: String, val genero: String, val latitud: String, val longitud: String, val es_infectado: Boolean)

    @Table("tblInventario")
    data class tblInventario(val id_inventario: Int, val id_sobreviviente: Int, val cantidad: Int)

    @Table("catObjetos")
    data class catObjetos(val id_objeto: Int, val descripcion: String, val puntos: Int)

    @Table("tblReportesInfectados")
    data class tblReportesInfectados(val id_reporte: Int, val id_sobreviviente_infectado: Int, val id_sobreviviente_informante: Int)


}