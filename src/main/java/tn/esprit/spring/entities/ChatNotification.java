package tn.esprit.spring.entities;

public class ChatNotification {
	private int id;
    private int senderId;
    private String senderName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public ChatNotification(int id, int senderId, String senderName) {
		this.id = id;
		this.senderId = senderId;
		this.senderName = senderName;
	}
	public ChatNotification() {
	}
}
