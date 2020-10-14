package edu.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext srvCtx) throws ServletException {
		AnnotationConfigWebApplicationContext appCtx 
				= new AnnotationConfigWebApplicationContext();
		appCtx.register(Config.class);
		appCtx.setServletContext(srvCtx);
		Dynamic srv = srvCtx.addServlet("dispatcher", 
				new DispatcherServlet(appCtx));
		srv.addMapping("/");
		srv.setLoadOnStartup(1);
	}
}
