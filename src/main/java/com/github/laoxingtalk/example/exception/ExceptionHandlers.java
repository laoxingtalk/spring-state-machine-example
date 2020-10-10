package com.github.laoxingtalk.example.exception;

import com.github.laoxingtalk.example.vo.ResponseResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(OrderBizException.class)
    @ResponseBody
    public ResponseResultVO handleOrderBizException(OrderBizException ex) {
        log.warn("handleOrderBizException : ", ex);
        return ResponseResultVO.fail(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResultVO handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        log.warn("handleMethodArgumentNotValid : ", ex);
        return ResponseResultVO.fail(ex.getLocalizedMessage());
    }
}
