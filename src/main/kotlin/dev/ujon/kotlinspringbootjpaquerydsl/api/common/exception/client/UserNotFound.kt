package dev.ujon.kotlinspringbootjpaquerydsl.api.common.exception.client

import dev.ujon.kotlinspringbootjpaquerydsl.common.config.StatusCode
import org.springframework.http.HttpStatus

class UserNotFound(
    message: String? = "Account Does not exist.",
    override val statusCode: Int = StatusCode.USER_NOT_FOUND,
    override val httpStatus: HttpStatus = HttpStatus.BAD_REQUEST,
) : ClientException(message, statusCode, httpStatus)