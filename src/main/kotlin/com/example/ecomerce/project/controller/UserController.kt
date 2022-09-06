package com.example.ecomerce.project.controller

import com.example.ecomerce.project.model.User
import com.example.ecomerce.project.service.UserService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@CrossOrigin(origins = ["http://localhost:3000/"])
@RestController
@RequestMapping("users")
class UserController
    (val userService : UserService) {

    @GetMapping("lists")
    fun getAllUsers(): Flux<User> {
        return userService.findAll()
    }

    @PostMapping("add")
    fun addUser(@RequestBody user: User): Mono<User> {
        return userService.addUsers(user)
    }

    @DeleteMapping("delete/{id}")
    fun deleteUserById(@PathVariable("id") userId: Int): Mono<Void> {
        return userService.deleteById(userId)
    }

    @PutMapping("update/{id}")
    fun updateUserById(@PathVariable("id") userId: Int, @RequestBody user: User): Mono<User> {
        return userService.updateUser(userId, user)
    }
    /*@GetMapping("login/{name}")
   fun getUserByName(@PathVariable("name") name:String,passw):Mono<User> {
       return userService.findUserByName(name,password)
   } */
}