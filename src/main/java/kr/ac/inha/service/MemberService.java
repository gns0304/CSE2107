package kr.ac.inha.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.ac.inha.dto.MemberDto;
import kr.ac.inha.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper mapper;
	
	public int addMember(MemberDto dto) throws Exception {
		
		return mapper.addMember(dto);
		
	}
	
	
	
	
	public MemberDto getUser(String id, String pw) throws Exception {
		
		return mapper.getUser(id, pw);
		
	}
	// Service
	public MemberDto getUserById(String id) throws Exception {
		
		return mapper.getUserById(id);
		
	}

	public int updateMember(MemberDto dto) throws Exception {
		
		return mapper.updateMember(dto);
		
	}
}
