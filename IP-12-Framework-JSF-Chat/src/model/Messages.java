package model;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Messages {

	private ArrayList<Message> messages = null;
	private Message currentMessage = null;
	private Message previousMessage = null;
	
	public Messages (){
		messages = new ArrayList<Message>();
		//dio koda koji iz BD puni messages
		currentMessage = new Message();
	}
	
	
	public ArrayList<Message> getMessages() {
		return messages;
	}
	public Message getCurrentMessage() {
		return currentMessage;
	}
	public Message getPreviousMessage() {
		return previousMessage;
	}
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	public void setCurrentMessage(Message currentMessage) {
		this.currentMessage = currentMessage;
	}
	public void setPreviousMessage(Message previousMessage) {
		this.previousMessage = previousMessage;
	}
	
	public String addMessage(){

		messages.add(0, currentMessage);
		setPreviousMessage(currentMessage);
		currentMessage = new Message();
		return "index.xhtml";
	}
	
	public String cancelMessage(){
		currentMessage = new Message();
		return "index.xhtml";
	}
	
}
