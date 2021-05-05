package com.example.resilience

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / http://minkuk-jo.com
 * @since 2021. 05. 05.
 */
@RestController
class SampleController(private val callService: CallService) {

    @GetMapping("/call-server2")
    fun callServer2(): String? {
        return callService.call()
    }
}