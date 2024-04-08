package com.example.kody.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface Mappers {
    @Insert("INSERT INTO welcome (Q) VALUES (#{Q})")
    void setQ(String Q);

    @Update("UPDATE welcome SET A = (#{A}) WHERE ID = (#{ID})")
    void setA(String A, Double ID);

    @Select("SELECT Q FROM welcome WHERE ID = (#{ID})")
    String getQ(double ID);

//    @Select("SELECT A FROM welcome WHERE ID = (#{ID})")
//    String getA(double ID);

    @Select("SELECT count(ID) FROM welcome")
    double getMAX();

    @Select("SELECT MIN(ID) FROM welcome WHERE A is null")
    double getNum();

    @Select("SELECT PW FROM user WHERE ID = 1")
    String getPW();
}
