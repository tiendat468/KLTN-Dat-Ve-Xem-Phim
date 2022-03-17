package com.example.datvexemphimonl.service.auth;

import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.repository.KhachHangRepository;
import com.example.datvexemphimonl.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KhachHangDetailsServiceImpl implements UserDetailsService {

    @Autowired
    KhachHangService khachHangService;
    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String sdt) throws UsernameNotFoundException {
        KhachHang khachHang = khachHangService.getKhachHangBySDT(sdt);

        return KhachHangDetails.build(khachHang);
    }
}
