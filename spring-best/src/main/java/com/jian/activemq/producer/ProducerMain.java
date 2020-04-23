package com.jian.activemq.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ProducerMain {

    public static final String BROKEL_RUL = "tcp://localhost:61616";

    public static final String QUEUES_NAME = "queues001";

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(BROKEL_RUL);

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUES_NAME);

        MessageProducer messageProducer = session.createProducer(queue);

        for (int i=1;i<=2;i++) {
            TextMessage textMessage = session.createTextMessage("msg-->"+i);
            messageProducer.send(textMessage);
            System.out.println("生产这发送了："+textMessage.getText());
        }
        messageProducer.close();
        session.close();
        connection.close();


    }

}
