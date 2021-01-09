package me.black9p.testproject.web

import me.black9p.testproject.service.PostsService
import me.black9p.testproject.web.dto.PostsResponseDto
import me.black9p.testproject.web.dto.PostsSaveRequestDto
import me.black9p.testproject.web.dto.PostsUpdateRequestDto
import org.springframework.web.bind.annotation.*

/**
 * @author black9p
 */
@RestController
class PostsApiController (val postsService: PostsService){

    @PostMapping("/api/v1/posts")
    fun createPost(@RequestBody requestDto: PostsSaveRequestDto): Long? {
        return postsService.createPost(requestDto)
    }

    @PutMapping("/api/v1/posts/{id}")
    fun update(@PathVariable id: Long, @RequestBody requestDto: PostsUpdateRequestDto): Long {
        return postsService.updatePost(id, requestDto)
    }

    @GetMapping("/api/v1/posts/{id}")
    fun getPost(@PathVariable id: Long) : PostsResponseDto {
        return postsService.getPost(id)
    }

    @DeleteMapping("/api/v1/posts/{id}")
    fun deletePost(@PathVariable id: Long): Long {
        postsService.deletePost(id)
        return id
    }
}