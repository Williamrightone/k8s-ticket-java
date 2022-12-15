package ticket.bff.service.service.vo.output;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReplyVo {

	private String email;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userName;
	
	private String accessToken;
	
	private String refreshToken;
	
}
