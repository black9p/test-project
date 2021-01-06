package me.black9p.testproject.web

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

/**
 * @author black9p
 */
@WebMvcTest(controllers = [HelloController::class])
class HelloControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun `get hello`() {
        val expected = "hello"

        mvc.perform(MockMvcRequestBuilders.get("/hello"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string(expected))
    }
}