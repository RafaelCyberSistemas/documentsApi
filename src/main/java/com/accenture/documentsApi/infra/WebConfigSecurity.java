package com.accenture.documentsApi.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {


    //METODO PARA LIBERAR ACESSO COM AUTENTICAÇÃO DE USUARIOS ESPECIFICOS EM MEMORIA
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("RAFAEL")
                    .password(passwordEncoder().encode("123456"))
                    .roles("admin")
                .and()
                .withUser("LOGIN")
                    .password(passwordEncoder().encode("123456"))
                    .roles("admin")
                .and()
                .withUser("KAYKY")
                    .password(passwordEncoder().encode("123456"))
                    .roles("admin");

    }

    //ESTE METODO É UTILIZANDO QUANDO DEFINIMOS UM USUARIO PADRAO NAS APLICATIONS.PROPERTIES E FAZEMOS O DEVIDO BLOQUEIO POR AQUI
    //SERVE PARA ENDPOINTS ONDE O CLIENTE SERA OUTRA API OU UM BATCH OU QUALQUER COISA DO TIPO
    //POIS PODEMOS DEFINIR QUAIS ENDPOINTS AQUELE CLIENT ROBÔ PODE ACESSAR E QUAL O USUAIRO E A SENHA QUE ELE DEVERA ENVIAR
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                    .authorizeRequests()
                        .antMatchers("/api/v1/configuracao/**").permitAll() //LIBERANDO OS ENDPOINTS QUE ESTEJAM ABAIXO DE CONFIGURACAO
                        .anyRequest().authenticated() //BLOQUEANDO TODAS OS DEMAIS ENDPOINTS
                .and() //DAQUI PRA BAIXO É PARA ELIMINAR OS COOKIES
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//ATE AQUI BLOQUEIO DE COOKIES
                .and()
                    .csrf().disable();//DESABILITANDO O CSRF PARA EVITAR TENTATIVAS DE INVASÃO ATRAVÉS DESTA FORMA
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
