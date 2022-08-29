package com.example.ecomerce.project.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Product (
    val prodid : Int,
    val prodname : String,
    val prodprice : Float,
)
