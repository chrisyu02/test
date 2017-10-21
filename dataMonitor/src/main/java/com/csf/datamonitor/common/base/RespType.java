package com.csf.datamonitor.common.base;


/**
 * RespType
 * 
 * @author jack.huang
 * @version 2.0
 * @date 2016��8��18��
 * @update by jack
 */
public enum RespType {

	/**
	 * <p>
	 * ��������code��200-299 </br>
	 * �ض���code��300-399 </br>
	 * �ͻ��˴���code��400-499 </br>
	 * ����������code��500-599 </br>
	 * ͨ��ҵ��code��10100-10199 </br>
	 * Ȩ��code��10200-10299 </br>
	 * oauth��֤code��10300-10399
	 * </p>
	 */
	SUCCESS("200"),

	SUCCESS_CREATED("201"),

	// The request has been accepted for processing, but the processing has not
	// been completed
	SUCCESS_ACCEPTED("202"),

	SUCCESS_NO_CONTENT("204"),

	REDIRECT_PERMANTENTLY("301"),

	REDIRECT_PROXY_REQUIRED("305"),

	REDIRECT_TEMMPORARILY("307"),

	BAD_REQUEST("400"),

	UNAUTHORIZED_REQUEST("401"),

	FORBIDDEN_REQUEST("403"),

	NOT_FOUND("404"),

	METHOD_NOT_ALLOWED("405"),

	PROXY_UNAUTHORIZED_REQUEST("407"),

	REQUEST_TIMEOUT("408"),

	INTERNAL_SERVER_ERROR("500"),

	BAD_GATEWAY("502"),

	SERVICE_UNAVAILABLE("503"),

	GATEWAY_TIMEOUT("504"),

	HTTP_VERSION_NOT_SUPPORTED("505"),

	// command business
	/** ͨ��ҵ��: 10100 ~ 10199 */

	IO_EXCEPTION("10100"),

	IO_TIMEOUT("10101"),

	NULL_PARAMETERS("10102"),

	INCORRECT_TYPE_PARAMETERS("10103"),

	PARAMETERS_PARSING_EXCEPTION("10104"),

	INVALID_PARAMETERS("10105"),

	ENCODING_EXCEPTION("10106"),

	RUNTIME_EXCEPTION("10107"),

	PARAMETEREXCEPTION("10199"),

	NO_PERMISSION("10200"),

	DOWNLOAD_TIMES_LIMIT("10201"),

	DOWNLOAD_FLOW_LIMIT("10202"),

	VISIT_TIMES_LIMIT("10203"),

	// ����Ƶ������
	VISIT_OVER_TPS("10204"),

	INVALID_APP("10300"),

	UNAUTHORIZED_APP("10301"),

	EXPIRED_APP("10302"),

	EXPIRED_ACCESS_TOKEN("10303"),

	INVALID_TIMESTAMP("10304"),

	NONCE_REJECT("10305"),

	BAD_REQUEST_MOTHOD("10306"),

	BAD_SIGN_METHOD("10307"),

	INVALID_SIGNATURE("10308"),

	// ��Ч������Key
	INVALID_ACCESSKEY("10309"),

	// �ӿ�ͣ��
	ABANDON_INTERFACE("10310"),

	// δ�ҵ�����
	NO_DATA_FOUND("10311"),

	// Login
	LOGIN_SUCCESS("10400"),

	LOGOUT_SUCCESS("10401"),

	INVALID_USER("10402"),

	INVALID_PASSWD("10403"),

	ENDPOINT_CHANGE("10404"),

	VERIFY_SUCCESS("10405"),

	DEACTIVATE_TOKEN_SUCCESS("10406"),

	DEACTIVATE_FAILED("10407"),

	USER_IS_NOT_ACTIVE("10408"),

	// regist
	REGIST_SUCCESS("10500"),

	REGIST_FAILED("10501"),

	INVALID_USERNAME("10503"),

	INVALID_MOBILE("10503"),

	INVALID_MAIL("10504");

	private String code;

	private RespType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
