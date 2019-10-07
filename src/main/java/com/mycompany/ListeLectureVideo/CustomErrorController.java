package com.mycompany.ListeLectureVideo;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    @Override
    public String getErrorPath(){
        return "/error";
    }

    @GetMapping("/error")
    public ModelAndView handlerError(HttpServletRequest request){
        Object status= request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("status", status);
        return new ModelAndView("error", (Map<String, ?>) status);
    }
}
