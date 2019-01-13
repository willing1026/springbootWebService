package com.web.member.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.web.member.domain.dto.MemberRequestDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 테이블과 링크될 클래스를 나타냄
 * 언더스코어 네이밍으로 이름 매칭 
 */
@Entity

/**
 * lombok 어노테이션
 * - 기계적으로 생성해야하는 (getter, setter, 생성자 등) 것들을 줄여준 라이브러리 

 * 객체요소에 대한 getter를 만들어준다 
 */
@Getter

/**
 * 매개변수가 없는 생성자 생성
 * accessLevel을 protected로 설정
 * 
 * -private : 해당 클래스 내부
 * -default : 패키지 내부
 * -protected : 패키지 내부 + 상속받은 외부 클래스 
 * -public : all
 */
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Member {
	
	@Id /** PK를 나타냄 */
	@GeneratedValue(strategy=GenerationType.IDENTITY) /** PK생성규칙. auto_increase */
	private Long no;
	
	@Column(length=100, nullable=false, unique=true)
	private String userId;
	
	private String name;
	
	private int age;

	@Builder
	public Member(String userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
	}
	
	public void fixMemberInfo(MemberRequestDto dto) {
		this.name = dto.getName();
		this.age = dto.getAge();
	}
}
