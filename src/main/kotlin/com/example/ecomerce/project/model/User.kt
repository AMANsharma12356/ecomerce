package com.example.ecomerce.project.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User (
    @Id
    var id: Int,
    var name: String,
    var contactno: Long,
    var password: String,

//Aman  - 2908 1430
//Sidharth  -  2903 1515
    )