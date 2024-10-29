package tn.esprit.tpfoyer.config;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MetricsConfig implements WebMvcConfigurer {

    @Value("${app.api.settings.cross-origin.patterns:localhost}")
    private String[] allowedOriginPatterns;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all paths
                .allowedOriginPatterns(allowedOriginPatterns)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed methods
                .allowedHeaders("*")
                .allowCredentials(true); // Allow credentials if needed
    }
}




