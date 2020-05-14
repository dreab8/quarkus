package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.bytecode.enhance.spi.interceptor.EnhancementAsProxyLazinessInterceptor;
import org.hibernate.engine.spi.PersistentAttributeInterceptable;

import org.acme.entities.Content;
import org.acme.entities.Folder;

@Path("/folder")
public class FolderEndPoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Folder f = Folder.findById(1L);
        Content content = f.content;
        final PersistentAttributeInterceptable interceptable = (PersistentAttributeInterceptable) content;
        final EnhancementAsProxyLazinessInterceptor interceptor = (EnhancementAsProxyLazinessInterceptor) interceptable.$$_hibernate_getInterceptor();
        return "name: " + content.name;
    }
}