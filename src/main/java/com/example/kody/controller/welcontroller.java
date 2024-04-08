package com.example.kody.controller;


import com.example.kody.service.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/kody")
@Transactional
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequiredArgsConstructor
public class welcontroller {
    private final Service service;
    @PostMapping("/create")
    public String create(@RequestBody Map<String, String> q){
        service.setQ(q.get("question"));
        return "Create";
    }

    @GetMapping("/getQ")
    public String getq(){
        double id = 5;
        String datas = service.getQ(id);
        return datas;
    }

    @GetMapping("/getA")
    public String geta(){
        return service.getQ(5);
    }

    @PostMapping("/check")
    public boolean check(@RequestBody Map<String, String> q){
        return service.getPW().equals(q.get("PW"));
    }
}
