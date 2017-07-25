package spring.config;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.epoint.order","com.epoint.goods", "com.epoint.staff"})
@PropertySources({
        @PropertySource({"classpath:/jdbc.properties"})
})
@ImportResource({"classpath:/spring/datasource.xml"})
public class AppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
