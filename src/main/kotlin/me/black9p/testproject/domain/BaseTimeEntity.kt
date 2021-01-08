package me.black9p.testproject.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

/**
 * @author black9p
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseTimeEntity {
    @CreatedDate
    lateinit var createdDate: LocalDateTime

    @LastModifiedDate
    lateinit var modifiedDate: LocalDateTime
}
