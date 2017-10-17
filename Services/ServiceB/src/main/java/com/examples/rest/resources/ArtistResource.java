package com.examples.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.examples.rest.model.Artist;
import com.google.gson.Gson;

@Path("/artist")
public class ArtistResource {

	@GET
	@Path("/html")
	@Produces("text/html")
	public String getHtml() {
		return "<html><body><h1>Hello, People!</h1><p>Search for artist with urls on this service</p></body></html>";
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")//text/plain
	public Response allArtist() {//List<Artist>
	
		String output = "Here are all the artist in the database";
		List<Artist> artists = listOfAll();
		Gson gson = new Gson();
		String json = gson.toJson(artists);
//		return Response.status(200)/*.entity(output+" "+artists.toString())*/.entity(artists).build();
		return Response.status(200).entity(output+" "+json).build();	
		}

	@GET
	@Path("/{id}")
	@Produces("application/json")//text/plain
	public Response anArtist(@PathParam("id") int id) {
		String output = "Here is an artist";

		for(Artist a: listOfAll()) {
			if(a.getId() == (long) id) {
				Gson gson = new Gson();
				String json = gson.toJson(a);
				return Response.status(200).entity(output+" "+json).build();
			}
		}
		output = "Can not find an artist with id "+id;

		return Response.status(Status.CONFLICT).entity(output).build();

	}

	@GET
	@Path("/{name}{id}")
	@Produces("application/json")//text/plain
	public Response getUserFromUN(@PathParam("name") String name, @PathParam("id") int id) {
		String output = "Hello, " + name;

		Artist a = new Artist();
		a.setId(id);
		a.setName(name);
		a.setNumberOfPieces(10);
		a.setType("misc");
		
		Gson gson = new Gson();
		String json = gson.toJson(a);
		return Response.status(200).entity(output+" "+json/*a.toString()*/).build();
	}

	@POST
	@Path("/msg")
	@Consumes("application/x-www-form-urlencoded")
	public void postText(@FormParam("message") String message) {
		System.out.println(message);
	}
	
	private List<Artist> listOfAll() {
		List<Artist> artists = new ArrayList<Artist>();

		Artist a = new Artist();
		a.setId(0L);
		a.setName("Michelangelo");
		a.setNumberOfPieces(10);
		a.setType("sculptor");
		artists.add(a);

		Artist b = new Artist();
		b.setId(1L);
		b.setName("Angel");
		b.setNumberOfPieces(11);
		b.setType("singer");
		artists.add(b);

		Artist c = new Artist();
		c.setId(2L);
		c.setName("Beck");
		c.setNumberOfPieces(5);
		c.setType("pianist");
		artists.add(c);

		Artist d = new Artist();
		d.setId(3L);
		d.setName("Xavi");
		d.setNumberOfPieces(1);
		d.setType("dj");
		artists.add(d);

		Artist e = new Artist();
		e.setId(4L);
		e.setName("Picaso Jr.");
		e.setNumberOfPieces(2);
		e.setType("painter");
		artists.add(e);

		return artists;
	}

}
