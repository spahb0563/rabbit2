package com.thejoen.rabbit2.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoen.rabbit2.exception.MemberNotFoundException;
import com.thejoen.rabbit2.exception.RegionNotFoundException;
import com.thejoen.rabbit2.model.entity.Member;
import com.thejoen.rabbit2.model.entity.MyTown;
import com.thejoen.rabbit2.model.entity.Region;
import com.thejoen.rabbit2.model.network.dto.member.MemberCreateRequestDTO;
import com.thejoen.rabbit2.model.network.dto.member.MemberResponseDTO;
import com.thejoen.rabbit2.model.network.dto.member.MemberUpdateRequestDTO;
import com.thejoen.rabbit2.repository.MemberRepository;
import com.thejoen.rabbit2.repository.MyTownRepository;
import com.thejoen.rabbit2.repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	private final RegionRepository regionRepository;

	private final MyTownRepository myTownRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	public ResponseEntity<MemberResponseDTO> create(MemberCreateRequestDTO request) {
		Region region = regionRepository.findByAddress(request.getAddress())
				.orElseThrow(() -> new RegionNotFoundException());
		
		Member member = memberRepository.save(request.toEntitiy(passwordEncoder.encode(request.getPassword())));
		
		myTownRepository.save(MyTown.builder()
				.region(region)
				.member(member)
				.status(null)
				.build()
				);
		
		return ResponseEntity.status(HttpStatus.CREATED).
				body(new MemberResponseDTO(member));
	}
	
	public ResponseEntity<MemberResponseDTO> read(Long id) {
		Member member=memberRepository.findById(id)
				.orElseThrow(() -> new MemberNotFoundException());

		return ResponseEntity.ok(new MemberResponseDTO(member));
	}

	@Transactional
	public ResponseEntity<MemberResponseDTO> update(Long id, MemberUpdateRequestDTO memberRequestDTO) {
		Member member=memberRepository.findById(id)
				.orElseThrow(() -> new MemberNotFoundException());
		
		String nickname=memberRequestDTO.getNickname();
		String picture=memberRequestDTO.getPicture();
		
		member.updateProfile(nickname, picture);
		
		return ResponseEntity.ok(new MemberResponseDTO(member));
	}
	
	@Transactional
	public ResponseEntity delete(Long id) {
		Member member=memberRepository.findById(id)
				.orElseThrow(() -> new MemberNotFoundException());
				
		memberRepository.delete(member);
		
		return ResponseEntity.ok().build();
		
	}
	

}
