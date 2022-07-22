package com.examen.zssnapi.BD

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

class Tablas {
    //Damos de alta todas las tablas
    @Table("TBLSOBREVIVIENTES")
    data class tblSobrevivientes(@Id val id_sobreviviente: String?, val nombre_sobreviviente: String?, val edad: String?, val genero: String?, val latitud: String?, val longitud: String?, val es_infectado: Boolean?)

    @Table("TBLINVENTARIO")
    data class tblInventario(@Id val id_inventario: String?, val id_sobreviviente: Int, val cantidad: Int, val id_objeto: Int)

    @Table("catObjetos")
    data class catObjetos(val id_objeto: Int, val descripcion: String, val puntos: Int)

    @Table("TBLREPORTESINFECTADOS")
    data class tblReportesInfectados(@Id val id_reporte: String?, val id_sobreviviente_infectado: Int, val id_sobreviviente_informante: Int)


}