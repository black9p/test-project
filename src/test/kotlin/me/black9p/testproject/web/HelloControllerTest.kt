package me.black9p.testproject.web

import org.hamcrest.Matchers
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

    @Test
    fun `get hello dto`() {
        val name = "hello"
        val amount = 1000

        mvc.perform(MockMvcRequestBuilders.get("/hello/dto").param("name", name).param("amount", amount.toString()))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.`is`(name)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.`is`(amount)))
    }
}