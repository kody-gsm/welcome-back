package com.example.kody.controller;

import com.example.kody.service.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kody")
@Transactional
@RequiredArgsConstructor
public class welcontroller {
    private final Service service;

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.POST)
    @PostMapping("/create") //DB에 Q를 추가하는 코드
    public String create(@RequestBody Map<String, String> q){
        service.setQ(q.get("question"));
        return "Create-question";
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.POST)
    @PostMapping("/createA") //DB에 A를 추가하는 코드(답변하지 않은 것 중 가장 예전에 만든것 부터)
    public String createA(@RequestBody Map<String, String> a){
        service.setA(a.get("adminquestion"), service.getNum());
        return "Create-answer";
    }

    @CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(value = "/questions", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<Double,String> questions(){
        Map<Double, String> map = new HashMap<>();
        for(double i = 1; i <= service.getMax(); i++){
            String Qs = service.getQ(i);
            map.put(i, Qs);
        }
        return map;
    }

    @CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(value = "/answers", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<Double,String> answers(){
        Map<Double, String> map = new HashMap<>();
        for(double i = 1; i <= service.getMax(); i++){
            String As = service.getA(i);
            map.put(i, As);
        }
        return map;
    }

    @CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(value = "/question", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<Integer,String> question(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1, service.getQ(service.getNum()));

        return map;
    }


    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true",methods = RequestMethod.GET)
    @GetMapping("/answer") //쓸모 없음.. 나중에 필요할까봐 만든거임.
    public String answer(){
        return service.getA(service.getNum());
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.POST)
    @PostMapping("/check") //어드민이랑 PW랑 같은지 확인하고 맞으면 true를 주는 코드
    public boolean check(@RequestBody Map<String, String> q){
        return service.getPW().equals(q.get("password"));
    }
}
