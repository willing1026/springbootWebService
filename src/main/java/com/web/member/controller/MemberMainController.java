package com.web.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class MemberMainController {
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
}

//templates 경로아래는 view template를 넣어야함
//정적 html파일을 넣어놓으면 인식 못함

//정적html을 인식하게 하려면 다른 방법이 필요한거 같다.
//https://stackoverflow.com/questions/38999206/spring-boot-mapping-static-html