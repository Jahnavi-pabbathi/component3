package com.nodemngmt
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
@MicronautTest(environments = ["test"])
class IntegrationTestSpec extends Specification{
    @Inject
    @Client("/")
    HttpClient httpClient


    @Inject
    KafkaListenerTestSpec kafkaListener

    void cleanup() {
        kafkaListener.successes.clear()
    }

    void cleanupSpec() {

    }
}
