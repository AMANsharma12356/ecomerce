package com.example.ecomerce.project.repository

import com.example.ecomerce.project.model.User
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveCrudRepository<User, Int> {

    @Query("{'name':?0}")
    fun findByName(name:String): User
}