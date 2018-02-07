package taesu.faster.coop.cooperation.config.dev;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by taesu on 2018-02-06.
 */
@Configuration
@Profile("dev")
@Slf4j
public class DevDatabaseConfig {

    @Value("${database.url.config}")
    private String databaseUrlConfig;

    @PostConstruct
    public void confirmProfile(){
      log.info("DEBUG CHECK PROFILE :" + databaseUrlConfig);
    }

}
