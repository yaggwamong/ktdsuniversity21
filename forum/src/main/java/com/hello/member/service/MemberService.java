package com.hello.member.service;

import com.hello.member.vo.MemberVO;

public interface MemberService {
	
	public boolean createNewMember(MemberVO memberVO);
	
	public int readCountMemberByEmail(String email);
	//readCountMember는 createNewMember 내에서 호출할 예정
	
	public MemberVO readOneMembeByEmailAndPassword(MemberVO memberVO);

}
