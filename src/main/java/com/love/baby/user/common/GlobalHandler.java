package com.love.baby.user.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice(basePackages = "com.love.baby.user")
public class GlobalHandler implements ResponseBodyAdvice<Object> {

    public static Gson gson = new GsonBuilder().create();

    private static Logger logger = LoggerFactory.getLogger(GlobalHandler.class);


    @ExceptionHandler(value = Exception.class)
    public RenderInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) {
        logger.error("全局异常", e);
        RenderInfo<String> renderInfo = new RenderInfo<>();
        renderInfo.setMessage(e.getMessage());
        renderInfo.setCode(RenderInfo.ERROR);
        renderInfo.setUrl(req.getRequestURL().toString());
        return renderInfo;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public RenderInfo beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        logger.info("全局统一封装 body = {}", gson.toJson(body));
        if (body instanceof RenderInfo) {
            return gson.fromJson(gson.toJson(body), RenderInfo.class);
        }
        RenderInfo<Object> renderInfo = new RenderInfo<>();
        renderInfo.setCode(RenderInfo.OK);
        renderInfo.setData(body);
        return renderInfo;
    }
}