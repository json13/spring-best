package com.jian.activemq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.imageio.IIOException;
import javax.jms.*;

public class ConsumerMain {

    public static final String BROKEL_RUL = "tcp://localhost:61616";

    public static final String QUEUES_NAME = "queues001";

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(BROKEL_RUL);

        Connection connection = activeMQConnectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUES_NAME);

        MessageConsumer messageConsumer = session.createConsumer(queue);


        /*while (true)
        {
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            if (null != textMessage) {
                System.out.println("消费者消费了：" + textMessage.getText());
            }
        }*/
        //messageConsumer.close();
        //session.close();
        //connection.close();

        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                if (null != textMessage) {
                    try {
                        System.out.println("消费者消费了：" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }

}
