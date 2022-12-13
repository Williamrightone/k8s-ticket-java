package tw.william.ticket.common.handler;

public class GlobalServiceException extends RuntimeException {

	private static final long serialVersionUID = -8017354947974311878L;

	public enum GlobalServiceErrorType {
		
		INPUT_FORMAT_ERROR("00001", CustomErrorLevel.LOW.name());
		
		private String customErrorCode;
		
		private String customErrorLevel;
		
		GlobalServiceErrorType(String customErrorCode, String customErrorLevel){
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
	
}
