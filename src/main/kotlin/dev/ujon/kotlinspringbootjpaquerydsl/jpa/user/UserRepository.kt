package dev.ujon.kotlinspringbootjpaquerydsl.jpa.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}