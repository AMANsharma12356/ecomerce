package com.example.ecomerce.project.controller

import com.example.ecomerce.project.model.Login
import com.example.ecomerce.project.model.User
import com.example.ecomerce.project.repository.LoginRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class LoginController {
    @Autowired
    private val loginRepository: LoginRepository? =null
   // @PostMapping("add")
//    fun addLogin(@RequestBody login: Login): Mono<Login> {
      //  return loginService.addLogin(login)
    //}
}



//@RestController
//class HomeController {
//    @Autowired
//    private val bookRepository: BookRepository? = null
//    @GetMapping("/find")
//    fun main(): ResponseEntity<*> {
//        return ResponseEntity.ok(bookRepository.findPositionalParameters("Ray Kurzweil", "Fiction"))
//    }
//}