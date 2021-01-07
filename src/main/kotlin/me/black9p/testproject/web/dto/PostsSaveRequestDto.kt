package me.black9p.testproject.web.dto

import me.black9p.testproject.domain.posts.Posts

data class PostsSaveRequestDto(
    val title: String,
    val content: String,
    val author: String
) {

    fun toEntity(): Posts {
        return Posts(title, content, author)
    }
}