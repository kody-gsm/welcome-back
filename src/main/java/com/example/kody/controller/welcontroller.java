package com.example.kody.controller;

import com.example.kody.service.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/kody")
@Transactional
@RequiredArgsConstructor
public class welcontroller {
    private final Service service;

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/create") //DB에 Q를 추가하는 코드
    public String create(@RequestBody Map<String, String> q){
        service.setQ(q.get("question"));
        return "Create-question";
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/createA") //DB에 A를 추가하는 코드(답변하지 않은 것 중 가장 예전에 만든것 부터)
    public String createA(@RequestBody Map<String, String> a){
        service.setA(a.get("adminquestion"), service.getNum());
        return "Create-answer";
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/question") //답변하지 않은 질문 중 가장 예전 Q를 가져오는 코드
    public String question(){
        return service.getQ(service.getNum());
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/getQ") //답변하지 않은 질문 중 가자 예전 Q를 가져오는 코드
    public String getq(){
        return service.getQ(service.getNum());
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/check") //어드민이랑 PW랑 같은지 확인하고 맞으면 true를 주는 코드
    public boolean check(@RequestBody Map<String, String> q){
//        System.out.println(q.get("password"));
//        System.out.println(service.getPW().equals(q.get("password")));
        return service.getPW().equals(q.get("password"));
    }
}
