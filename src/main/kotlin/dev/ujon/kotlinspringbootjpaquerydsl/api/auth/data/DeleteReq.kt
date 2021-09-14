package dev.ujon.kotlinspringbootjpaquerydsl.api.auth.data

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

data class DeleteReq(
    @field: NotNull
    @field: Email
    var email: String? = null
)