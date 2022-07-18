package dev.hanjoon.lms.configuration;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import dev.hanjoon.lms.history.entity.LoginHistory;
import dev.hanjoon.lms.history.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final LoginHistoryService loginHistoryService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        loginHistoryService.save(
            LoginHistory.builder()
                        .userId(authentication.getName())
                        .userAgent(request.getHeader("user-agent"))
                        .clientIp(!Optional.ofNullable(request.getHeader("X-FORWARDED-FOR"))
                                           .orElse(request.getRemoteAddr()).equals("0:0:0:0:0:0:0:1")
                                 ? Optional.ofNullable(request.getHeader("X-FORWARDED-FOR"))
                                           .orElse(request.getRemoteAddr()) : "127.0.0.1")
                        .build());
        setDefaultTargetUrl("/");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
