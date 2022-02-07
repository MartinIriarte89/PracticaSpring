package com.martiniriarte.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// Establece el idioma por defecto de la web
	@Bean
	public LocaleResolver localeResolver() {
		var srl = new SessionLocaleResolver();
		srl.setDefaultLocale(new Locale("es"));
		return srl;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		var lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	// Este metodo registra el cambio de idioma apoyandose en el "lang" definido en
	// localChangeInterceptor()
	@Override
	public void addInterceptors(InterceptorRegistry registro) {
		registro.addInterceptor(localeChangeInterceptor());
	}

	// Url del path por default. Este metodo se usa para mapear path que no pasan
	// por un controlador
	@Override
	public void addViewControllers(ViewControllerRegistry registro) {
		registro.addViewController("/").setViewName("index");
		registro.addViewController("/login");
		registro.addViewController("/errores/403").setViewName("/errores/403");
	}
}
