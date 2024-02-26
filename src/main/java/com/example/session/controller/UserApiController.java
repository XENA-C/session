package com.example.session.controller;

import com.example.session.model.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("/me")
    public UserDto me( //본인의 정보 반환
        HttpSession httpSession
    ){
        //세션의 user 데이터를 userDto 로 형변환
        var userObject = httpSession.getAttribute("USER");
        if (userObject != null){
            var userDto = (UserDto)userObject;
            return userDto;
        }else {
            return null;  //로그인 사용자가 없으면 NULL
        }
     }
}
