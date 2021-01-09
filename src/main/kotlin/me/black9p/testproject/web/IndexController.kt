package me.black9p.testproject.web

import me.black9p.testproject.service.PostsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * @author black9p
 */
@Controller
class IndexController (val postsService: PostsService){

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("posts", postsService.getPostsFromRecent())
        return "index"
    }

    @GetMapping("/posts/save")
    fun postsSave(): String {
        return "posts-save"
    }

    @GetMapping("/posts/update/{id}")
    fun postsUpdate(@PathVariable id:Long, model: Model): String {
        model.addAttribute("post", postsService.getPost(id))
        return "posts-update"
    }
}