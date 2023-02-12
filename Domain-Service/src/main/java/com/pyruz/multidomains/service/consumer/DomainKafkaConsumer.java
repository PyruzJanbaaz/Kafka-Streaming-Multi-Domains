package com.pyruz.multidomains.service.consumer;

import com.pyruz.multidomains.service.model.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class DomainKafkaConsumer {

    @Bean
    public Consumer<KStream<String, Domain>> domainService() {
        return kStream -> kStream.foreach((key, domain) -> System.out.printf("Domain consumed[%s] Status [%s]%n", domain.isDead(), domain.getDomain()));
    }

}
