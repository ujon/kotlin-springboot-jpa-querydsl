package dev.ujon.kotlinspringbootjpaquerydsl.jpa.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun existsByEmail(email: String?): Boolean
    fun deleteUserByEmail(email: String?)
}