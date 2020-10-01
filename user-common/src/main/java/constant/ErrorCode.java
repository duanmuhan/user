package constant;

public enum ErrorCode {

    OK(200,"ok"),
    EXCEPTION(700001,"exception"),
    PARAM_ERROR(700002,"params error"),
    LOGIN_ERROR(700003, "login error"),
    AUTH_ERROR(7000004,"auth error");
    private Integer code;
    private String message;

    ErrorCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}