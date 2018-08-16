package ex3;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.beans.ExceptionListener;

public class Consumer implements Runnable, ExceptionListener, javax.jms.ExceptionListener {

    public static void main(String[] args) {
        new Consumer().run();
    }

    @Override
    public void run() {
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    "tcp://localhost:61616");

            Connection connection = connectionFactory.createConnection();
            connection.start();
            connection.setExceptionListener(this);

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic("PP.MSG.TOPIC");

            MessageConsumer consumer = session.createConsumer(destination);

            System.out.println("Started ... ");

            while (true) {
                Message msg = consumer.receive();

                if (msg instanceof TextMessage) {
                    String text = ((TextMessage) msg).getText();
                    System.out.println(text);

                    if (text.equals("exit")) {
                        break;
                    }
                }
            }

            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            System.out.println("Caught: " + e);
        }
    }


    @Override
    public void exceptionThrown(Exception e) {
        System.out.println("Exception occurred: " + e);
    }

    @Override
    public void onException(JMSException e) {
        System.out.println("JMSException occured: " + e);
    }
}
