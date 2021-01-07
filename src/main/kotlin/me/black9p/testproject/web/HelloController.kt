package me.black9p.testproject.web

import me.black9p.testproject.web.dto.HelloResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author black9p
 */
@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    @GetMapping("/hello/dto")
    fun helloDto(@RequestParam name: String, @RequestParam amount: Int): HelloResponse {
        return HelloResponse(name, amount)
    }
}