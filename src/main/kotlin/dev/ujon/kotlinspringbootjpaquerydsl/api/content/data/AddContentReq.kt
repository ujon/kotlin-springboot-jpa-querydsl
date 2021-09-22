package dev.ujon.kotlinspringbootjpaquerydsl.api.content.data

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AddContentReq(
    @field: NotNull
    @field: Email
    var email: String? = null,
    @field: NotNull
    @field: NotEmpty
    var title: String? = null,
    @field: NotNull
    @field: NotEmpty
    var content: String? = null,
)