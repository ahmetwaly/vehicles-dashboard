package se.alten.customermanager.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	
	@Id
	private int id ;
	private String Name ;
	private String address ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
