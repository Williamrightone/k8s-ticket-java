package tw.william.ticket.common.rest;

import java.io.IOException;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ConditionalOnClass({ RestTemplate.class })
public class RestTemplateConfig {

	@Bean(name = "restTemplate")
	public RestTemplate getRestTemplate() {		
		RestTemplate restTemplate = new RestTemplate();
		ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
			@Override
			public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
				return true;
			}

			@Override
			public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

			}
		};
		restTemplate.setErrorHandler(responseErrorHandler);
		return restTemplate;
	}
	
}
