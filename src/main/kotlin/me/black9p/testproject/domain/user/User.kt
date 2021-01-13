package me.black9p.testproject.domain.user

import me.black9p.testproject.domain.BaseTimeEntity
import javax.persistence.EnumType
import javax.persistence.Enumerated

/**
 * @author black9p
 */
class User(
    var name: String,
    var email: String,
    var picture: String,
    @Enumerated(EnumType.STRING) var role: Role
) : BaseTimeEntity() {

    fun update(name: String, picture: String): User {
        this.name = name
        this.picture = picture

        return this
    }

    fun getRoleKey(): String {
        return this.role.key
    }
}