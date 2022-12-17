package ticket.bff.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ticket.bff.service.controller.dto.req.LoginRequest;
import ticket.bff.service.controller.dto.res.LoginResponse;
import ticket.bff.service.infra.rest.RestUrlConfig;
import ticket.bff.service.service.LoginService;
import ticket.bff.service.service.vo.input.LoginAskVo;
import tw.william.ticket.common.rest.RestfulResponse;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;

	@Autowired
	private RestUrlConfig restUrlConfig;

	@Override
	public RestfulResponse<LoginResponse> loginByEmail(LoginRequest request) {

		LoginAskVo loginAskVo = new LoginAskVo();
		loginAskVo.setEmail(request.getEmail());
		loginAskVo.setPassword(request.getPassword());

		ResponseEntity<LoginResponse> loginResponse = restTemplate
				.postForEntity(restUrlConfig.getMemberServiceLoginUrl(), loginAskVo, LoginResponse.class);
		
		if(!loginResponse.getStatusCode().equals(HttpStatus.OK)) {
			System.out.println(loginResponse.getStatusCodeValue());
			System.out.println("Error Msg");
			//TODO throw new Exception
		}
		
		System.out.println("==============================");
		System.out.println(loginResponse.getBody());

//		LoginResponse response = (LoginResponse) loginResponse.getBody().getData();
		
		return new RestfulResponse<LoginResponse>(loginResponse.getBody());
	}

}
