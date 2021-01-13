package me.black9p.testproject.config.auth.dto

import me.black9p.testproject.domain.user.User
import java.io.Serializable

class SessionUser(user: User) : Serializable {
    var name: String = ""
    var email: String = ""
    var picture: String = ""

    init {
        this.name = user.name
        this.email = user.email
        this.picture = user.picture
    }
}
