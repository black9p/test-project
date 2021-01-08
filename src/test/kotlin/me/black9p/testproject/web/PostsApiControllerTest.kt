package me.black9p.testproject.web

import me.black9p.testproject.domain.posts.Posts
import me.black9p.testproject.domain.posts.PostsRepository
import me.black9p.testproject.web.dto.PostsSaveRequestDto
import me.black9p.testproject.web.dto.PostsUpdateRequestDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
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

    @Test
    fun `test updatePost`() {
        val savedPosts = postsRepository.save(Posts("title", "content", "black9p"))

        val updateId = savedPosts.id
        val expectedTitle = "title2"
        val expectedContent = "content2"

        val requestDto = PostsUpdateRequestDto(expectedTitle, expectedContent)

        val url = "http://localhost:${port}/api/v1/posts/$updateId"

        val request = HttpEntity<PostsUpdateRequestDto>(requestDto)

        val response = restTemplate.exchange(url, HttpMethod.PUT, request, Long::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isGreaterThan(0)

        val all = postsRepository.findAll()
        assertThat(all[0].title).isEqualTo(expectedTitle)
        assertThat(all[0].content).isEqualTo(expectedContent)
    }
}