package project;

import java.io.Serializable;

public class ArticleList implements Serializable{
	private Article first;
	private Article last;
	
	public ArticleList(){
		first = null;
		last = null;
	}
	public void insert(String title, String data, User person, String hobby){
		Article newArticle = new Article(title, data, person, hobby);
		if(first == null){
			first = newArticle;
		}else{
			last.setNext(newArticle);
			newArticle.setPrevious(last);
		}
		last = newArticle;
	}
	
	public Article deleteKey(String key){
		Article current = first;
		while(current.getTitle() != key){
			current = current.getNext();
			if(current == null){
				return null;
			}
		}
		
		if(current  == first){ // found it, first item?
			first= current.getNext();
		}else{
			current.getPrevious().setNext(current.getNext());
		}
		
		if(current == last){ // found it last item??
			last = current.getPrevious();
		}else{
			current.getNext().setPrevious(current.getPrevious());
		}
		return current;
	}

	public Article findArticle(String key){
		Article current = first;
		while(current != null){
			if(current.getTitle().equals(key)){
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	public Article getLast(){
		return last;
	}
	public Article getFirst(){
		return first;
	}
}
