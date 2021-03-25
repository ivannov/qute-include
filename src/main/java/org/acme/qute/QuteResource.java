package org.acme.qute;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.CheckedTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class QuteResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance test(TemplateContext context);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return Templates.test(new TemplateContext());
    }

}
