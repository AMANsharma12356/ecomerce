package com.example.ecomerce.project.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

//
@Document
class User (
    @Id
    var userId: Int,
    var userName: String,
    var userContactno: Long,
    var userPassword: String,

//Aman  - 2908 1430
//Sidharth  -  2903 1515
    )