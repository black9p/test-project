package me.black9p.testproject.domain.posts

import me.black9p.testproject.domain.BaseTimeEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * @author black9p
 */
@Entity
class Posts(var title: String, var content: String, var author: String) : BaseTimeEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}