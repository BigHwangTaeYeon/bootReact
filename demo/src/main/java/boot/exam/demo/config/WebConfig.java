package boot.exam.demo.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Encoding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import lombok.extern.log4j.Log4j2;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Log4j2
@Configuration
public class WebConfig {
    
    //jsonView 빈네임 설정을 통해, jsonView가 리턴될 때, JSON형태의 데이터로 매핑
    @Bean(name="jsonView")
    public MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }

    // thymeleaf layout 
    // layout-dialect를 사용하기 위해서 bean 등록을 해주어야 한다.
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
    
    //defaultLocaleResolver() messageSource() messageSourceAccessor() messge관련 method
    @Bean
    public LocaleResolver defaultLocaleResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREAN);

        log.info("localeResolver Bean Created.");
        return localeResolver;
    }
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        Locale.setDefault(Locale.KOREAN); // 제공하지 않는 언어로 들어왔을 때 처리

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages/messages"); 
        messageSource.setDefaultEncoding(Encoding.DEFAULT_CHARSET.toString());
        messageSource.setDefaultLocale(Locale.getDefault());
        messageSource.setCacheSeconds(600);

        log.info("messageSource Bean Created. Default Charset is {} and Default Locale is {}",
                    Encoding.DEFAULT_CHARSET.toString(), Locale.getDefault());

        return messageSource;
    }
    @Bean
    public MessageSourceAccessor messageSourceAccessor (
            @Autowired ReloadableResourceBundleMessageSource messageSource) {
        return new MessageSourceAccessor(messageSource);
    }
}
