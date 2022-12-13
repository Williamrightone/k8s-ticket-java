package ticket.bff.service.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import ticket.bff.service.controller.dto.req.LoginRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
	
	private static final String LOGIN_URI = "/login/v1/validation";

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_login_email_is_null() throws Exception {

		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest(null, "Demo1234")));
		
		testFormatErrorMockPerform(requestbuilder);
		
	}
	
	private void testFormatErrorMockPerform(RequestBuilder requestbuilder) throws Exception {

		mockMvc.perform(requestbuilder)
		.andDo(print())
		.andExpect(jsonPath("$.customErrorCode").value("00001"))
		.andExpect(status().is(400));

	}

}
