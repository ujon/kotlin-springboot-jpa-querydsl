package dev.ujon.kotlinspringbootjpaquerydsl.api.common.exception.client

import dev.ujon.kotlinspringbootjpaquerydsl.common.config.StatusCode
import org.springframework.http.HttpStatus

// 4**
abstract class ClientException(
    message: String? = null,
    open val statusCode: Int = StatusCode.USER_NOT_FOUND,
    open val httpStatus: HttpStatus = HttpStatus.BAD_REQUEST,
) : Exception(message)


