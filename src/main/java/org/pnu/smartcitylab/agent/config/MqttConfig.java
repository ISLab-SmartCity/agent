package org.pnu.smartcitylab.agent.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class MqttConfig {

    @Value("${mqtt.broker.host}")
    private String mqttBrokerHost;

    @Value("${mqtt.broker.port}")
    private String mqttBrokerPort;

    @Value("${mqtt.username}")
    private String mqttUsername;

    @Value("${mqtt.password}")
    private String mqttPassword;

    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();

        System.out.println("tcp://" + mqttBrokerHost + ":" + mqttBrokerPort);

        options.setServerURIs(new String[]{"tcp://" + mqttBrokerHost + ":" + mqttBrokerPort});
        options.setUserName(mqttUsername);
        String pass = mqttPassword;
        options.setPassword(pass.toCharArray());
        options.setCleanSession(true);

        factory.setConnectionOptions(options);

        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                "mqtt-test", mqttClientFactory(), "#");

        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                try {
                    String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
                    if (topic.equals("myTopic")) {
                        System.out.println("This is our topic");
                    }
                    System.out.println(message.getPayload());
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        };
    }

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("mqtt-test", mqttClientFactory());

        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("#");
        return messageHandler;
    }


}
