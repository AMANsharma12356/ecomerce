package com.example.ecomerce.project.controller

import com.example.ecomerce.project.model.User
import com.example.ecomerce.project.service.UserService
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.returnResult
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@WebFluxTest(UserController::class)
@AutoConfigureWebTestClient
class UserControllerTest {
    @Autowired
    lateinit var client : WebTestClient

    @Autowired
    lateinit var userService : UserService

    @Test
    fun `should return list of users`(){
        val user1 = User(999,"Rahul" ,1234567890 , "abcd@abcd")
        val user2 = User(888,"Ramesh" , 1234567891 , "abcd@abca")

        val expectedResult = listOf(
            mapOf("id" to 999,
                "name" to "Rahul",
                "contactno" to 1234567890,
                "password" to "abcd@abcd" ),
            mapOf("id" to 888,
                "name" to "Ramesh",
                "contactno" to 1234567891,
                "password" to "abcd@abca"),)

        every{
            userService.findAll() } returns Flux.just(user1,user2)

        val response = client.get()
            .uri("/users/lists")
            .accept(MediaType.APPLICATION_JSON)
            .exchange() //invoking the end point
            .expectStatus().is2xxSuccessful
            .returnResult<Any>()
            .responseBody

        response.blockFirst() shouldBe expectedResult[0]
        //response.blockLast() shouldBe expectedResult[1]

        verify(exactly = 1) {
            userService.findAll()
        }
        }

    @Test
    fun `should create user when create api is being called`() {

        val exepectedResponse = mapOf(
            "id" to 999,
            "name" to "Rahul",
            "contactno" to 1234567890,
            "password" to "abcd@abcd" )

        val user = User(999,"Rahul" ,1234567890 , "abcd@abcd")

        every {
            userService.addUsers(user)
        } returns Mono.just(user)

        val response = client.post()
            .uri("/users/add")
            .bodyValue(user)
            .exchange()
            .expectStatus().is2xxSuccessful
            .returnResult<Any>().responseBody

        response.blockFirst() shouldBe exepectedResponse

        verify(exactly = 1) {
            userService.addUsers(user)
        }
    }

  /*    @Test
         fun `should be able to update the user`() {

              val expectedResult = listOf(
                  mapOf( "id" to 999,
                      "name" to "Rahul",
                      "contactno" to 1234567890,
                      "password" to "abcd@abcd" )
              )
              val user = User(999,"Rahul" ,1234567890 , "abcd@abcd")

              every {
                  userService.updateUser(999,user)
              } returns Mono.just(user)

              val response = client.put()
                  .uri("users/update/id")
                  .bodyValue(user)
                  .exchange()
                  .expectStatus().is2xxSuccessful

          //response shouldBe expectedResult

              verify(exactly = 1) {
                  userService.updateUser(999,user)
              }
          }*/
    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun userService() = mockk<UserService>()
    }

}

