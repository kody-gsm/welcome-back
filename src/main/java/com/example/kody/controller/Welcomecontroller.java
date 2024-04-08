package com.example.kody.controller;


import com.example.kody.service.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kody")
@Transactional
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequiredArgsConstructor
public class Welcomecontroller {
    private final Service service;
    @GetMapping("/Question")
    public List<Map<Double,String>> Max(){
        double selecter = service.getMax();
        System.out.println(selecter);
        Map<Double, String> data = new HashMap<>();

        List<Map<Double,String>> datas = new ArrayList<>();
        for(double i = 5;i<selecter;i++){
            data.put(i,service.getQ(i));
            datas.add(data);
        }

        return datas;
    }
}
