package com.folder.boot.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

  @Select("select 1 as no")
  public int dbTest();

  @Select("select * from user where no = 1")
  public Map<String, Object> findUser();

}