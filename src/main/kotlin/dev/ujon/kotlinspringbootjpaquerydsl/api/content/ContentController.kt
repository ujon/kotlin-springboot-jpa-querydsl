package dev.ujon.kotlinspringbootjpaquerydsl.api.content

import dev.ujon.kotlinspringbootjpaquerydsl.api.common.data.BaseRes
import dev.ujon.kotlinspringbootjpaquerydsl.api.common.exception.client.UserNotFound
import dev.ujon.kotlinspringbootjpaquerydsl.api.content.data.AddContentReq
import dev.ujon.kotlinspringbootjpaquerydsl.jpa.content.Content
import dev.ujon.kotlinspringbootjpaquerydsl.jpa.content.ContentRepository
import dev.ujon.kotlinspringbootjpaquerydsl.jpa.user.User
import dev.ujon.kotlinspringbootjpaquerydsl.jpa.user.UserRepositorySupport
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
@RequestMapping("/content")
class ContentController(
    private val userRepositorySupport: UserRepositorySupport,
    private val contentRepository: ContentRepository
) {
    @PostMapping(
        "",
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun addContent(@Valid @RequestBody request: AddContentReq): ResponseEntity<BaseRes> {
        val user: User = userRepositorySupport.findByEmailSelectId(request.email) ?: throw UserNotFound()

        val data = Content(user = user, title = request.title, content = request.content)
        val result = contentRepository.save(data)
        val body = BaseRes(message = "success", payload = result)

        return ResponseEntity.ok().body(body)
    }
}