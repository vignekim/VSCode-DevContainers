package com.folder.boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

  @Select("select 1 as no")
  public int dbTest();

}