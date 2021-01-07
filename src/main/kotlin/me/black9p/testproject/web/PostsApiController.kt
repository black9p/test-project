package me.black9p.testproject.web

import me.black9p.testproject.service.PostsService
import me.black9p.testproject.web.dto.PostsSaveRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author black9p
 */
@RestController
class PostsApiController (val postsService: PostsService){

    @PostMapping("/api/v1/posts")
    fun createPost(@RequestBody requestDto: PostsSaveRequestDto): Long? {
        return postsService.createPost(requestDto)
    }
}