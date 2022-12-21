package com.thejoen.rabbit2.service;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	
	@Transactional
	public ResponseEntity<MemberResponseDTO> create(MemberCreateRequestDTO request) {
		Region region = regionRepository.findById(request.getRegionId())
				.orElseThrow(() -> new RegionNotFoundException());
		
		Member member = memberRepository.save(request.toEntitiy());
		
		myTownRepository.save(MyTown.builder()
				.region(region)
				.member(member)
				.status(null)
				.build()
				);
		
		return ResponseEntity.ok(new MemberResponseDTO(member));
	}
	
	public ResponseEntity<MemberResponseDTO> read(Long id) {
		Member member=memberRepository.findById(id)
				.orElseThrow(() -> new MemberNotFoundException());

		return ResponseEntity.ok(new MemberResponseDTO(member));
	}

	@Transactional
	public Long update(Long id, MemberUpdateRequestDTO memberRequestDTO) {
		Member member=memberRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));
		
		String nickname=memberRequestDTO.getNickname();
		String picture=memberRequestDTO.getPicture();
		
		return id;
	}
	
	@Transactional
	public ResponseEntity delete(Long id) {
		Member member=memberRepository.findById(id)
				.orElseThrow(() -> new MemberNotFoundException());
				
		memberRepository.delete(member);
		
		return ResponseEntity.ok().build();
		
	}
	

}
