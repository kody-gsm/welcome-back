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

//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true",methods = RequestMethod.GET)
//    @GetMapping("/questions") //Q전체를 가져오는 코드
//    public Map<Double,String> questions(){
////        List<Map<Double,String>> list = new ArrayList<>();
//        Map<Double, String> map = new HashMap<>();
//        for(double i = 1; i <= service.getMax(); i++){
//            String Qs;
//            Qs = service.getQ(i);
//            map.put(i-1,Qs);
////            list.add(map);
//        }
//        System.out.println(map);
//        return map;
//    }

//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.POST)
//    @PostMapping("/questions") //Q전체를 가져오는 코드 Post버전
//    public Map<Double,String> questionsPost(){
////        List<Map<Double,String>> list = new ArrayList<>();
//        Map<Double, String> map = new HashMap<>();
//        for(double i = 1; i <= service.getMax(); i++){
//            String Qs;
//            Qs = service.getQ(i);
//            map.put(i,Qs);
////            list.add(map);
//        }
//
//        System.out.println(map);
//        return map;
//    }

    @CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(value = "/questions", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<Double,String> questions(){
        Map<Double, String> map = new HashMap<>();
        for(double i = 1; i <= service.getMax(); i++){
            String Qs = service.getQ(i);
            map.put(i, Qs);
        }
        System.out.println(map);
        return map;
    }


//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.GET)
//    @GetMapping("/answers") //답변들 전체다 가져오는 코드
//    public Map<Double,String> answers(){
////        List<Map<Double,String>> list = new ArrayList<>();
//        Map<Double, String> map = new HashMap<>();
//        for(double i = 1; i <= service.getMax(); i++){
//            String As;
//            As = service.getA(i);
//            map.put(i,As);
////            list.add(map);
//        }
//        System.out.println(map);
//        return map;
//    }
//
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.POST)
//    @PostMapping("/answers") //답변들 전체다 가져오는 코드 Post버전
//    public Map<Double,String> answersPost(){
////        List<Map<Double,String>> list = new ArrayList<>();
//        Map<Double, String> map = new HashMap<>();
//        for(double i = 1; i <= service.getMax(); i++){
//            String As;
//            As = service.getA(i);
//            map.put(i,As);
//            System.out.println(As);
////            list.add(map);
//        }
//        System.out.println(map);
//        return map;
//    }

    @CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(value = "/answers", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<Double,String> answers(){
        Map<Double, String> map = new HashMap<>();
        for(double i = 1; i <= service.getMax(); i++){
            String As = service.getA(i);
            map.put(i, As);
        }
        System.out.println(map);
        return map;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.GET)
    @GetMapping("/question") //답변하지 않은 질문 중 가자 예전 Q를 가져오는 코드
    public String question(){
        return service.getQ(service.getNum());
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.POST)
    @PostMapping("/question") //답변하지 않은 질문 중 가자 예전 Q를 가져오는 코드 post버전
    public String questionPost(){
        return service.getQ(service.getNum());
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true",methods = RequestMethod.GET)
    @GetMapping("/answer") //쓸모 없음.. 나중에 필요할까봐 만든거임.
    public String answer(){
        return service.getA(service.getNum());
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", methods = RequestMethod.POST)
    @PostMapping("/check") //어드민이랑 PW랑 같은지 확인하고 맞으면 true를 주는 코드
    public boolean check(@RequestBody Map<String, String> q){
//        System.out.println(q.get("password"));
//        System.out.println(service.getPW().equals(q.get("password")));
        return service.getPW().equals(q.get("password"));
    }
}
