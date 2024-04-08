package com.example.kody.service;

import com.example.kody.domain.mapper.Mappers;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Service {
    private final Mappers mappers;

    public void setQ(String question){
        mappers.setQ(question);
    }

    public String getQ(double ID){
        return mappers.getQ(ID);
    }

    public void setA(String answer, double ID){
        mappers.setA(answer,ID);
    }

    public double getMax(){
        return mappers.getMAX();
    }

    public String getPW(){
        return mappers.getPW();
    }

    public double getCounter(){
        return mappers.getNum();
    }
}
