package com.example.session.db;

import com.example.session.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepository { //데이터베이스가 존재하지 않으므로 유저정보 저장 공간 생성

    private List<UserDto> userList = new ArrayList<>(); //유저정보를 저장할 공백의 배열리스트

    public Optional<UserDto> findByName(String name){ //리스트에서 이름  검색--> 유저정보 반환
        return userList
                .stream()
                .filter(it-> { //이름 검색
                    return it.getName().equals(name);//동일 이름이 존재하면
                })
                .findFirst(); //첫번째 것을 리턴
    }

    @PostConstruct //해당 빈이 초기화 되면 호출
    public void init(){ //리스트에 사용자 정보 저장(name, pw)

            userList.add(
                  new UserDto("Xena", "1234")
            );
            userList.add(
                  new UserDto("Xen", "1234")
            );
            userList.add(
                    new UserDto("sen", "1234")
            );

    }

}
