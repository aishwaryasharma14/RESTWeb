package org.ash.xor.w;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private String name;
	private int id;
	
	public Message(){
		
	}
	
	public Message(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
