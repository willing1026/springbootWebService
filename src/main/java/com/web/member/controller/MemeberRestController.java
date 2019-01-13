package com.web.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.member.domain.dto.MemberRequestDto;
import com.web.member.domain.dto.MemberResponseDto;
import com.web.member.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemeberRestController {
	
//	private MemberRepository memberRepository;
	private MemberService memberService;
	
	@PostMapping("/member")
	public Long registerMember(@RequestBody MemberRequestDto dto) {
		return memberService.registerMember(dto); 
	}
	
	@PutMapping("/member/{userId}")
	public void updateMemberInfo(@PathVariable String userId, @RequestBody MemberRequestDto dto) {
		memberService.updateMember(userId, dto);
	}
	
	@DeleteMapping("/member/{userId}")
	public void deleteMember(@PathVariable String userId) {
		memberService.deleteMember(userId);
	}
	
	@GetMapping("/member")
	public List<MemberResponseDto> getMemberList() {
		return memberService.getMemberList();
	}
	
//	@GetMapping("/hello")
//	public String hello() {
//		return "hello";
//	}
}
