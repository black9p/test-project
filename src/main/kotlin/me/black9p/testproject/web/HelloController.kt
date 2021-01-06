package me.black9p.testproject.web

import org.springframework.web.bind.annotation.GetMapping
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
}