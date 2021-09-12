package dev.ujon.kotlinspringbootjpaquerydsl.jpa

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var create_date: Instant? = null

    @LastModifiedDate
    @Column(nullable = false, updatable = true)
    var modify_date: Instant? = null
}