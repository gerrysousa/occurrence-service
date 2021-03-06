package br.com.occurrenceservice.adapter;

import java.util.List;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class OccurrenceServiceAdapter implements WebMvcConfigurer {

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
    PageableHandlerMethodArgumentResolver pmar = new PageableHandlerMethodArgumentResolver();
    pmar.setFallbackPageable(PageRequest.of(0,5));
    argumentResolvers.add(pmar);
  }
}
