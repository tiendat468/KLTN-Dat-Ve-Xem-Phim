package com.example.datvexemphimonl.service.auth;

import com.example.datvexemphimonl.entity.KhachHang;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private String tenKhachHang;
    private String sdtKhachHang;
    private String matkhau;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String tenKhachHang, String sdtKhachHang, String matkhau, Collection<? extends GrantedAuthority> authorities) {
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.matkhau = matkhau;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(KhachHang khachHang) {
        List<GrantedAuthority> authorities = khachHang.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        return new UserDetailsImpl(khachHang.getTenKhachHang(), khachHang.getSdt(), khachHang.getMatKhau(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return matkhau;
    }

    @Override
    public String getUsername() {
        return sdtKhachHang;
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
