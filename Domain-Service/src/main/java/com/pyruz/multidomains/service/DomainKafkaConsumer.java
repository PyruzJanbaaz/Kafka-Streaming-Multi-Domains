package com.pyruz.multidomains.service;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DomainKafkaConsumer {

    @Bean
    public Consumer<KStream<String, Domain>> domainService() {
        return kStream -> kStream.foreach((key, domain) -> {
            System.out.println(String.format("Domain consumed[%s] Status [%s]", domain.isDead(), domain.getDomain()));
        });
    }


}
