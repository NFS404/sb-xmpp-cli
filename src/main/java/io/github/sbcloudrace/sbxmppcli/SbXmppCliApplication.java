package io.github.sbcloudrace.sbxmppcli;

import io.github.sbcloudrace.sbxmppcli.cli.SbXmppClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class SbXmppCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbXmppCliApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> SbXmppClient.getInstance();
    }
}
