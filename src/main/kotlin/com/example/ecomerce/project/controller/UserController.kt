package com.example.ecomerce.project.controller

import com.example.ecomerce.project.model.User
import com.example.ecomerce.project.service.UserService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("users/")
class UserController
    (val userService : UserService) {

    @GetMapping("list")
    fun getAllUsers(): Flux<User> {
        return userService.findAll()
    }

    @GetMapping("/users/list/")
    fun getUserBasisSearch(@PathVariable(required = true) query: String): Flux<User> {
        return userService.findAll()
    }

    @PostMapping("add")
    fun addUser(@RequestBody user: User): Mono<User> {
        return userService.addUsers(user)
    }

    @DeleteMapping("/user/delete/{id}")
    fun deleteUserById(@PathVariable("id") id: Int): Mono<Void> {
        return userService.deleteById(id)
    }

    @PutMapping("/user/update/{id}")
    fun updateUserById(@PathVariable("id") id: Int, @RequestBody user: User): Mono<User> {
        return userService.updateUser(id, user)
    }
}