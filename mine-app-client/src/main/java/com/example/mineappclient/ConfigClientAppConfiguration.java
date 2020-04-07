package smtrpz.mineappgateway;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "gateway")
public class ConfigClientAppConfiguration {
    public ConfigClientAppConfiguration() {
    }
    @Value("${gateway.property1}")
    private String property1;
    @Value("${gateway.property2}")
    private String property2;

}