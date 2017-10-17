package com.examples.rest.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import javax.ws.rs.core.Application;

import com.examples.rest.resources.ArtistResource;

@ApplicationPath("/rest")
public class RestApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ArtistResource.class);
		return classes;
	}
	
}
