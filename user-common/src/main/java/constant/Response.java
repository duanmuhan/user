package constant;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public Response(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(){
        this.code = ErrorCode.OK.getCode();
        this.message = ErrorCode.OK.getMessage();
        this.data = null;
    }
}
