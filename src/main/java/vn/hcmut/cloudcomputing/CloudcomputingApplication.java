package vn.hcmut.cloudcomputing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import vn.hcmut.cloudcomputing.properties.StorageProperties;
import vn.hcmut.cloudcomputing.services.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@PropertySource({"classpath:/application.properties"})
public class CloudcomputingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudcomputingApplication.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
//            storageService.deleteAll();
//            storageService.init();
        };
    }
}
