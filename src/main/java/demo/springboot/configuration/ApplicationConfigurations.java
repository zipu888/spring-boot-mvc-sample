package demo.springboot.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ JdbcConnectionSettings.class })
public class ApplicationConfigurations {

}
