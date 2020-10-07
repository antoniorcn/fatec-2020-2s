package edu.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext ctx) throws ServletException {	
		AnnotationConfigWebApplicationContext appCtx 
			= new AnnotationConfigWebApplicationContext();
		appCtx.register(Config.class);
		appCtx.setServletContext(ctx);
		Dynamic dispatcher = 
				ctx.addServlet("dispatcher", new DispatcherServlet(appCtx));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
	}
}
