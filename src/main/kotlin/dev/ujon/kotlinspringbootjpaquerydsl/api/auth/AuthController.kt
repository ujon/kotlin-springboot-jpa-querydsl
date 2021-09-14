package dev.ujon.kotlinspringbootjpaquerydsl.api.auth

import dev.ujon.kotlinspringbootjpaquerydsl.api.auth.data.SignUpReq
import dev.ujon.kotlinspringbootjpaquerydsl.api.common.data.BaseRes
import dev.ujon.kotlinspringbootjpaquerydsl.common.config.StatusCode
import dev.ujon.kotlinspringbootjpaquerydsl.jpa.user.User
import dev.ujon.kotlinspringbootjpaquerydsl.jpa.user.UserRepository
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Transactional
@RestController
@RequestMapping("/auth")
@Validated
class AuthController(
    private val userRepository: UserRepository
) {
    @PostMapping(
        "/signup",
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun signup(@Valid @RequestBody request: SignUpReq): ResponseEntity<BaseRes> {
        val data = User(email = request.email, name = request.name, role = request.role)
        val result = userRepository.save(data);
        val body = BaseRes(message = "success", payload = result)

        return ResponseEntity.ok().body(body)
    }

    @DeleteMapping(
        "{email}",
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun delete(
        @PathVariable
        @NotNull
        @Email
        email: String
    ): ResponseEntity<BaseRes> {
        val body: BaseRes
        val isExist: Boolean = userRepository.existsByEmail(email)

        if (!isExist) {
            body = BaseRes(status = StatusCode.EMAIL_IS_NOT_EXIST, message = "$email is not exist")
            return ResponseEntity.badRequest().body(body)
        }

        userRepository.deleteUserByEmail(email)
        body = BaseRes(message = "$email is deleted")
        return ResponseEntity.ok().body(body)
    }
}