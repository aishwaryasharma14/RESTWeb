package org.ash.xor.w;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	 MessageProvider mp = new MessageProvider();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allmessages")
    public List<Message> getallmessages(){
    	return mp.getallmsgs();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/name")
    public String getvalue(Message m){
    	return m.getName() ;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/showname/{id}")
    public String getid(@PathParam("id") int id){
    	return mp.showName(id) ;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/showId/{name}")
    public int getid(@PathParam("name") String Name){
    	return mp.showId(Name) ;
    }
   
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public List<Message> addmessage(Message m){
    	mp.addmsg(m);
    	return mp.getallmsgs();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/{id}")
    public List<Message> update(@PathParam("id") int id, Message m){
    	return mp.updatemessage(id , m);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{msgid}")
    public List<Message> deletemsg(@PathParam("msgid") int id){
    	return mp.deletemessage(id); 
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/json2java")
    public Message JsonToJava(Message m){
    	ObjectMapper mapper = new ObjectMapper();
    	Message mes;
    	int req = m.getId();
    	ObjectMapper mpr = new ObjectMapper();
		Message msgs = mp.showobj(req);
		try {
			//mapper.writeValue(new File("D:\\Message.json"), msgs);
			String jsonInString = mapper.writeValueAsString(msgs);
			System.out.println(jsonInString);
			if(jsonInString.contains("id")){
				System.out.println("Yes!!");
			}
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return mp.showobj(req);
    	
		/*try {
			mes = mapper.readValue(req, Message.class);
			System.out.println(mes.getId());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
    	
    }
}
