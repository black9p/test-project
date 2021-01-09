package me.black9p.testproject.web

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

/**
 * @author black9p
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `index page`() {
        val body = restTemplate.getForObject("/", String::class.java)

        assertThat(body).contains("test")
    }
}