package com.pyruz.multidomains.crawler;

import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DomainCrawlerService {

    private final String KAFKA_TOPIC = "web-domains";
    final KafkaTemplate<String, Domain> kafkaTemplate;

    public DomainCrawlerService(KafkaTemplate<String, Domain> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void crawl(String name) {
        Mono<Domains> domainsMono = WebClient.create()
                .get()
                .uri("https://api.domainsdb.info/v1/domains/search?domain=" + name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Domains.class);
        domainsMono.subscribe(domainList -> domainList.getDomains().forEach(i -> {
            kafkaTemplate.send(KAFKA_TOPIC, i);
            System.out.println("Domain message: " + i.getDomain());
        }));
    }
}
