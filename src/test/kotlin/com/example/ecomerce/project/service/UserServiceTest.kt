package com.example.ecomerce.project.service

import com.example.ecomerce.project.model.User
import com.example.ecomerce.project.repository.UserRepository
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

class UserServiceTest {
    // mocking the repository layer response
    val user1 = User(999, "Rahul", 1234567890, "abcd@abcd")
    val user2 = User(888, "Rohit", 1234567891, "abcd@abca")

    private val userRepository = mockk<UserRepository>() {

        every {
            findAll()
        } returns Flux.just(user1, user2)

        /* every {
            deleteById("999")
        } returns Mono.just(user)
    }*/
    }
    private val userService = UserService(userRepository)

    @Test
    fun `should return books when find all method is called`() {

        val firstUser = userService.findAll().blockFirst()
        val secondUser = userService.findAll().blockLast()

        if (firstUser != null) {
            firstUser shouldBe user1
        }
        if (secondUser != null) {
            secondUser shouldBe user2
        }
    }

    @Test
    fun `should expect on complete call post all the books are retrieved`() {

        //StepVerifier takes care of subscribing

        StepVerifier.create(userService.findAll()).expectSubscription().expectNext(user1).expectNext(user2)
            .verifyComplete()
        StepVerifier.create(userService.findAll()).expectNextCount(2).verifyComplete()
    }

   /* @Test
    fun `should delete the user on the basis of the id`() {

        val result = userService.deleteById(999)

        result shouldBe user1
    }*/
}