package com.example.ecomerce.project.service

import com.example.ecomerce.project.exceptions.UserServiceException
import com.example.ecomerce.project.model.User
import com.example.ecomerce.project.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(val userRepository: UserRepository) {
    fun findAll(): Flux<User> =
        userRepository.findAll()

    fun deleteUserById(userId: Int): Mono<Void> {

        return userRepository.deleteById(userId)

    }

    @Autowired
    fun addUsers(user: User): Mono<User> {
        return when {
            user.userId == 0 -> throw UserServiceException("Hello")
            else -> userRepository.save(user)
        }
    }
    fun updateUser(userId: Int, user: User): Mono<User> {
        return userRepository.findById(userId)
            .flatMap {
                it.userId = user.userId
                it.userName = user.userName
                it.userContactno = user.userContactno
                it.userPassword = user.userPassword
                userRepository.save(it)
            }
    }

    /*fun findUserByName(name:String):Boolean{
        var a:Boolean
        var orgpass:String
        userRepository.findByName(name)
            .flatMap {
               if( it.password==){
                   a=true
               }
            a=false }

        a=true
        return a
    }*/
}