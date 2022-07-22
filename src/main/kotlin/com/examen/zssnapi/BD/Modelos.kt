package com.examen.zssnapi.BD

data class promedioObjetos(
        val descripcion: String,
        val promedio: Double
)

data class SobrevivientesResponse(
        val id_sobreviviente: Int? = null,
        val nombre_sobreviviente: String? = null,
        val edad: String? = null,
        val genero: String? = null,
        val latitud: String? = null,
        val longitud: String? = null,
        val es_infectado: Boolean? = null
)

data class okResponse(
        val mensaje: String
)

data class ReporteInfectadoResonse(
        val id_reporte: Int? = null,
        val id_sobreviviente_infectado: Int? = null,
        val id_sobreviviente_informante: Int? = null
)

data class PorcentajeResonse(
        val porcentaje: String? = null
)


data class InventarioResponse(
        val descripcion: String? = null,
        val cantidad: Int? = null
)



data class InventarioLista(
        val inventario: ArrayList<Tablas.tblInventario> = arrayListOf()
)