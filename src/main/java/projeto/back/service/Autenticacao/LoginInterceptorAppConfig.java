package projeto.back.service.Autenticacao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
            .excludePathPatterns(
                "/login",
                "/error",
                "/logar",
                "/cadastro",
                "/cadastrar",
                "/recuperar_senha",
                "/criar",
                "/vendor/**",
                "/js/**",
                "/favicon.ico",
                "/css/**"
            );
    }
    
}
