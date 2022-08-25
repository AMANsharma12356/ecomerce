package com.example.ecomerce.project.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User (
    @Id
    var id: Int,
    var name: String,
    var mail: String,
    var contactno: Long,
    var gender: String,
//aman
    )