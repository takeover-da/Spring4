package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 스프링 MVC 없이 순수한 자바클래스로 회원 관리 기능을 구현한 가상 리파지토리
// 테이블 대신 MAP을 사용하여 회원 정보를 저장하고 관리
public class MemberRepository {

	// 회원정보를 저장할 MAP(키: 회원번호, 값: 회원객체)
	static Map<Integer, Member> store = new HashMap<>();
	
	// 회원번호를 자동으로 생성하기 위한 시퀀스
	static int sequence = 0;
	
	// 새로운 회원을 저장소에 추가
	public Member save(Member member) {
		
		// 회원이 추가 될때마다 스퀀스를 1씩 증가하여 사용
		member.setNo(++sequence);  //1
		store.put(member.getNo(), member);  //1, member
		return member;
	}
	
	// 회원번호로 특정 회원 정보를 조회(단건)
	public Member findById(int no) {
		
//		Member member = store.get(no);
//		return member;
		// 위 코드를 더 간결하게 짠 코드
		return store.get(no);
	}
	
	// 저장소에 있는 모든 회원을 조회(전체조회)
	public List<Member> findAll() {
		
		// 저장소에 있는 모든 데이터 꺼내기
		Collection<Member> result = store.values();
		
		// MAP의 값을 LIST로 변환하여 반환
		List<Member> list = new ArrayList<>(result);
		
		return list;
		
		// 위 코드를 더 간결하게 짠 코드
//		return new ArrayList<>(result);
	}
	
	// 저장소에 있는 모든 회원 정보를 삭제
	public void clearStore() {
		
		store.clear();    //전체
		
//		store.remove(1);  //단건
	}
}
