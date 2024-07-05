package in.nic.NERIELearning.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String captcha = request.getParameter("captcha");
        String hiddenCaptcha = request.getParameter("hiddenCaptcha");

        if(captcha.equals(hiddenCaptcha)) {
//        	System.out.println("LSH: correct Captcha");
            response.sendRedirect("/");
        }else {
            response.sendRedirect("/?invalidCaptcha");
        }
    }
}