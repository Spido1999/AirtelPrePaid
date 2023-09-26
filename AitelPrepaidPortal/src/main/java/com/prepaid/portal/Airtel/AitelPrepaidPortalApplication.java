package com.prepaid.portal.Airtel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.prepaid.portal.Airtel.filter.JWTfilter;

@SpringBootApplication
public class AitelPrepaidPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AitelPrepaidPortalApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean jwtFiler()
	{
		FilterRegistrationBean filterRegistraionBean = new FilterRegistrationBean();
		filterRegistraionBean.setFilter(new JWTfilter());
		filterRegistraionBean.addUrlPatterns("/api/**");
		return filterRegistraionBean ;
		
	}

}
