package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.auth.JwtResponse;
import com.example.datvexemphimonl.entity.DTO.auth.LoginRequest;
import com.example.datvexemphimonl.entity.DTO.auth.MessageResponse;
import com.example.datvexemphimonl.entity.DTO.auth.SignupRequest;
import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.entity.Role;
import com.example.datvexemphimonl.entity.RoleType;
import com.example.datvexemphimonl.repository.RoleRepository;
import com.example.datvexemphimonl.service.KhachHangService;
import com.example.datvexemphimonl.service.auth.KhachHangDetails;
import com.example.datvexemphimonl.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    KhachHangService khachHangService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JWTUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {
        KhachHang khachHang = new KhachHang();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getSdt(), loginRequest.getMatKhau()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtils.generateJwtToken(authentication);

            khachHang = khachHangService.getKhachHangBySDT(loginRequest.getSdt());
            return ResponseEntity.ok(
                    new JwtResponse(khachHang.getTenKhachHang(), khachHang.getSdt(), jwt));
        } catch (Exception ex) {


            return ResponseEntity.badRequest().body(new MessageResponse("E:khachhang sai"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signupRequest) {
        if (khachHangService.checkExistsKhachHangBySdt(signupRequest.getSdt())) {
            return ResponseEntity.badRequest().body(new MessageResponse("E:sdtKhachHang is exists"));
        }

        KhachHang khachHang = new KhachHang();

        khachHang.setTenKhachHang(signupRequest.getTenKhachHang());
        khachHang.setSdt(signupRequest.getSdt());
        khachHang.setMatKhau(encoder.encode(signupRequest.getMatKhau()));
        Set<String> srtRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (srtRoles.size() == 0) {
            Role userRole = roleRepository.findByName(RoleType.ROLE_USER).get();
            roles.add(userRole);
        } else {
            srtRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(RoleType.ROLE_ADMIN).get();
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleType.ROLE_USER).get();
                        roles.add(userRole);
                        break;
                }
            });
        }
        khachHang.setRoles(roles);
        khachHangService.saveKhachHang(khachHang);
        return ResponseEntity.ok(new MessageResponse("Register successfully"));
    }

}
