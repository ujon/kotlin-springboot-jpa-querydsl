package dev.ujon.kotlinspringbootjpaquerydsl.api.common.data

import dev.ujon.kotlinspringbootjpaquerydsl.common.config.StatusCode

data class BaseRes(
    var status: Int = StatusCode.SUCCESS,
    var message: String? = null,
    var payload: Any? = null
)