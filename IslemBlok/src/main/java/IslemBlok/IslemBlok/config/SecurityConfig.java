package IslemBlok.IslemBlok.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	

	 private final AuthenticationProvider authenticationProvider;
	 

	 private final JwtAuthenticationFilter jwtAuthenticationFilter;

//,"/design/**","/users/**","/projects/**"
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http
	                .csrf(csrf -> csrf.disable()) // CSRF'yi devre dışı bırak
	                .authorizeHttpRequests(auth -> auth
	                        .requestMatchers("/login/**").permitAll() //  login endpoint izin verildi
	                        .anyRequest().authenticated()) // Diğer tüm istekler için kimlik doğrulama istendi
	                .sessionManagement(session -> session
	                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
	                .authenticationProvider(authenticationProvider) // Özel kimlik doğrulama sağlayıcısı
	                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // JWT filtreyi ekle
	                .build();
	    }

}
