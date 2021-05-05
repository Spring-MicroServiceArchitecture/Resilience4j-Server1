package com.example.resilience

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / http://minkuk-jo.com
 * @since 2021. 05. 05.
 */
@Service
class CallService(private val restTemplate: RestTemplate) {

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallback")
    fun call(): String? {
        val uri = URI.create("http://localhost:8081/sample/server2-fallback")
//        throw NumberFormatException()
        return restTemplate.getForObject(uri, String::class.java)
    }

    private fun fallback(e: IllegalArgumentException) = "FALLBACK IllegalArgument"

    private fun fallback(e: RuntimeException) = "FALLBACK RUNTIME"
}