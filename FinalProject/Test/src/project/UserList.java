package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserList implements Serializable{
	private Map<String, User> list = new HashMap<String, User>();
	private File file = new File("src/project/data.txt");

	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("promlems saving the file");
		}
	}

	public void load() {
		if (file.exists()) { // making sure file exists
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				this.list = (Map<String, User>) ois.readObject();
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("problem loading");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Problems reading the class");
			}
		} else {
			System.out.println("file has not been created yet.");
		}
	}
	
	public User logIn(String userName, String password){
		load();
		User account;
		if(userName.equals("")||userName.equals(null)){  
			// makes sure you're not trying to log in without entering username and password;
			return null;
		}
		if(list.containsKey(userName)){
			//userName was found;
			account = list.get(userName);
			if(account.getPassword().equals(password)){
				//password matched;
				return account;
			}
		}
		return null;
	}
	
	public void insert(User account){
		load();
		list.put(account.getUserName(), account);
		save();
	}
	
	public boolean checkUserName(String name){
		load();
		if(list.isEmpty()){
			//if there are no other accounts in the list.
			return true;
		}else{
			//if THERE ARE OTHER accounts.
			if(list.containsKey(name)){ //checks to see if there are other users with the same name;
				list.clear();
				//everything that was loaded is gone. So we are safe to load the file onto the list-
				// again and again and again until you pick a unique userName;
				return false;
			}else{
				return true;
			}
		}
	}

	public User[] alphabeticOrder(User[] array){
		MergeSort sort = new MergeSort(array);
		sort.sort();
		return sort.getArray();
	}
	
	public User[] mostCommonInHobbies(User account){
		User[] array = list.values().toArray(new User[list.size()]);
		int in;
		int out; // first item not sorted to the right of the divide;
		for(out = 0; out< array.length; out++){
			User temp = array[out];
			in = out;
			int tempInt = inCommon(account, temp);
			while(in > 0 && inCommon(account, array[in-1]) <= tempInt){ 
				array[in] = array[in -1];
				in--;
			}
			array[in] = temp;
		}
		return alphabeticOrder(array);
	}
	
	public User[] mostLikedUsers(){
		User[] array = list.values().toArray(new User[list.size()]);
		int in;
		int out; // first item not sorted to the right of the divide;
		for(out = 0; out< array.length; out++){
			User temp = array[out];
			in = out;
			while(in > 0 && array[in-1].getLikes().size() <= temp.getLikes().size()){ 
				array[in] = array[in -1];
				in--;
			}
			array[in] = temp;
		}
		return array;
	}
	
	public User[] mostLikedUsersByHobby(String hobby){
		User[] array = mostLikedUsers();
		ArrayList<User> temp = new ArrayList<>();
		for(int i = 0; i< array.length; i++){
			for(int j = 0; j< array[i].getHobbies().length; j++){
				if(array[i].getHobbies()[j].equals(hobby)){
					temp.add(array[i]);
				}
			}
		}
		User[] newArr =temp.toArray(new User[temp.size()]);
		return newArr;
	}
	
	private int inCommon(User account, User someone){
		int count = 0;
		for(int i = 0; i< account.getHobbies().length; i++){
			for(int j = 0; j< someone.getHobbies().length; j++){
				if(account.getHobbies()[i].equals(someone.getHobbies()[j])){
					count++;
				}
			}
		}
		return count;
	}
	
	public Map<String, User> getList() {
		return list;
	}
	
}
