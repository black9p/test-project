package me.black9p.testproject.service

import me.black9p.testproject.domain.posts.PostsRepository
import me.black9p.testproject.web.dto.PostsListResponseDto
import me.black9p.testproject.web.dto.PostsResponseDto
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
        val post = postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id= $id") }
        post.update(requestDto.title, requestDto.content)

        return id
    }

    fun getPost(id: Long): PostsResponseDto {
        val post = postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id= $id") }

        return PostsResponseDto(post.id!!, post.title, post.content, post.author)
    }

    @Transactional(readOnly = true)
    fun getPostsFromRecent(): List<PostsListResponseDto> {
        return postsRepository.findAllDesc().map { posts -> PostsListResponseDto(posts) }
    }
}
