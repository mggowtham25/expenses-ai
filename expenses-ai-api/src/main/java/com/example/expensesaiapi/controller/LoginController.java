package com.example.expensesaiapi.controller;

import com.example.expensesaiapi.ApiResponse;
import com.example.expensesaiapi.constant.Constant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = Constant.INFO_URL)
@Tag(name = "Login Details", description = "Login / SingUp APIs")
public class LoginController {

    @GetMapping(path = "/sampleGet")
    public ResponseEntity<ApiResponse> getTokenData() {
        var response = new ApiResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
