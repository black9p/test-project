package me.black9p.testproject.config.auth.dto

import me.black9p.testproject.domain.user.Role
import me.black9p.testproject.domain.user.User

class OAuthAttributes(
    val attributes: Map<String, Any>,
    val nameAttributeKey: String?,
    val name: String,
    val email: String,
    val picture: String
) {

    companion object {
        fun of(registrationId: String?, userNameAttributeName: String?, attributes: Map<String, Any>): OAuthAttributes {
            return ofGoogle(userNameAttributeName, attributes)
        }

        private fun ofGoogle(userNameAttributeName: String?, attributes: Map<String, Any>): OAuthAttributes {
            return OAuthAttributes(
                attributes, userNameAttributeName, attributes["name"] as String,
                attributes["name"] as String,
                attributes["picture"] as String
            )
        }
    }

    fun toEntity() : User {
        return User(name, email, picture, Role.GUEST)
    }
}
