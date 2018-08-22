package com.buy.config;

import com.buy.interceptor.OneInterceptor;
import com.buy.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/user/**");

		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/user/**")
													 .addPathPatterns("/redis/**");
		super.addInterceptors(registry);
	}

}
