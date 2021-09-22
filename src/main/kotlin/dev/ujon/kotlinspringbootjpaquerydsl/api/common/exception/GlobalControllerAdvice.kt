package dev.ujon.kotlinspringbootjpaquerydsl.api.common.exception

import dev.ujon.kotlinspringbootjpaquerydsl.api.common.data.BaseRes
import dev.ujon.kotlinspringbootjpaquerydsl.api.common.exception.client.ClientException
import dev.ujon.kotlinspringbootjpaquerydsl.common.config.StatusCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.HttpMediaTypeException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(value = [Exception::class])
    fun exception(e: Exception, request: HttpServletRequest): ResponseEntity<BaseRes> {
        val body = BaseRes(status = StatusCode.UNKNOWN, message = "${e.message}")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body)
    }

    @ExceptionHandler(value = [MethodArgumentNotValidException::class, BindException::class])
    fun bindException(
        e: BindException,
        request: HttpServletRequest
    ): ResponseEntity<BaseRes> {
        val target = e.fieldError?.field
        val message = e.fieldError?.defaultMessage
        val body = BaseRes(status = StatusCode.BAD_REQUEST, message = "$target $message")

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body)
    }

    // 400
    @ExceptionHandler(value = [ClientException::class])
    fun customException(
        e: ClientException,
        request: HttpServletRequest
    ): ResponseEntity<BaseRes> {
        val body = BaseRes(status = e.statusCode, message = e.message)
        return ResponseEntity.status(e.httpStatus).body(body)
    }

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationException(
        e: ConstraintViolationException,
        request: HttpServletRequest
    ): ResponseEntity<BaseRes> {

        val body = BaseRes(status = StatusCode.BAD_REQUEST, message = "${e.message}")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body)
    }

    @ExceptionHandler(value = [HttpMediaTypeNotSupportedException::class])
    fun httpMediaTypeNotSupportedException(
        e: HttpMediaTypeException,
        request: HttpServletRequest
    ): ResponseEntity<BaseRes> {
        val body = BaseRes(status = StatusCode.UNSUPPORTED_MEDIA_TYPE, message = "${e.message}")

        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(body);
    }
}