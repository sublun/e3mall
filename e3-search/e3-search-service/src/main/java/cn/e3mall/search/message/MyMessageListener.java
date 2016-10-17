package cn.e3mall.search.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.search.mapper.SearchItemMapper;

/**
 * 监听Activemq发送的消息
 * <p>Title: MyMessageListener</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			//取消息内容
			try {
				String text = textMessage.getText();
				System.out.println(text);
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
		}

	}

}
