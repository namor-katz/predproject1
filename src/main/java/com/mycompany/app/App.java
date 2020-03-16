package com.mycompany.app;

import com.mycompany.app.Service.UserService;
import com.mycompany.app.model.User;
import com.mycompany.app.servlets.UserServlet;
import com.mycompany.app.utils.Utils;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
//import javax.servlet.ServletContext;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoSuchAlgorithmException, Exception {
        System.out.println( "Hello World!" );
//        User user = new User("vash", "strong passfort");
//        System.out.println(user.getHash_password() + "  я хэшированный пароль");

        UserServlet userServlet = new UserServlet();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(userServlet), "/register");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        server.join();

//        UserService userService = new UserService();
//        userService.createTable();
//        userService.addUser(user.getName(), user.getHash_password());
    }
}
