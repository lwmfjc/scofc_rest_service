package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 */

/**
 * 使用jar :1 mvn clean package
 *          2 java -jar target/scofc_rest_service-1.0-SNAPSHOT.jar
 * 相当于 @Controller 和 @ResponseBody
 */
@RestController
public class GreetingController {
    private static final String template = "Hello,%s!";
    private final AtomicLong counter = new AtomicLong();//并发安全

    //相当于@RequestMapping(method=GET)
    //还有PostMapping
    @GetMapping("/greeting")
    public Greeting getting(@RequestParam(value = "name", defaultValue = "World")
                                    String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));

    }
}
