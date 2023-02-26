package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // アノテーションを使って、Controllerクラスであることを宣言
public class HelloController {

    @RequestMapping(value="/index") // 「/index」にリクエストが来たときに呼び出されるメソッドを作成
    public String index() {
        return "index";
    }
}
