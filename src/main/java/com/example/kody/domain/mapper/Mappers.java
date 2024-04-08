package com.example.kody.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface Mappers {
    @Insert("INSERT INTO welcome (Q) VALUES (#{Q})")
    void setQ(String q);

    @Select("SELECT Q FROM welcome WHERE ID = (#{ID})")
    String getQ(double ID);

    @Select("SELECT A FROM welcome WHERE ID = (#{ID})")
    String getA(double ID);

    @Select("SELECT count(ID) FROM welcome")
    double getMAX();

    @Select("SELECT PW FROM user")
    String getPW();
}
