package com.codebay.goldeneye;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class ExceptionController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        int errorStatus = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");

        modelAndView.addObject("errorStatus", errorStatus);
        modelAndView.addObject("errorMessage", errorMessage);
        modelAndView.addObject("requestUri", requestUri);
        return modelAndView;
    }

    // Not found exceptions
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFoundException(NoHandlerFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        modelAndView.addObject("errorStatus", HttpStatus.NOT_FOUND.value());
        modelAndView.addObject("errorMessage", "La página solicitada no fue encontrada.");
        return modelAndView;
    }

    // Handle global errors exceptions
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorStatus", HttpStatus.INTERNAL_SERVER_ERROR.value());
        modelAndView.addObject("errorMessage", "An internal error occurred on the server.");
        return modelAndView;
    }

    // Handle 4XX errors exceptions
    @ExceptionHandler(HttpClientErrorException.class)
    public ModelAndView handleHttpClientErrorException(HttpClientErrorException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.setStatus(HttpStatus.valueOf(ex.getRawStatusCode()));
        modelAndView.addObject("errorStatus", ex.getStatusCode().value());
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    // Handle 5XX errors exceptions
    @ExceptionHandler(HttpServerErrorException.class)
    public ModelAndView handleHttpServerErrorException(HttpServerErrorException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.setStatus(HttpStatus.valueOf(ex.getRawStatusCode()));
        modelAndView.addObject("errorStatus", ex.getStatusCode().value());
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}