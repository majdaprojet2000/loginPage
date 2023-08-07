package com.example.loginPage.controllers;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/doc")
  @PreAuthorize("hasRole('DOCTOR')")
  public String doctorAccess() {
    return "Doctor Board.";
  }

  @GetMapping("/nur")
  @PreAuthorize("hasRole('NURSE')")
  public String nurseAccess() {
    return "Nurse Board.";
  }

}
