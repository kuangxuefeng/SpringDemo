package com.kxf.springdemo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.kxf.springdemo.inteceptor.AuthenticationInterceptor;
import com.kxf.springdemo.inteceptor.CurrentUserMethodArgumentResolver;
import com.kxf.springdemo.inteceptor.ReqIdInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

//    @Value("${file.userfiles-path}")
//    private String filePath;

	/**
	 * 登录校验拦截器
	 *
	 * @return
	 */
	@Bean
	public ReqIdInterceptor reqIdInterceptor() {
		return new ReqIdInterceptor();
	}
	
	/**
	 * 登录校验拦截器
	 *
	 * @return
	 */
	@Bean
	public AuthenticationInterceptor loginRequiredInterceptor() {
		return new AuthenticationInterceptor();
	}

	/**
	 * CurrentUser 注解参数解析器
	 *
	 * @return
	 */
	@Bean
	public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
		return new CurrentUserMethodArgumentResolver();
	}

	/**
	 * 参数解析器
	 *
	 * @param argumentResolvers
	 */
	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(currentUserMethodArgumentResolver());
		super.addArgumentResolvers(argumentResolvers);
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(reqIdInterceptor());
		registry.addInterceptor(loginRequiredInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login", "/server/**", "/test/**")
				.excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/error");
		super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//		registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/")
//				.addResourceLocations("classpath:/static/page/").addResourceLocations("classpath:/static/templates/");
//                .addResourceLocations("file:" + filePath);
	}

//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.QuoteFieldNames,
//                SerializerFeature.WriteEnumUsingToString,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteDateUseDateFormat,
//                SerializerFeature.DisableCircularReferenceDetect);
//        fastJsonConfig.setSerializeFilters((ValueFilter) (o, s, source) -> {
//            if (null != source && (source instanceof Long || source instanceof BigInteger) && source.toString().length() > 15) {
//                return source.toString();
//            } else {
//                return null == source ? EMPTY : source;
//            }
//        });
// 
//        //处理中文乱码问题
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastConverter.setSupportedMediaTypes(fastMediaTypes);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastConverter);
//    }
}