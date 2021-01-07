package me.black9p.testproject.service

import me.black9p.testproject.domain.posts.PostsRepository
import me.black9p.testproject.web.dto.PostsSaveRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostsService (val postsRepository: PostsRepository){

    @Transactional
    fun createPost(requestDto: PostsSaveRequestDto) : Long? {
        return postsRepository.save(requestDto.toEntity()).id
    }
}
