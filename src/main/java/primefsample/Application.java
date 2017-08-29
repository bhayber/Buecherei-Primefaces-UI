package primefsample;

import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.request.RequestContextListener;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
@ComponentScan
@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Bean
//    public ServletRegistrationBean facesServletRegistration() {
//
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new FacesServlet(), "*.xhtml");
//        servletRegistrationBean.addUrlMappings("/META-INF/");
//        servletRegistrationBean.setLoadOnStartup(1);
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
//        return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public RequestContextListener getRequestContextListener() {
//        return new RequestContextListener();
//    }

}
