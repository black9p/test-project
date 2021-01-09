package me.black9p.testproject.web.dto

import me.black9p.testproject.domain.posts.Posts
import java.time.LocalDateTime

/**
 * @author black9p
 */
class PostsListResponseDto(post: Posts) {
    var id: Long
    var title: String
    var author: String
    var modifiedDate: LocalDateTime

    init {
        this.id = post.id!!
        this.title = post.title
        this.author = post.author
        this.modifiedDate = post.modifiedDate
    }
}