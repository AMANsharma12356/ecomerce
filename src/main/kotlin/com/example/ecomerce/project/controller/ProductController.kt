package com.example.ecomerce.project.controller

import com.example.ecomerce.project.model.Product
import com.example.ecomerce.project.model.User
import com.example.ecomerce.project.service.ProductService
import com.example.ecomerce.project.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Flux

class ProductController
    (
    val productService: ProductService)
    {
        @GetMapping("/products")
        fun getAllProducts(): Flux<Product> {
            return productService.findAll()
        }

        @GetMapping("/products/list/")
        fun getProductBasisSearch(@PathVariable(required = true) query: String): Flux<Product> {
            return productService.findAll()
        }
    }


