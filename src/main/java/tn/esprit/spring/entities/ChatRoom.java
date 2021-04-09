package tn.esprit.spring.entities;

public class ChatRoom {
	
	public static class Builder {
		private int id;
	    private int chatId;
	    private int senderId;
	    private int recipientId;
	    
	    public Builder() {
	    }
	    
	    public Builder chatId (int chatId) {
	    	this.chatId = chatId;
	    	return this;
	    }
	    
	    public Builder senderId( int senderId) {
	    	this.senderId = senderId;
	    	return this;
	    }
	    
	    public Builder recipientId(int recipientId) {
	    	this.recipientId = recipientId;
	    	return this;
	    }
	    
	    public ChatRoom build() {
	    	ChatRoom room = new ChatRoom();
	    	room.setId(this.id);
	    	room.setChatId(this.chatId);
	    	room.setSenderId(this.senderId);
	    	room.setRecipientId(this.recipientId);
	    	
	    	return room;
	    }
	}
	
	private int id;
    private int chatId;
    private int senderId;
    private int recipientId;
    
    private ChatRoom() {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	
	
}
