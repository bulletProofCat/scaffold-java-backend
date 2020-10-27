package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BaseResponse {
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
