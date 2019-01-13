package com.web.member.domain.dto;

import com.web.member.domain.entity.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {

	private Long no;
	private String userId;
	private String name;
	private int age;

	public MemberResponseDto(Member entity) {
		this.no = entity.getNo();
		this.userId = entity.getUserId();
		this.name = entity.getName();
		this.age = entity.getAge();
	}
}
