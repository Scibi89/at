package com.example.at.inbound;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("api/dummy")
public class DummyController {

    @GetMapping("someId")
    public SomeObjectResponseDto getSomeObject(){
        return new SomeObjectResponseDto("someID");
    }
}
