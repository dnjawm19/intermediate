package com.example.intermediate.service;

import com.example.intermediate.domain.Member;
import com.example.intermediate.domain.UserDetailsImpl;
import com.example.intermediate.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final MemberRepository memberRepository;

  @Override
  public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
    Member member = memberRepository.findByNickname(username)
            .map(this:Member)
            .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
    return new UserDetailsImpl(member);// 이 부분을 지우고 기능을 구현해주세요:)
  }
}
