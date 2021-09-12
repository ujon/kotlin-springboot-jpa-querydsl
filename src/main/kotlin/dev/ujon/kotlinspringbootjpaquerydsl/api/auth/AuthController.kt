package dev.ujon.kotlinspringbootjpaquerydsl.api.auth

import dev.ujon.kotlinspringbootjpaquerydsl.api.common.data.BaseRes
import dev.ujon.kotlinspringbootjpaquerydsl.jpa.user.User
import dev.ujon.kotlinspringbootjpaquerydsl.jpa.user.UserRepository
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Transactional
@RestController
@RequestMapping("/auth")
class AuthController(
    private val userRepository: UserRepository
) {
    @PostMapping(
        "/signup",
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun signup(@Valid @RequestBody request: User): ResponseEntity<BaseRes> {
        val result = userRepository.save(request);
        val body = BaseRes(message = "success", payload = result)

        return ResponseEntity.ok().body(body)
    }
}