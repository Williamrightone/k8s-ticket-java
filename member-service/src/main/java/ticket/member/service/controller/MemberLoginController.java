package ticket.member.service.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.member.service.controller.dto.req.LoginRequest;
import ticket.member.service.controller.dto.res.LoginResponse;
import tw.william.ticket.common.handler.GlobalServiceException;
import tw.william.ticket.common.handler.GlobalServiceException.GlobalServiceErrorType;
import tw.william.ticket.common.rest.RestfulResponse;

@RestController
@RequestMapping("/member")
@Validated
public class MemberLoginController {

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> vaildPassword(@Valid @RequestBody LoginRequest request){
		
//		return loginService.loginByEmail(request);
		
		System.out.println("OKOK");
		
		if(true) {
			throw new GlobalServiceException(GlobalServiceErrorType.INPUT_FORMAT_ERROR,"12345");
		}
		
		return new ResponseEntity<LoginResponse>(new LoginResponse("wwwww","wwwww","wwwww","wwwww"), HttpStatus.OK);
		
	}
	
}
