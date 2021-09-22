package dev.ujon.kotlinspringbootjpaquerydsl.jpa.content

import dev.ujon.kotlinspringbootjpaquerydsl.jpa.user.User
import javax.persistence.*

@Entity
data class Content(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User,
    @Column(nullable = false)
    var title: String? = null,
    @Column(nullable = false)
    var content: String? = null
)