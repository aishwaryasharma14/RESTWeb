package com.arushi.jaxrs;

import java.util.ArrayList;  
import java.util.List;  
import java.io.IOException;
  
import javax.ws.rs.GET;  
import javax.ws.rs.HeaderParam;  
import javax.ws.rs.POST;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType; 
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;


import com.arushi.bean.Country;
 
@Path("/countries")  
public class CountryRestService {  
	List<Country> listOfCountries = new ArrayList<Country>(); ;
   
    @GET  
    @Produces(MediaType.APPLICATION_JSON)  
 public List<Country> getCountries()  
 {  
  
  listOfCountries=createCountryList();  
  return listOfCountries;  
 }  
  
 @GET  
    @Path("{id: \\d+}")  
    @Produces(MediaType.APPLICATION_JSON)  
 public Country getCountryById(@PathParam("id") int id)  
 {  
  //listOfCountries = new ArrayList<Country>();  
  listOfCountries=createCountryList();  
  
  for (Country country: listOfCountries) {  
   if(country.getId()==id)  
    return country;  
  }  
    
  return null;  
 }
 
 
  
// Utiliy method to create country list.  
 public List<Country> createCountryList()  
 {  
  Country indiaCountry=new Country(1, "India");  
  Country chinaCountry=new Country(4, "China");  
  Country nepalCountry=new Country(3, "Nepal");  
  Country bhutanCountry=new Country(2, "Bhutan");  
  
  //listOfCountries = new ArrayList<Country>();  
  listOfCountries.add(indiaCountry);  
  listOfCountries.add(chinaCountry);  
  listOfCountries.add(nepalCountry);  
  listOfCountries.add(bhutanCountry);  
  return listOfCountries;  
 }  
 
 @POST
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.TEXT_PLAIN)
 @Path("/addCountry")
 public String addCountry(@HeaderParam("id") int id,
    @HeaderParam("name") String name,
    @Context HttpServletResponse servletResponse) throws IOException{
	 Country newCountry=new Country(id,name); 
	 System.out.println(name);
	 //listOfCountries = new ArrayList<Country>();  
	  listOfCountries.add(newCountry);  
	  return "new country is added to the list successfully!";
 }
 
 
 


}


