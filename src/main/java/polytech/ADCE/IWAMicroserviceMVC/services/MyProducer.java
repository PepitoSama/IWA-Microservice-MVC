package polytech.ADCE.IWAMicroserviceMVC.services;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import polytech.ADCE.IWAMicroserviceMVC.models.Position;

import java.util.Properties;

@Component
@PropertySource("classpath:application.properties")
public class MyProducer {

    private String server;

    private final Environment env;

    private Properties properties;
    org.apache.kafka.clients.producer.KafkaProducer<String,String> producer;

    public MyProducer(Environment env) {
        this.env = env;
        this.setServer(env.getProperty("bootstrap.server"));
        System.out.println(this.server);
    }

    public KafkaProducer<String, String> getProducer() {
        return producer;
    }

    public void openConnection() {
        // Create Properties
        this.setProperties(new Properties());
        this.getProperties().setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.getBootstrapServer());
        this.getProperties().setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.getProperties().setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // Create Producer
        this.setProducer(new org.apache.kafka.clients.producer.KafkaProducer<>(this.getProperties()));
    }

    public void send(String topic, String message) {
        // Create Record
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        producer.send(record);
    }

    public void sendPosition(Position position) {
        this.send("positions", position.toString());
    }

    public void closeConnection() {
        this.getProducer().flush();
        this.getProducer().close();
    }

    public void setProducer(KafkaProducer<String, String> producer) {
        this.producer = producer;
    }

    public String getBootstrapServer() {
        return server;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
