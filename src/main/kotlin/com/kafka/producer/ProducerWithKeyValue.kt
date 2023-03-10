package com.kafka.producer

import com.kafka.KafkaConstants
import com.kafka.KafkaProducerConstants
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

class ProducerWithKeyValue {

    fun send() {
        val producer = KafkaProducer<String, String>(KafkaProducerConstants.DEFAULT_CONFIGS)
        val record1 = ProducerRecord(KafkaConstants.TOPIC_NAME, "Pangyo", "Pangyo")
        val record2 = ProducerRecord(KafkaConstants.TOPIC_NAME, "Busan", "Busan")
        producer.send(record1)
        producer.send(record2)
        producer.flush()
        producer.close()

    }

}

fun main() {
    val consumerShell = """
        bin/kafka-console-consumer.sh \
        --bootstrap-server my-kafka:9092 \
        --topic test \
        --from-beginning \
        --property print.key=true \
        --property key.separator="-"
    """
    ProducerWithKeyValue().send()
}