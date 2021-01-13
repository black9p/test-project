package me.black9p.testproject.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * @author black9p
 */
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String) : Optional<User>
}