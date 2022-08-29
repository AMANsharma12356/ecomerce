package com.example.ecomerce.project.service

import com.example.ecomerce.project.model.User
import com.example.ecomerce.project.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(val userRepository: UserRepository) {
    fun findAll(): Flux<User> =
        userRepository.findAll()

    fun deleteById(id: Int): Mono<Void> {
        return userRepository.deleteById(id)
    }

    fun addUsers(user:User): Mono<User>{
        return userRepository.save(user)
    }

    fun updateUser(id: Int, user: User): Mono<User> {
        return userRepository.findById(id)
            .flatMap {
                it.id = user.id
                it.name = user.name
                it.contactno = user.contactno
                it.password=user.password
                userRepository.save(it)
            }
    }

   /* fun findUserByName(name:String):User{
        var a:User =userRepository.findByName(name)
        var p1=a.password
        //if(p1==this.password){}
        //operators
        var b:Boolean
        return p1

    }*/
}