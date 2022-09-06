package com.example.ecomerce.project.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Product (
    val productId : Int,
    val productName : String,
    val productPrice : Float,
)
