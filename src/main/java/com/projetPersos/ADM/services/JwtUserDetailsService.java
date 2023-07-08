package com.projetPersos.ADM.services;

import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.repository.dao.Rank;
import com.projetPersos.ADM.repository.itf.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IMemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepository.findMemberByMail(mail);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + mail);
        }
        return new org.springframework.security.core.userdetails.User(optional.get().getMail(),
                optional.get().getPassword(), getAuthority(optional.get()));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Member member) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        Rank rank = member.getRank();
        authorities.add(new SimpleGrantedAuthority(rank.getName()));
        return authorities;
    }
}
