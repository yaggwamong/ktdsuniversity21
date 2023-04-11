package com.hello.member.dao;

import com.hello.member.vo.MemberVO;

/**
 * MyBatis 환경에서 DAO 메소드의 Parameter 규칙
 * 항상 하나의 파라미터만 전달해야 한다
 */
public interface MemberDAO {
	
	public int createNewMember(MemberVO memberVO);
	
	public int readCountMemberByEmail(String email);
	
	// MyBatis가 하나의 파라미터만 받기 때문에 이메일과 password를 모두 가진 memberVO를 준다
	// 로그인 기능
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO);
	
	

}
