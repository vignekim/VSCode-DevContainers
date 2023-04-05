package com.folder.boot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class DataController {

  @GetMapping("/")
  public String home() {
    return "Data 준비 중! ....";
  }

  @GetMapping("/test")
  public int test(){
    return 1;
  }

}
