package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // controller 임을 알려줘야함
public class MainController {
    // 함수 생성 - 기능
    @GetMapping("/")
    @ResponseBody // 리턴값을 브라우저에 보여준다
    public String index() {
        return "sbb";
    }

    @GetMapping("/hello") // /hello 라고 입력하면 해당 메서드 호출 가능
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
