package metier.entities;

public class Messages {
	private int idMessage;
	private String Message;
	private int id_user_from;
	private int id_receiver;
	private int id_sender;
	private int id_user_to;
	private String Time;
	private String MessageRecived;
	private String MessageSend;
	public Messages(int idMessage, String message, int id_user_from, int id_user_to, String time) {
		super();
		this.idMessage = idMessage;
		Message = message;
		this.id_user_from = id_user_from;
		this.id_user_to = id_user_to;
		Time = time;
	}
	public Messages() {
		super();
	}
	public Messages(String message, int id_user_from, int id_user_to, String time) {
		super();
		Message = message;
		this.id_user_from = id_user_from;
		this.id_user_to = id_user_to;
		Time = time;
	}
	public Messages(String message, int id_user_from, int id_user_to, String time, String messageRecived,
			String messageSend) {
		super();
		Message = message;
		this.id_user_from = id_user_from;
		this.id_user_to = id_user_to;
		Time = time;
		MessageRecived = messageRecived;
		MessageSend = messageSend;
	}
	public String getMessageRecived() {
		return MessageRecived;
	}
	public void setMessageRecived(String messageRecived) {
		MessageRecived = messageRecived;
	}
	public String getMessageSend() {
		return MessageSend;
	}
	public void setMessageSend(String messageSend) {
		MessageSend = messageSend;
	}
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getId_user_from() {
		return id_user_from;
	}
	public void setId_user_from(int id_user_from) {
		this.id_user_from = id_user_from;
	}
	public int getId_user_to() {
		return id_user_to;
	}
	public void setId_user_to(int id_user_to) {
		this.id_user_to = id_user_to;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	@Override
	public String toString() {
		return "Messages [idMessage=" + idMessage + ", Message=" + Message + ", id_user_from=" + id_user_from
				+ ", id_user_to=" + id_user_to + ", Time=" + Time + "]";
	}
	public int getId_receiver() {
		return id_receiver;
	}
	public void setId_receiver(int id_receiver) {
		this.id_receiver = id_receiver;
	}
	public int getId_sender() {
		return id_sender;
	}
	public void setId_sender(int id_sender) {
		this.id_sender = id_sender;
	}
	

}
