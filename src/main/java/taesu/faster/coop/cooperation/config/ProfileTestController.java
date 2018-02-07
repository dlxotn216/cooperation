package taesu.faster.coop.cooperation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by taesu on 2018-02-06.
 */
@RestController
public class ProfileTestController {
    @Value("${database.url.config}")
    private String databaseUrlConfig;

    @GetMapping("/profile")
    public String getCurrentProfile(){
        return databaseUrlConfig;
    }
}
