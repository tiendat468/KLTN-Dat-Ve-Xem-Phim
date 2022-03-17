package com.example.datvexemphimonl.controller;

import com.example.datvexemphimonl.entity.DTO.auth.JwtResponse;
import com.example.datvexemphimonl.entity.DTO.auth.LoginRequest;
import com.example.datvexemphimonl.entity.DTO.auth.MessageResponse;
import com.example.datvexemphimonl.entity.DTO.auth.SignupRequest;
import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.entity.Role;
import com.example.datvexemphimonl.entity.RoleType;
import com.example.datvexemphimonl.repository.KhachHangRepository;
import com.example.datvexemphimonl.repository.RoleRepository;
import com.example.datvexemphimonl.service.KhachHangService;
import com.example.datvexemphimonl.service.auth.KhachHangDetails;
import com.example.datvexemphimonl.service.auth.UserDetailsImpl;
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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    KhachHangService khachHangService;
    @Autowired
    RoleRepository rolelRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JWTUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getSdtKhachHang(), loginRequest.getMatkhau()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getUsername(), userDetails.getSdtKhachHang()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signupRequest) {
        if (khachHangService.checkExistsKhachHangBySdt(signupRequest.getSdtKhachHang())) {
            return ResponseEntity.badRequest().body(new MessageResponse("E:sdtKhachHang is exists"));
        }

        KhachHang khachHang = new KhachHang();

        khachHang.setTenKhachHang(signupRequest.getTenKhachHang());
        khachHang.setSdt(signupRequest.getSdtKhachHang());
        khachHang.setMatKhau(encoder.encode(signupRequest.getMatKhau()));
        khachHang.setMatKhau(signupRequest.getMatKhau());
        Set<String> srtRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (srtRoles.size() == 0) {
            Role userRole = rolelRepository.findByName(RoleType.ROLE_USER).get();
            roles.add(userRole);
        } else {
            srtRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = rolelRepository.findByName(RoleType.ROLE_ADMIN).get();
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = rolelRepository.findByName(RoleType.ROLE_USER).get();
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
