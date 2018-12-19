package finalproj.mvc.controller.student;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class Student_ChatController extends TextWebSocketHandler {
		  private static Logger logger = LoggerFactory.getLogger(Student_ChatController.class);
		  private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
		 
		  // Ŭ���̾�Ʈ�� ���� ���Ŀ� ����Ǵ� �޼���
		  @Override
		  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		    sessionList.add(session);
		    logger.info("{} �����", session.getId());
		  }
		 
		  // Ŭ���̾�Ʈ�� ������ �޽����� �������� �� ����Ǵ� �޼���
		  @Override
		  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		    logger.info("{}�� ���� {} ����", session.getId(), message.getPayload());
		    for (WebSocketSession sess : sessionList) {
		      sess.sendMessage(new TextMessage(session.getId() + " : " + message.getPayload()));
		    }
		  }
		 
		  // Ŭ���̾�Ʈ�� ������ ������ �� ����Ǵ� �޼ҵ�
		  @Override
		  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		    sessionList.remove(session);
		    logger.info("{} ���� ����", session.getId());
		  }
		}
