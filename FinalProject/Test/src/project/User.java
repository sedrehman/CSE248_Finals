package project;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable{
	private String userName;
	private String password;
	private String nickName;
	private String[] hobbies;
	private ArticleList articles;
	private Map<String, User> likes;
	public User(String userName, String password, String nickName, String[] hobbies, ArticleList articles) {
		super();
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.hobbies = hobbies;
		this.articles = articles;
		this.likes = new HashMap<String, User>();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public ArticleList getArticles() {
		return articles;
	}
	public void setArticles(ArticleList articles) {
		this.articles = articles;
	}
	public Map<String, User> getLikes() {
		return likes;
	}
	public void addLikes(User user) {
		likes.put(user.getUserName(), user);
	}
	@Override
	public String toString() {
		return nickName;
	}
	
	
}
