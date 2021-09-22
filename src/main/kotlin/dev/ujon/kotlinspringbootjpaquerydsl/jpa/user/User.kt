package dev.ujon.kotlinspringbootjpaquerydsl.jpa.user

import dev.ujon.kotlinspringbootjpaquerydsl.jpa.types.RoleType
import org.hibernate.annotations.ColumnDefault
import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    @Column(nullable = false)
    var email: String? = null,
    @Column(nullable = false)
    var name: String? = null,
    @ColumnDefault("'user'")
    @Enumerated(EnumType.STRING)
    val role: RoleType? = null
)
