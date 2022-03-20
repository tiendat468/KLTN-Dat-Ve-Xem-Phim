package com.example.datvexemphimonl.service.auth;

import com.example.datvexemphimonl.entity.KhachHang;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class KhachHangDetails implements UserDetails {
    private KhachHang khachHang;

    private Collection<? extends GrantedAuthority> authorities;

    public KhachHangDetails(KhachHang khachHang, Collection<? extends GrantedAuthority> authorities) {
        this.khachHang = khachHang;
        this.authorities = authorities;
    }

    public static KhachHangDetails build(KhachHang khachHang) {
        List<GrantedAuthority> authorities = khachHang.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        return new KhachHangDetails(khachHang, authorities);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return khachHang.getMatKhau();
    }

    @Override
    public String getUsername() {
        return khachHang.getSdt();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
