package boot.exam.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class LayOutConfig {
    // thymeleaf layout 
    // layout-dialect를 사용하기 위해서 bean 등록을 해주어야 한다.
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
}
