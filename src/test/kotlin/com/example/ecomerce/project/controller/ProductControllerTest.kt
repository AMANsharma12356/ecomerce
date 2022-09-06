package com.example.ecomerce.project.controller

import com.example.ecomerce.project.model.Product
import com.example.ecomerce.project.service.ProductService
import io.mockk.every
import org.junit.jupiter.api.Test

class ProductControllerTest {


    lateinit var productService: ProductService

    @Test
    fun `show the list of products`() {
        val prod1= Product(111,"Mobile1",20000f)
        val prod2= Product(222,"Mobile2",10000f)

        val expectedResult = listOf(
            mapOf("productId" to 111,
            "productName" to "Moblie1",
            "productPrice" to 20000),
            mapOf("productId" to 222,
                    "productName" to "Mobile2",
                    "productPrice" to 10000),)

        every { } }
    }
