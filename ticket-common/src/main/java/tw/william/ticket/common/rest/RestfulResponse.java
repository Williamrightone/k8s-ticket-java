package tw.william.ticket.common.rest;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestfulResponse<T> implements Serializable {

	private static final long serialVersionUID = 4306097870435698438L;

	private T data;
	
	public RestfulResponse(T data) {
		this.data = data;
	}
	
}
