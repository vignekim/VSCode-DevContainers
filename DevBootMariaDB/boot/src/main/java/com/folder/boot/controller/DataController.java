package com.folder.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.folder.boot.mapper.TestMapper;

@CrossOrigin(origins = "*")
@RestController
public class DataController {

  @Autowired TestMapper tm;

  @GetMapping("/")
  public String home() {
    return "Data 준비 중! .... " + tm.dbTest();
  }

}
