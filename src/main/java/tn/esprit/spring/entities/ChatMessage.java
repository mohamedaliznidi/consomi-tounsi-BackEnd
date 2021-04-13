package tn.esprit.spring.entities;

public class ChatMessage {
	
	public static class Builder {
		private String content;
		private String sender;
		private String time;
		private MessageType type ;
		
		public Builder() {};
		
		public Builder content (String content) {
			this.content = content;
			return this;
		}
		
		public Builder sender (String sender) {
			this.sender = sender;
			return this;
		}
		
		public Builder time (String time) {
			this.time = time;
			return this;
		}
		public Builder type (MessageType type) {
			this.type = type;
			return this;
		}
		
		public ChatMessage build() {
			ChatMessage message = new ChatMessage();
			message.setContent(this.content);
			message.setSender(this.sender);
			message.setTime(this.time);
			message.setType(this.type);
			
			return message;
		}
	}
	
	private String content;
	private String sender;
	private String time;
	private MessageType type ;

	public enum MessageType {
		CHAT,CONNECT,DISCONNECT
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}