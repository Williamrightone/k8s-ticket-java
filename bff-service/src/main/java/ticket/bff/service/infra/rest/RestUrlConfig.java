package ticket.bff.service.infra.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class RestUrlConfig {

	@Value("${ticket.member.login.url:}")
	private String memberServiceLoginUrl;
	
}
