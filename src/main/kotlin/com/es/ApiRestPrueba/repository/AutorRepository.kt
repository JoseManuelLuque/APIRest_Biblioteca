package com.es.ApiRestPrueba.repository

import com.es.ApiRestPrueba.model.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {

}