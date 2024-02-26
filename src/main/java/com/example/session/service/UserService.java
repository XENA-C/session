package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired //생성자주입?
    private UserRepository userRepository; //사용자저장소

    //로그인
    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession    //Controller에서 Request, HttpSession 받아옴
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);
        //repository 에 저장된 유저객체 중 id 검색--> optionalUser 에 담음

        if (optionalUser.isPresent()) { // 해당 id 있다면
            var userDto = optionalUser.get(); //userDto에 담는다

            if (userDto.getPassword().equals(pw)){
                httpSession.setAttribute("USER", userDto);
                //pw 일치 -> "USER" 명으로 UserDto 정보 세션에 저장

            }else { //pw 불일치
                throw new RuntimeException("Password Not Match");
            }

        }else { //유저가 없을 때
            throw new RuntimeException("User Not Found");
        }


    }

}
