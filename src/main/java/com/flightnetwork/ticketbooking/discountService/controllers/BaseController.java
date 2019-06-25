package com.flightnetwork.ticketbooking.discountService.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class BaseController {
    private static final Logger logger = LogManager.getLogger(BaseController.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, String> runtimeException(RuntimeException ex) {
        logger.error(ex.getMessage(), ex);
        return Collections.singletonMap("message", "server error.please try after sometime");
    }
}
