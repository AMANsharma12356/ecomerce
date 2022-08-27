package com.example.ecomerce.project.service

import com.example.ecomerce.project.model.Login
import com.example.ecomerce.project.model.User
import reactor.core.publisher.Mono

class LoginService(val loginService: LoginService?) {
    fun addLogin(login: Login): Mono<Login> {

        return loginRepository.save(login)
    }
}