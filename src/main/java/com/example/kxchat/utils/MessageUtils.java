package com.example.kxchat.utils;

import com.alibaba.fastjson.JSON;
import com.example.kxchat.ws.pojo.ResultMessage;

/**
 * @version v1.0
 * @ClassName: MessageUtils
 * @Description: 封装json格式消息的工具类
 * @Author: 黑马程序员
 */
public class MessageUtils {

    public static String getMessage(String fromName, Object message, int touxiang) {

        ResultMessage result = new ResultMessage();
        result.setMessage(message);
        result.setTouxiang(touxiang);
        result.setFromName(fromName);
        return JSON.toJSONString(result);
    }
}
