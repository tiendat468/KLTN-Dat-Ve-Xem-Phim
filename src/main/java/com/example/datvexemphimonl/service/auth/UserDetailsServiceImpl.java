package com.example.datvexemphimonl.service.auth;

import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public UserDetails loadUserByUsername(String sdt) throws UsernameNotFoundException {
        KhachHang khachHang = khachHangRepository.findBySdt(sdt);
        return UserDetailsImpl.build(khachHang);
    }
}
