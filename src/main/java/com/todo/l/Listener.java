package com.todo.l;

import java.util.ArrayList;
import java.util.List;
import com.todo.entity.Todo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		System.out.println(" Created Context...");
		List<Todo> list = new ArrayList<Todo>();
		ServletContext context = sce.getServletContext();
		context.setAttribute("list", list);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
