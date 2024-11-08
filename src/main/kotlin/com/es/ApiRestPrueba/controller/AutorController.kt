package com.es.ApiRestPrueba.controller

import com.es.ApiRestPrueba.model.Autor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.text.isNullOrEmpty

@RestController
@RequestMapping("/autores")
class AutorController {

    /*
    RESPONSABILIDADES
    Manejar las solicitudes HTTP
    Validacion minima de datos
    Comunicarse con el service
     */

    @Autowired
    private lateinit var autorService: com.es.ApiRestPrueba.service.AutorService

    @PostMapping("/autor")
    fun insert(
        @RequestBody autorNuevo: Autor
    ): String? {

        // 1º Comprobación básica de los parámetros de entrada
        if (autorNuevo==null) {
            return null
        }

        return null
    }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: String?
    ): com.es.ApiRestPrueba.model.Autor? {

        // 1º Comprobación básica de los parámetros de entrada
        if (id.isNullOrEmpty()) {
            return null
        }

        // 2º Comunico el controller con el service
        return autorService.getById(id)

    }


}