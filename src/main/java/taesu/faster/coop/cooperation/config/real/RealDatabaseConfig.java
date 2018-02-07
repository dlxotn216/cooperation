package taesu.faster.coop.cooperation.config.real;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by taesu on 2018-02-06.
 */
@Configuration
@Profile("real")
@Slf4j
public class RealDatabaseConfig {

    @Value("${database.url.config}")
    private String databaseUrlConfig;

    @PostConstruct
    public void confirmProfile() {
        log.info("DEBUG CHECK PROFILE :" + databaseUrlConfig);
    }
}
