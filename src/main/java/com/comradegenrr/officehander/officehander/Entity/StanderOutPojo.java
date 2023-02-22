package com.comradegenrr.officehander.officehander.Entity;

import com.alibaba.fastjson2.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StanderOutPojo {

    private String msg;
    private String code;
    private JSONObject jsonObject;
    
}
