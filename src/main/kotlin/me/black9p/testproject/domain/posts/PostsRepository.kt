package me.black9p.testproject.domain.posts

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * @author black9p
 */
interface PostsRepository : JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    fun findAllDesc() : List<Posts>
}