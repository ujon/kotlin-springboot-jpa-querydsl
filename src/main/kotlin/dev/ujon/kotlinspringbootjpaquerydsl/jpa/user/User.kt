package dev.ujon.kotlinspringbootjpaquerydsl.jpa.user

import dev.ujon.kotlinspringbootjpaquerydsl.jpa.types.RoleType
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var user_id: Long? = null,
    @field: NotNull
    var email: String? = null,
    @field: NotNull
    var name: String? = null,
    @Enumerated(EnumType.STRING)
    val role: RoleType? = RoleType.user
)
