package com.es.ApiRestPrueba.controller

import com.es.ApiRestPrueba.model.Libro
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LibroController {

    // Vamos a hacer un CRUD de Libros

    // C (Crear) -> POST
    // R (Leer) -> GET
    // U (Aztualizar) -> PUT
    // D (Eliminar) -> DELETE

    private val libros: MutableList<Libro> = mutableListOf(
        Libro(1, "Crepusculo", "Ficcion", 2024, 15.20, null),
        Libro(2, "La leyenda del hechicero", "Aventuras", 2024, 20.0, null),
        Libro(3, "Ciudad de Cristal", "Policiaco", 2024, 24.5, null)
    )

    @PostMapping("/libros")
    fun insert(
        @RequestBody libroNuevo: Libro
    ): Libro? {
        val libroEnLista = libros.find {l -> l.id == libroNuevo.id}

        if (libroEnLista != null) {
            return null
        } else {
            libros.add(libroNuevo)
            return libros.find {l -> l.id == libroNuevo.id}
        }
    }

    @GetMapping("/libros/{id}")
    fun getByID(
        @PathVariable("id") id: String //@PathVariable: Captura variables en la URL. Esto se utiliza para obtener identificadores específicos en la ruta.
    ): Libro?
    {
        println(id)
        val idL: Long = id.toLong()

        return libros.find { libro -> libro.id == idL }
    }

    @PutMapping("/libros")
    fun update(
        @RequestBody libroActualizado: Libro
    ): Libro? {
        var libroEnLista = libros.find { it.id == libroActualizado.id }

        return if (libroEnLista != null) {
            libroEnLista.genero  = libroActualizado.genero
            libroEnLista.titulo = libroActualizado.titulo
            libroEnLista.autor = libroActualizado.autor
            libroEnLista
        } else {
            null
        }
    }

    @DeleteMapping("/libros/{id}")
    fun deleteByID(
        @PathVariable("id") id: String
    ): String? {
        try {
            val idL: Long = id.toLong()

            var libro = libros.find { it.id == idL }

            return if (libro != null) {
                libros.remove(libro)
                "El libro se ha eliminado correctante"
            } else {
                "El libro no se ha eliminado"
            }
        } catch (e: Exception) {
            return "Libro a borrar no encontrado"
        }
    }
}