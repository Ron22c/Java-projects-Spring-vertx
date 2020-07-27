package com.cranajit;

import com.cranajit.cars.BMW;
import com.cranajit.cars.Ferrari;
import com.cranajit.engines.V6;
import com.cranajit.engines.V8;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cranajit")
public class AppConfig {

    @Bean("ferrari")
    public Ferrari ferrari () {
        return new Ferrari();
    }

    @Bean("bmw")
    public BMW bmw () {
        return new BMW();
    }

    @Bean("v8_engine")
    public V8 v8 () {
        return new V8("OIL");
    }

    @Bean("v6_engine")
    public V6 v6 () {
        return new V6();
    }
}
