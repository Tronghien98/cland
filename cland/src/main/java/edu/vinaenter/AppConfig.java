package edu.vinaenter;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScans({@ComponentScan("edu.vinaenter")})
@EnableWebMvc
public class AppConfig {
	
	@Bean("viewResolver")
	
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		return viewResolver;
		
	}
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	@Bean(name = "multipartResolver")
    public MultipartResolver getMultipartResolver() {
        CommonsMultipartResolver resover = new CommonsMultipartResolver();
        // 1MB
        //resover.setMaxUploadSize(1 * 1024 * 1024);
        return resover;
    }
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
	    return new StandardServletMultipartResolver();
	}
	@Bean(name = "viewResolverTiles")
	@Order(0)
	public ViewResolver getViewResolver() {
	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
	// TilesView 3
	viewResolver.setViewClass(TilesView.class);
	viewResolver.setOrder(0);
	return viewResolver;
	}
	@Bean(name = "tilesConfigurer")
	public TilesConfigurer getTilesConfigurer() {
	TilesConfigurer tilesConfigurer = new TilesConfigurer();
	// TilesView 3
	tilesConfigurer.setDefinitions("/WEB-INF/templates/cland-template.xml","/WEB-INF/templates/admin-template.xml");
	return tilesConfigurer;
	}
	
}