package com.nodemngmt
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.OffsetStrategy
import io.micronaut.configuration.kafka.annotation.Topic
import jakarta.inject.Singleton
import spock.lang.Specification

@Singleton
@KafkaListener
class KafkaListenerTestSpec extends Specification {
    List<String> successes = []
    @Topic("component1")
    void handleSuccessEvent(String event) {
        successes.add(event)
    }
}
