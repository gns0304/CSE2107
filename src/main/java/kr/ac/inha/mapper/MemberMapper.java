package kr.ac.inha.mapper;

import kr.ac.inha.dto.MemberDto;


public interface MemberMapper {
	public int addMember(MemberDto dto) throws Exception;
	public MemberDto getUser(String id, String pw) throws Exception;
	//mapper
	public MemberDto getUserById(String id) throws Exception;
	public int updateMember(MemberDto dto) throws Exception;
}
