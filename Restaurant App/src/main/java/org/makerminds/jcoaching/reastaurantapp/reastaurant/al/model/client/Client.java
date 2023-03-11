package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.client;

public class Client {
	private String name;
    private String phoneNr;
	
    public Client(String name, String phoneNr)  {
	   
	   this.name = name;
	   this.phoneNr = phoneNr;
   }
    
    // per cdo te dhene bejme getteers dhe setters, ne cdo klase, per cdo te dhene, kur kemi "private"
    
   public String getName() {
	
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNr() {
		return phoneNr;
	}
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	

}
