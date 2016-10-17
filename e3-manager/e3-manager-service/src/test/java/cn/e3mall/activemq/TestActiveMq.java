package cn.e3mall.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.junit.Test;

public class TestActiveMq {

	@Test
	public void testProducerQueue() throws Exception {
		// 1、创建一个连接工厂对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.168:61616");
		// 2、使用连接工厂创建一个连接Activemq的对象Connection
		Connection connection = connectionFactory.createConnection();
		// 3、开启连接
		connection.start();
		// 4、使用Connection对象创建一个Session对象
		// 第一个参数：是否开启事务。事务是Activemq的事务，跟数据库的事务没有关系。使用JTA技术可以实现分布式事务。一般不使用
		// true:开启 false：不开启，当第一个参数为true时，第二个参数没有意义。一般是false
		// 第二个参数：消息的应答模式。手动应答和自动应答。一般时自动应答就可以。
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		// 5、使用Session对象创建一个Destination对象，有两种queue、topic
		Queue queue = session.createQueue("test-queue");
		// 6、使用Session对象创建一个生产者Producer对象
		MessageProducer producer = session.createProducer(queue);
		// 7、创建一个TextMessage对象，保存要发送的内容。
		// 方法1
		/*
		 * TextMessage textMessage = new ActiveMQTextMessage();
		 * textMessage.setText("hello Activemq");
		 */
		// 方法2
		TextMessage textMessage = session.createTextMessage("hello Activemq111");
		// 8、使用Producer发送消息
		producer.send(textMessage);
		// 9、关闭资源
		producer.close();
		session.close();
		connection.close();
	}

	@Test
	public void testConsumerQueue() throws Exception {
		// 1、创建一个连接工厂对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.168:61616");
		// 2、使用连接工厂创建一个连接对象
		Connection connection = connectionFactory.createConnection();
		// 3、开启连接
		connection.start();
		// 4、使用连接对象创建一个Session对象
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		// 5、使用Session对象创建一个Destination对象。应该使用Queue
		Queue queue = session.createQueue("test-queue");
		// 6、使用Session对象创建一个消费者Consumer对象
		MessageConsumer consumer = session.createConsumer(queue);
		// 7、使用Consumer接收消息，需要注册一个监听对象
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				// 8、接收到消息，从消息对象中取消息内容
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					try {
						String text = textMessage.getText();
						System.out.println("接收到消息：" + text);
						//手动应答
						message.acknowledge();
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		// 等待接收消息。。。。
		System.out.println("//等待接收消息。。。。");
		int read = System.in.read();
		System.out.println(read);
		// 9、释放资源
		consumer.close();
		session.close();
		connection.close();
	}

	@Test
	public void testProducerTopic() throws Exception {
		// 1、创建一个连接工厂对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.168:61616");
		// 2、使用连接工厂创建一个连接Activemq的对象Connection
		Connection connection = connectionFactory.createConnection();
		// 3、开启连接
		connection.start();
		// 4、使用Connection对象创建一个Session对象
		// 第一个参数：是否开启事务。事务是Activemq的事务，跟数据库的事务没有关系。使用JTA技术可以实现分布式事务。一般不使用
		// true:开启 false：不开启，当第一个参数为true时，第二个参数没有意义。一般是false
		// 第二个参数：消息的应答模式。手动应答和自动应答。一般时自动应答就可以。
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5、使用Session对象创建一个Destination对象，有两种queue、topic,现在使用topic
		Topic topic = session.createTopic("spring-topic");
		// 6、使用Session对象创建一个生产者Producer对象
		MessageProducer producer = session.createProducer(topic);
		//消息的投送模式为持久化
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		// 7、创建一个TextMessage对象，保存要发送的内容。
		// 方法1
		/*
		 * TextMessage textMessage = new ActiveMQTextMessage();
		 * textMessage.setText("hello Activemq");
		 */
		// 方法2
		TextMessage textMessage = session.createTextMessage("hello Activemq topic11112");
		// 8、使用Producer发送消息
		producer.send(textMessage);
		// 9、关闭资源
		producer.close();
		session.close();
		connection.close();
	}

	@Test
	public void testConsumerTopic() throws Exception {
		// 1、创建一个连接工厂对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.168:61616");
		// 2、使用连接工厂创建一个连接对象
		Connection connection = connectionFactory.createConnection();
		//设置客户端id
		connection.setClientID("client1");
		// 3、开启连接
		connection.start();
		// 4、使用连接对象创建一个Session对象
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		// 5、使用Session对象创建一个Destination对象。应该使用topic
		Topic topic = session.createTopic("spring-topic");
		// 6、使用Session对象创建一个消费者Consumer对象
		//MessageConsumer consumer = session.createConsumer(topic);
		//参数1：消息目的地 参数2：订阅者名称
		TopicSubscriber consumer = session.createDurableSubscriber(topic, "spring-topic");
		// 7、使用Consumer接收消息，需要注册一个监听对象
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				// 8、接收到消息，从消息对象中取消息内容
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					try {
						String text = textMessage.getText();
						System.out.println("接收到消息：" + text);
						message.acknowledge();
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
				if(true) {
					int a = 1/0;
				}
			}
		});
		// 等待接收消息。。。。
		System.out.println("//客户端4，等待接收消息。。。。");
		int read = System.in.read();
		System.out.println(read);
		// 9、释放资源
		consumer.close();
		session.close();
		connection.close();
	}

}
