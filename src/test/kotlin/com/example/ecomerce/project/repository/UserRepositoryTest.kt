package com.example.ecomerce.project.repository

import com.example.ecomerce.project.model.User
import io.kotlintest.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.ActiveProfiles

@DataMongoTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    lateinit var userRepository : UserRepository

    @BeforeEach
    fun tearDown() {
        userRepository.deleteAll().subscribe()
    }

    @Test
    fun `should find user for given id`() {

        val user = User(999,"Rahul" ,1234567890 , "abcd@abcd")

        userRepository.save(user).block()

        val actualSaveApplication = userRepository.findById(999).block()

        actualSaveApplication shouldBe user
    }
}