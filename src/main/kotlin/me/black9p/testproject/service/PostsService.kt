package me.black9p.testproject.service

import me.black9p.testproject.domain.posts.PostsRepository
import me.black9p.testproject.web.dto.PostsSaveRequestDto
import me.black9p.testproject.web.dto.PostsUpdateRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostsService (val postsRepository: PostsRepository){

    @Transactional
    fun createPost(requestDto: PostsSaveRequestDto) : Long? {
        return postsRepository.save(requestDto.toEntity()).id
    }

    @Transactional
    fun updatePost(id: Long, requestDto: PostsUpdateRequestDto): Long {
        val posts = postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id= $id") }
        posts.update(requestDto.title, requestDto.content)

        return id
    }
}
