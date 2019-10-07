package com.mycompany.ListeLectureVideo;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {
    Map<String, Object> modell = new HashMap<String, Object>();
    @Override
    public String getErrorPath(){
        return "/error";
    }

    @GetMapping("/error")
    public ModelAndView handlerError(HttpServletResponse response){
        int code= response.getStatus();
        modell.put("status", code);
        return new ModelAndView("error", modell);
    }
}
