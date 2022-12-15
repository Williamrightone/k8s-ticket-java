package tw.william.ticket.common.handler;

public class GlobalServiceException extends RuntimeException {

	private static final long serialVersionUID = -8017354947974311878L;

	public enum GlobalServiceErrorType {

		INPUT_FORMAT_ERROR("00001", CustomErrorLevel.LOW.name());

		private String customErrorCode;

		private String customErrorLevel;

		GlobalServiceErrorType(String customErrorCode, String customErrorLevel) {
			this.customErrorCode = customErrorCode;
			this.customErrorLevel = customErrorLevel;
		}

		public String getCustomErrorCode() {
			return customErrorCode;
		}

		public String getCustomErrorLevel() {
			return customErrorLevel;
		}

	}

	private String errorCode;

	private String errorLevel;

	public GlobalServiceException(GlobalServiceErrorType customServiceErrorType, String exceptionMsg) {
		super(exceptionMsg);
		this.errorCode = customServiceErrorType.getCustomErrorCode();
		this.errorLevel = customServiceErrorType.getCustomErrorLevel();
	}

	public GlobalServiceException(String errorCode, String exceptionMsg, Throwable cause) {
		super(exceptionMsg, cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorLevel() {
		return errorLevel;
	}

}
