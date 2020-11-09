package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse {

    public static final int ERROR_PARAM_VALIDATION_FAIL = -1;

    public int result;
    public String msg;

    public static BaseResponse success() {
        return new BaseResponse(0, "");
    }

    public static BaseResponse success(String msg) {
        return new BaseResponse(0, msg);
    }

    public static BaseResponse error(int result, String msg) {
        return new BaseResponse(result, msg);
    }

}
