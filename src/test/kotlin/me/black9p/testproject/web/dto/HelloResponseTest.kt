package me.black9p.testproject.web.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * @author black9p
 */
internal class HelloResponseTest {

    @Test
    fun `dto test`() {
        // given
        val name = "test"
        val amount = 1000

        // when
        val dto = HelloResponse(name, amount)

        // then
        assertThat(dto.name).isEqualTo(name)
        assertThat(dto.amount).isEqualTo(amount)
    }
}