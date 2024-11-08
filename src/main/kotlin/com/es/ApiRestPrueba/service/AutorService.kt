package com.es.ApiRestPrueba.service

import com.es.ApiRestPrueba.model.Autor
import com.es.ApiRestPrueba.repository.AutorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AutorService {

    @Autowired
    private lateinit var autorRepository: AutorRepository

    /*
    RESPONSABILIDADES
    Controlar la Logica de Negocio
    Comunicarse con el Repository
     */

    fun insertAutor(autor: Autor): Autor {
        return autorRepository.save(autor)
    }

    fun getById(id: String): Autor? {

        // 1º Implementar la logica de negocio
        var idL: Long = 0
        try {
            idL = id.toLong()
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

        // 2º comunicación con repository
        val autor: Autor? = autorRepository.findByIdOrNull(idL)

        return autor
    }

}