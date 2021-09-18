package com.todo.cntrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.todo.entity.Todo;

@Controller
public class HomeController {

	@Autowired
	ServletContext context;
	
	@RequestMapping("/home")
	public String home(Model model) {

		model.addAttribute("page","home");
		List<Todo> list = (List<Todo>)context.getAttribute("list");
		model.addAttribute("todos",list);


		return "home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model model) {

		Todo t=new Todo();
		model.addAttribute("page","add");
        model.addAttribute("todo", t);
		return "home";
	}
	
	/*
	 * @RequestMapping("/view") public String viewTodo(Model model) {
	 * 
	 * model.addAttribute("page","view");
	 * 
	 * return "home"; }
	 */
	
	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t,Model model) {
		System.out.println(t);
		
		t.setTodoDate(new Date());
		
	List<Todo> list = (List<Todo>)context.getAttribute("list");
	list.add(t);
	model.addAttribute("msg","Successfully Added...");
		
		return "home";
	}

}
