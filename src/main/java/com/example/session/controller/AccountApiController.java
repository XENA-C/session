package com.example.session.controller;


import com.example.session.model.LoginRequest;
import com.example.session.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor //생성자 메서드
@RestController
@RequestMapping("/api/account")
public class AccountApiController { //로그인 처리

    private final UserService userService;
    //Controller(로그인 정보를 받아 세션생성) -> service(요청정보와 세션 정보 받아 처리)

    @PostMapping("/login") //데이터 전송
    public void login(//아이디와 패스워드
        @RequestBody
          LoginRequest loginRequest, //로그인 요청 정보
          HttpSession httpSession //스프링에서 해당 요청 시 세션 생성
         //json 통신-> post 방식, requestBody--> userService
    ){
            userService.login(loginRequest, httpSession);
            //request, session 서비스로직에 전달하여 처리
        }
    }


