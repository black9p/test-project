package me.black9p.testproject.domain.posts

import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author black9p
 */
interface PostsRepository : JpaRepository<Posts, Long> {
}