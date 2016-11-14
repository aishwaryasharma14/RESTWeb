package org.ash.xor.w;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageProvider {
	List l = new ArrayList();
	HashMap<Integer, String> hm = new HashMap<>();
	
	public List<Message> getallmsgs(){
		Message m = new Message("ash",1);
		Message m1 = new Message("neu",2);
		
		l.add(m);
		l.add(m1);
		return l;
	}
	
	public void addmsg(Message m){
		l.add(m);
	}
	
	public String showName(int id){
		getallmsgs();
		String s = " ";
		for(int i = 0 ; i < l.size() ; i++){
			Object g = l.get(i);
			Message d = (Message)g;
			if(d.getId()==id){
				s = d.getName();
				break;
			}
			else
				s = "None";
		}
		return s;
	}
	
	@SuppressWarnings("null")
	public Message showobj(int id){
		getallmsgs();
		Message s = new Message();
		String n = null;
		int idnum = 0;
		for(int i = 0 ; i < l.size() ; i++){
			Object g = l.get(i);
			Message d = (Message)g;
			if(d.getId()==id){
				n = d.getName();
				idnum = d.getId();
				break;
			}
			else
				n = "null";
				idnum = 0 ;
		}
		s.setId(idnum);
		s.setName(n);
		return s;
	}
	
	public int showId(String name){
		getallmsgs();
		int s = 9999;
		for(int i = 0 ; i < l.size() ; i++){
			Object g = l.get(i);
			Message d = (Message)g;
			if(d.getName().equals(name)){
				s = d.getId();
				break;
			}
			else
				s = 99999999;
		}
		return s;
	}
	
	public List<Message> deletemessage(int id){
		getallmsgs();
		
		for(int i = 0 ; i < l.size() ; i++){
			Object g = l.get(i);
			Message d = (Message)g;
			if(d.getId()==id){
				l.remove(i);
			}
		}
		return l;
	}
	
	
	public List<Message> updatemessage(int id , Message m){
		getallmsgs();
		for(int i = 0 ; i < l.size() ; i++){
			System.out.println(i + "i");
			Object g = l.get(i);
			Message d = (Message)g;
			if(d.getId()==id){
				l.set(i, m);
			}
		}
		return l;
	}
}


