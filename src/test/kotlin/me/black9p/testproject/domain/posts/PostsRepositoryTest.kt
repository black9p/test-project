package me.black9p.testproject.domain.posts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

/**
 * @author black9p
 */
@DataJpaTest
class PostsRepositoryTest {

    @Autowired
    lateinit var postsRepository: PostsRepository

    @AfterEach
    fun cleanup() {
        postsRepository.deleteAll()
    }

    @Test
    fun `get post`() {
        val title = "테스트 게시글"
        val content = "테스트 본문"
        val author = "black9p"

        postsRepository.save(Posts(title, content, author))

        val actual = postsRepository.findAll()

        val posts = actual[0]

        assertThat(posts.title).isEqualTo(title)
        assertThat(posts.content).isEqualTo(content)
    }
}