package dev.ujon.kotlinspringbootjpaquerydsl.jpa.user

import dev.ujon.kotlinspringbootjpaquerydsl.jpa.types.RoleType
import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var user_id: Long? = null,
    @Column(nullable = false)
    var email: String? = null,
    @Column(nullable = false)
    var name: String? = null,
    @Enumerated(EnumType.STRING)
    val role: RoleType? = RoleType.user
)
