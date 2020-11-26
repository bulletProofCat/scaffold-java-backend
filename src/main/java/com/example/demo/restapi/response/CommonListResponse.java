package com.example.demo.restapi.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonListResponse<T> extends BaseResponse {
    public List<T> list;
}
