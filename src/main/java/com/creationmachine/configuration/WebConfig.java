package com.creationmachine.configuration;

// import java.sql.SQLException;

// import javax.servlet.ServletContext;
// import javax.servlet.ServletRegistration;

// import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.creationmachine.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
    
    //private static Server h2Server = null;
    //private static Server h2WebServer = null;

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = 
                new InternalResourceViewResolver();
        resolver.setPrefix("/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    /**
     *
     * Once it's initialized, you can connect with a JDBC client with
     * the URL 'jdbc:h2:tcp://127.0.1.1:9092/mem:DBNAME',
     * or can be accessed with the web console at 'http://localhost:8082',
     * and the URL JDBC 'jdbc:h2:mem:DBNAME'.
     * @throws SQLException 
     *
     */
    /*
    @Bean(initMethod="start", destroyMethod="stop")
    public Server initH2TCPServer(ServletContext servletContext) throws SQLException {
        h2Server = Server.createTcpServer( "-tcp", "-tcpAllowOthers", "-tcpPort", "9092" );
     if(h2Server != null) {
            //Always return the H2Console...
            initH2Console( servletContext );
     }
        return h2Server;
    }
    
    public void initH2Console( ServletContext servletContext ) {
        ServletRegistration.Dynamic h2WebServer = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet() );
        h2WebServer.addMapping( "/console/*" );
    }
    */


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bower_components/**", "/js/**", "/css/**", "/img/**", "/fonts/**")
                .addResourceLocations("classpath:/static/bower_components/", "classpath:/js/", "classpath:/css/", "classpath:/img/", "classpath:/static/bower_components/bootstrap/fonts/**")
                .setCachePeriod(315569126);
    }


}