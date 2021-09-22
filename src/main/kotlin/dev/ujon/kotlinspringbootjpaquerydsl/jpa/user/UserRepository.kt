package dev.ujon.kotlinspringbootjpaquerydsl.jpa.user

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface UserRepository : CrudRepository<User, Long> {
    fun existsByEmail(email: String?): Boolean
    fun deleteUserByEmail(email: String?)
}

@Repository
class UserRepositorySupport(
    val query: JPAQueryFactory
) : QuerydslRepositorySupport(User::class.java) {
    fun findByEmailSelectId(email: String?): User? {
        val user: QUser = QUser.user
        return query
            .select(Projections.fields(user, user.id))
            .from(user)
            .where(user.email.eq(email))
            .fetchOne()
    }
}