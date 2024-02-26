package com.example.session.model;

import lombok.*;

@Builder
@Getter@Setter
@ToString
@NoArgsConstructor //기본생성자
@AllArgsConstructor
public class UserDto {

    private String name;
    private String password;

}
