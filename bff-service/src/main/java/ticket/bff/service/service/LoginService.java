package ticket.bff.service.service;

import ticket.bff.service.controller.dto.req.LoginRequest;
import ticket.bff.service.controller.dto.res.LoginResponse;
import tw.william.ticket.common.rest.RestfulResponse;

public interface LoginService {
	
	public RestfulResponse<LoginResponse> loginByEmail(LoginRequest request);

}
