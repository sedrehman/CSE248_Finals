package project;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Article implements Serializable{
	private String data;
	private final String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(
			Calendar.getInstance().getTime());
	//gives you creation time. WILL NOT LET YOU CHANGE IT.
	private String title;
	private User writer;
	private String hobby;
	private Article next;
	private Article previous;
	public Article(String title, String data, User writter, String hobby) {
		super();
		this.title = title;
		this.data = data;
		this.writer = writter;
		this.hobby = hobby;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	//notice there is not set writer because when you write an articles-
	//-you pass the user through the constructor;
	public User getWriter() {
		return writer;
	}
	public Article getNext() {
		return next;
	}
	public void setNext(Article next) {
		this.next = next;
	}
	public Article getPrevious() {
		return previous;
	}
	public void setPrevious(Article previous) {
		this.previous = previous;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return title + ",\n" + "hobby: " + hobby + ",\n" + data +"\n"+ "At " + timeStamp + "\n" + "by - " +writer.getNickName() ;
	}
	
}
