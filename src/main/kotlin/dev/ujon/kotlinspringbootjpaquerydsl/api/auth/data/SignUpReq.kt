package dev.ujon.kotlinspringbootjpaquerydsl.api.auth.data

import dev.ujon.kotlinspringbootjpaquerydsl.jpa.types.RoleType
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

data class SignUpReq(
    @field: NotNull
    @field: Email
    var email: String? = null,
    @field: NotNull
    var name: String? = null,
    var role: RoleType? = RoleType.user
)