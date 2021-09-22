package dev.ujon.kotlinspringbootjpaquerydsl.jpa.content

import org.springframework.data.repository.CrudRepository

interface ContentRepository : CrudRepository<Content, Long> {

}