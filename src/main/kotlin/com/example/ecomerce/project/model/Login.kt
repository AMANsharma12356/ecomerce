package com.example.ecomerce.project.model

import org.springframework.data.annotation.Id

class Login (
    @Id
    val id:Int,
    var userName: String,
    var password:String
)
