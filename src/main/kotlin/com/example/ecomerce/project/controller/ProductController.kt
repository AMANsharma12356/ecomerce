package com.example.ecomerce.project.controller

import com.example.ecomerce.project.model.Product
import com.example.ecomerce.project.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("prod/")
class ProductController
    (val productService: ProductService) {

    @GetMapping("list")
        fun getAllProducts(): Flux<Product> {
            return productService.findAll()
        }

    @GetMapping("products/list/")
        fun getProductBasisSearch(@PathVariable(required = true) query: String): Flux<Product> {
            return productService.findAll()
        }
    }


