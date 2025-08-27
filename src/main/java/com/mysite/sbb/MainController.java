package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // controller 임을 알려줘야함
public class MainController {
    // 함수 생성 - 기능
    @GetMapping("/")
    public void index() {
        System.out.println("index() 메서드 호출됨!");
    }

    @GetMapping("/hello") // /hello 라고 입력하면 해당 메서드 호출 가능
    public void hello() {
        System.out.println("hello() 메서드 호출됨!");
    }
}
