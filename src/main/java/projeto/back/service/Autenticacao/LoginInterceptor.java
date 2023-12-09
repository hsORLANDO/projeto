package projeto.back.service.Autenticacao;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projeto.back.service.CookieService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) 
    throws Exception {

        if(CookieService.getCookie(request, "UsuarioId") != null) {
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}
