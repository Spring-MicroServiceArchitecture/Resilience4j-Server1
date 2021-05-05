package com.example.resilience

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import java.time.Duration

@SpringBootApplication
class ResilienceApplication {
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplateBuilder().setReadTimeout(Duration.ofSeconds(1)).build()
    }
}

fun main(args: Array<String>) {
    runApplication<ResilienceApplication>(*args)
}
