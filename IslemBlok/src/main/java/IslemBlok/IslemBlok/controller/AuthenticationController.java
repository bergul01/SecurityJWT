package IslemBlok.IslemBlok.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IslemBlok.IslemBlok.dto.UserDto;
import IslemBlok.IslemBlok.dto.UserRequest;
import IslemBlok.IslemBlok.dto.UserResponse;
import IslemBlok.IslemBlok.service.Impl.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {
	
	  private final AuthenticationService authenticationService;

	    @PostMapping("/save")
	    public ResponseEntity<UserResponse> save(@RequestBody UserDto userDto) {
	    	System.out.println(userDto);
	        return ResponseEntity.ok(authenticationService.save(userDto));
	    }

	    @PostMapping("/auth")
	    public ResponseEntity<UserResponse> auth(@RequestBody UserRequest userRequest) {
	    	System.out.println(userRequest);
	        return ResponseEntity.ok(authenticationService.auth(userRequest));
	    }

}
