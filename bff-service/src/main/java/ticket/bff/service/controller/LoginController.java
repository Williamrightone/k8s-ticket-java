package ticket.bff.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.bff.service.controller.dto.req.LoginRequest;
import ticket.bff.service.controller.dto.res.LoginResponse;
import ticket.bff.service.service.LoginService;
import tw.william.ticket.common.rest.RestfulResponse;

@RestController
@RequestMapping("/login/v1")
@Validated
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/validation")
	public RestfulResponse<LoginResponse> vaildPassword(@Valid @RequestBody LoginRequest request){
		
		return loginService.loginByEmail(request);
	}

}
