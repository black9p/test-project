package me.black9p.testproject.web

import me.black9p.testproject.domain.posts.PostsRepository
import me.black9p.testproject.web.dto.PostsSaveRequestDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus

/**
 * @author black9p
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest {

    @LocalServerPort
    var port : Int = 0

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Autowired
    lateinit var postsRepository: PostsRepository

    @AfterEach
    fun tearDown() {
        postsRepository.deleteAll()
    }

    @Test
    fun `test creatPost`() {
        val title = "title"
        val content = "content"
        val author = "black9p"

        val requestDto = PostsSaveRequestDto(title, content, author)

        val url = "http://localhost:${port}/api/v1/posts"

        val response = restTemplate.postForEntity(url, requestDto, Long::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isGreaterThan(0L)

        val all = postsRepository.findAll()
        assertThat(all[0].title).isEqualTo(title)
        assertThat(all[0].content).isEqualTo(content)
    }
}