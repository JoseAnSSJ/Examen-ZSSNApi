package com.examen.zssnapi.Repository

import com.examen.zssnapi.BD.Tablas.tblInventario
import com.examen.zssnapi.BD.promedioObjetos
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface InventarioRepository : CrudRepository<tblInventario, String> {
    @Query("SELECT * FROM tblInventario")
    fun listaInventario(): List<tblInventario>

    @Query("SELECT * FROM tblInventario")
    fun getPromedio(): ArrayList<promedioObjetos>

    @Query("select sum(x1.cantidad) / (select count(*) from TBLSOBREVIVIENTES) as promedio, x2.descripcion from tblInventario x1 inner join catObjetos x2 on x1.id_objeto=x2.id_objeto WHERE x1.id_objeto =:id_objeto")
    fun getPromedioById(id_objeto: Int): promedioObjetos

    @Query("select sum(x1.cantidad) * x2.puntos as puntosPeridos from tblInventario x1 inner join catObjetos x2 on x1.id_objeto=x2.id_objeto inner join TBLSOBREVIVIENTES x3 on x1.id_sobreviviente=x3.id_sobreviviente where x3.es_infectado=true GROUP BY X2.PUNTOS")
    fun getPuntosPerdidios(): List<Int>
}