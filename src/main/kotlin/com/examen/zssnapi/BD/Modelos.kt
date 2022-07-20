package com.examen.zssnapi.BD

data class Sobreviviente(
        val id_sobreviviente: Int,
        val nombre_sobreviviente: String? = null,
        val edad: String, val genero: String? = null,
        val latitud: String? = null,
        val longitud: String? = null,
        val es_infectado: Boolean? = null
)

data class Inventario(
        val id_inventario: Int,
        val id_sobreviviente: Int? = null,
        val cantidad: Int? = null
)

data class ReporteInfectado(
        val id_reporte: Int,
        val id_sobreviviente_infectado: Int? = null,
        val id_sobreviviente_informante: Int? = null
)


data class CatObjetos(
        val id_objeto: Int,
        val descripcion: String? = null,
        val puntos: Int? = null
)
