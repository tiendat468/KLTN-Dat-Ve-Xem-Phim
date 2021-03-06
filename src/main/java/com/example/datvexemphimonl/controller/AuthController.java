package com.example.datvexemphimonl.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datvexemphimonl.config.MailConfig;
import com.example.datvexemphimonl.entity.KhachHang;
import com.example.datvexemphimonl.entity.Role;
import com.example.datvexemphimonl.entity.RoleType;
import com.example.datvexemphimonl.entity.DTO.auth.JwtResponse;
import com.example.datvexemphimonl.entity.DTO.auth.LoginRequest;
import com.example.datvexemphimonl.entity.DTO.auth.MessageResponse;
import com.example.datvexemphimonl.entity.DTO.auth.SignupRequest;
import com.example.datvexemphimonl.entity.DTO.exception.ApiException;
import com.example.datvexemphimonl.entity.DTO.exception.ERROR;
import com.example.datvexemphimonl.repository.RoleRepository;
import com.example.datvexemphimonl.service.KhachHangService;
import com.example.datvexemphimonl.util.JWTUtils;

import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private static final Logger LOGGER = LogManager.getLogger(AuthController.class);

	@Autowired
	JavaMailSender mailSender;

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

	private ApiException apiException;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {
		try {
			if (!khachHangService.checkExistsKhachHangBySdt(loginRequest.getSdt())) {
				return ResponseEntity.badRequest().body(new MessageResponse("E:S??? ??i???n tho???i ch??a ????ng k??"));
			}
			KhachHang khachHang = validateLoginRequest(loginRequest);
			if (!khachHang.getEnabled()) {

				return ResponseEntity.badRequest()
						.body(new MessageResponse("Ng?????i d??ng ???? b??? v?? hi???u h??a tr??n h??? th???ng"));

			}
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getSdt(), loginRequest.getMatKhau()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtUtils.generateJwtToken(authentication);

//            khachHang = khachHangService.getKhachHangBySDT(loginRequest.getSdt());
			return ResponseEntity.ok(
					new JwtResponse(khachHang.getIdKhachHang(), khachHang.getTenKhachHang(), khachHang.getSdt(), jwt));

		} catch (Exception ex) {
			ex.printStackTrace();
//			return ResponseEntity.badRequest().body(new MessageResponse(ex.toString()));
			return ResponseEntity.badRequest().body(new MessageResponse("E:M???t kh???u sai"));
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signupRequest,
			HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
		if (khachHangService.checkExistsKhachHangBySdt(signupRequest.getSdt())) {
			return ResponseEntity.badRequest().body(new MessageResponse("E:S??? ??i???n tho???i ???? ????ng k??"));
		}

		KhachHang khachHang = new KhachHang();

		khachHang.setTenKhachHang(signupRequest.getTenKhachHang());
		khachHang.setSdt(signupRequest.getSdt());
		khachHang.setEmail(signupRequest.getEmail());
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
		String randomCode = RandomString.make(64);
		khachHang.setVerification_code(randomCode);
		khachHangService.saveKhachHang(khachHang);
		try {
			sendVerificationEmail(request, khachHang);
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(new MessageResponse("Email kh??ng t???n t???i"));
		}
		
		return ResponseEntity.ok(new MessageResponse("Register successfully"));
	}

	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
		if (khachHangService.verify(code)) {
			return "verify_success";
		} else {
			return "very_fail";
		}
	}

	private KhachHang validateLoginRequest(LoginRequest loginUser) throws ApiException {
		if (StringUtils.isBlank(loginUser.getSdt())) {
			LOGGER.debug("login - user login fail : username blank");
			throw new ApiException(ERROR.INVALID_REQUEST, "S??? ??i???n tho???i kh??ng ???????c ????? tr???ng");
			
		}
		if (StringUtils.isBlank(loginUser.getMatKhau())) {
			LOGGER.debug("login - user login fail : password blank");
			throw new ApiException(ERROR.INVALID_REQUEST, "M???t kh???u kh??ng ???????c ????? tr???ng");
		}
		KhachHang optionalAccount = khachHangService.getKhachHangBySDT(loginUser.getSdt());
		if (optionalAccount == null) {
			LOGGER.debug("login - user login fail : user {} not found", loginUser.getSdt());
			throw new ApiException(ERROR.INVALID_REQUEST, "Ng?????i d??ng kh??ng t???n t???i tr??n h??? th???ng");
		}
		if (!encoder.matches(loginUser.getMatKhau(), optionalAccount.getMatKhau())) {
			LOGGER.debug("login - user login fail : user {} password not matching", loginUser.getSdt());
			throw new ApiException(ERROR.INVALID_REQUEST,
					"S??? ??i???n tho???i ho???c m???t kh???u kh??ng ????ng, xin vui l??ng th??? l???i!");
		}
//		if (!optionalAccount.isEnabled()) {
//			LOGGER.debug("login - user login fail : user {} not active", loginUser.getSdt());
////			throw new ApiException(ERROR.INVALID_REQUEST, "Ng?????i d??ng ???? b??? v?? hi???u h??a tr??n h??? th???ng");
//			apiException = new ApiException(ERROR.INVALID_REQUEST, "Ng?????i d??ng ???? b??? v?? hi???u h??a tr??n h??? th???ng");
//			return optionalAccount;
//		}

		return optionalAccount;
	}

	private void sendVerificationEmail(HttpServletRequest request, KhachHang khachHang)
			throws MessagingException, UnsupportedEncodingException {

		String toAddress = khachHang.getEmail();
		String fromAddress = "tangtiendat911@gmail.com";
		String senderName = "Cinema HoangNhi";
		String subject = "Please verify your registration";
		String content = "Wellcome,<br>" + "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>" + "Thank you,<br>" + "Cinema HoangNhi";

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);

		content = content.replace("[[name]]", khachHang.getTenKhachHang());

		String verifyURL = MailConfig.getSiteURl(request) + "/api/auth/verify?code=" + khachHang.getVerification_code();

		System.out.println(verifyURL);
		content = content.replace("[[URL]]", verifyURL);

		helper.setText(content, true);

		mailSender.send(message);
		System.out.println("to Address: " + toAddress);
		System.out.println("Verify URL: " + verifyURL);

	}

}
