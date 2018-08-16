package ex3;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import java.io.IOException;
import java.util.Scanner;

public class Producer {

    public static void main(String[] args) throws JMSException, IOException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("PP.MSG.QUEUE");

        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String text = scanner.nextLine();

            producer.send(session.createTextMessage(text));

            if (text.equals("exit")) {
                break;
            }
        }

        session.close();
        connection.close();

    }

}