package com.example.kody.controller;


import com.example.kody.service.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/kody")
@Transactional
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class welcontroller {
    private final Service service;

    @PostMapping("/create")
    public String create(@RequestBody Map<String, String> q){
        service.setQ(q.get("question"));
        return "Create-question";
    }

    @PostMapping("/createA")
    public String createA(@RequestBody Map<String, String> a){
        service.setA(a.get("adminquestion"), service.getCounter());
        return "Create-answer";
    }

    @GetMapping("/question")
    public String question(){
        return service.getQ(service.getCounter());
    }

    @GetMapping("/getQ")
    public String getq(){
        double id = 5;
        String datas = service.getQ(id);
        return datas;
    }

    @PostMapping("/check")
    public boolean check(@RequestBody Map<String, String> q){
//        System.out.println(q.get("password"));
//        System.out.println(service.getPW().equals(q.get("password")));
        return service.getPW().equals(q.get("password"));
    }
}
