package com.web.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.member.domain.dto.MemberRequestDto;
import com.web.member.domain.dto.MemberResponseDto;
import com.web.member.domain.entity.Member;
import com.web.member.domain.entity.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {

	private MemberRepository memberRepository;
	
	@Transactional
	public Long registerMember(MemberRequestDto dto) {
		return memberRepository.save(dto.toEntity()).getNo();
	}
	
	@Transactional(readOnly=true)
	public List<MemberResponseDto> getMemberList() {
//		memberRepository.findAll(); 
//		이건 List<Member>
//		이걸 List<MemberResponseDto>로 변환하기 위해서는
//		우선 Stream으로 변환하고 map으로 담은다음 collect로 List형태로 변환.
		
		//java7 version
//		List<Member> memberList = memberRepository.findAll();
//		List<MemberResponseDto> dtoList = new ArrayList<MemberResponseDto>();
//		for(Member iter : memberList) {
//			dtoList.add(new MemberResponseDto(iter));
//		}

		//Stream - 스트림은 '데이터의 흐름’입니다. 
		//배열 또는 컬렉션 인스턴스에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 
		//가공된 결과를 얻을 수 있습니다. 또한 람다를 이용해서 코드의 양을 줄이고 간결하게 
		//표현할 수 있습니다. 즉, 배열과 컬렉션을 함수형으로 처리할 수 있습니다.
		
		//java8 version,  또는 findAll 결과를 Stream으로 받게 수정 후 stream()을 제거
		return memberRepository.findAll()
								.stream()
								.map(MemberResponseDto::new)
								.collect(Collectors.toList());
	}
	
	@Transactional
	public void deleteMember(String userId) {
		memberRepository.deleteByUserId(userId);
	}
	
	@Transactional
	public void updateMember(String userId, MemberRequestDto dto) {
		
		if(memberRepository.existsByUserId(userId)) {
			Member member = memberRepository.findOneByUserId(userId);
			member.fixMemberInfo(dto);
			memberRepository.save(member);
		}
		
	}
}
