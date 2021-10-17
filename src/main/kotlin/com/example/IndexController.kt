package com.example

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    private val logger: Logger = LoggerFactory.getLogger(IndexController::class.java)

    @GetMapping("/")
    fun get(): ResponseEntity<IndexResource> {

        val message = "Hello SpringBoot!!"
        logger.info(message)
        return ResponseEntity(IndexResource(message = message), HttpStatus.OK)
    }

    @PostMapping("/")
    fun post(): ResponseEntity<IndexResource> {
        val message = "[example] resource created."
        logger.info(message)
        return ResponseEntity(IndexResource(message = message), HttpStatus.CREATED)
    }
}
