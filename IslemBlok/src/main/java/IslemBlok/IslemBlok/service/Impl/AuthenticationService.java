package IslemBlok.IslemBlok.service.Impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import IslemBlok.IslemBlok.dto.UserDto;
import IslemBlok.IslemBlok.dto.UserRequest;
import IslemBlok.IslemBlok.dto.UserResponse;
import IslemBlok.IslemBlok.entity.User;
import IslemBlok.IslemBlok.enums.Role;
import IslemBlok.IslemBlok.repository.UserRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	  	private final UserRepository userRepository;

	    private final JwtService jwtService;

	    private final AuthenticationManager authenticationManager;

	    private final PasswordEncoder passwordEncoder;

	    public UserResponse save(UserDto userDto) {
	        User user = User.builder()
	                .username(userDto.getUsername())
	                .password(passwordEncoder.encode(userDto.getPassword()))
	                .role(Role.USER).build();
	        
	        userRepository.save(user);
	       
	        var token = jwtService.generateToken(user);
	        
	        return UserResponse.builder().token(token).build();

	    }

	    public UserResponse auth(UserRequest userRequest) {
	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
	       
	        User user = userRepository.findByUsername(userRequest.getUsername()).orElseThrow();
	        
	        String token = jwtService.generateToken(user);
	        
	        return UserResponse.builder().token(token).build();
	    }

}
