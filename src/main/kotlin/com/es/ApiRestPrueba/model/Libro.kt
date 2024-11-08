package com.es.ApiRestPrueba.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.LocalDate

@Suppress("JpaObjectClassSignatureInspection")
@Entity
@Table(name="libros")
data class Libro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var titulo: String,

    var genero: String,

    @Column(name = "anio_publicacion")
    var anioPublicacion: Int,

    var precio: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    @JsonBackReference
    var autor: Autor?
)