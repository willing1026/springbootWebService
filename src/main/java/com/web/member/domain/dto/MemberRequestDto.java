package com.web.member.domain.dto;

import com.web.member.domain.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {

	private String userId;
	private String name;
	private int age;

	@Builder
	public MemberRequestDto(String userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
	}
	
	public Member toEntity() {
		return Member.builder()
				.userId(userId)
				.name(name)
				.age(age)
				.build();
	}
}