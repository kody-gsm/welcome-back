package com.example.kody.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface Mappers {
    @Insert("INSERT INTO welcome (Q) VALUES (#{Q})")
    void setQ(String Q); //Q를 입력받아 데이터베이스에 넣는 코드

    @Update("UPDATE welcome SET A = (#{A}) WHERE ID = (#{ID})")
    void setA(String A, Double ID); //A를 ID를 입력받아 추가하는 코드

    @Select("SELECT Q FROM welcome WHERE ID = (#{ID})")
    String getQ(double ID); //Q를 받는 코드

//    @Select("SELECT A FROM welcome WHERE ID = (#{ID})")
//    String getA(double ID);

    @Select("SELECT MAX(ID) FROM welcome")
    double getMAX(); //가장 최근에 만들어진 질문을 가져오는 코드

    @Select("SELECT MIN(ID) FROM welcome WHERE A is null")
    double getNum(); //답반이 없는 것 중에서 가장 예전에 만들어진 질문의 ID를 가져오는 코드

    @Select("SELECT PW FROM user WHERE ID = 1")
    String getPW(); //PW를 가져오는 코드
}
