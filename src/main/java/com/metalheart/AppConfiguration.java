package com.metalheart;

import com.metalheart.config.RestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RestConfiguration.class)
public class AppConfiguration {
}
