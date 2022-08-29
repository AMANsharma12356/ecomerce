package com.example.ecomerce.project.repository

import com.example.ecomerce.project.model.Login
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface LoginRepository : ReactiveCrudRepository<Login,Int> {

    @Query("{'users.name':?0}")
     fun findByName(name: String): Mono<Login>
}