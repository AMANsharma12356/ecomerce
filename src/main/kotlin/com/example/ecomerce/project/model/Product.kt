package com.example.ecomerce.project.model


import org.springframework.data.mongodb.core.mapping.Document

@Document
class Product (
    val proid : Int,
    val proname : String,
    val proprice : Float,
    val proquantity : Int,

)