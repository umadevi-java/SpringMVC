package com.in28minutes.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.todo.TodoService;
import com.in28minutes.todo.Todo;


@Controller
public class TodoController {
	
	@Autowired
	TodoService usrservice ;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	
@RequestMapping(value = "/listtodos",method = RequestMethod.GET)
public String showTodoListPage(ModelMap model )
	{
	//String user = (String) model.get("name");
		model.put("todos", usrservice.retrieveTodos(retrieveLoggedInUser()));
		return "list-todos";
		
	}


	private String retrieveLoggedInUser() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

@RequestMapping(value = "/add-todo",method = RequestMethod.GET)
public String callAddTodoPage(ModelMap model,Todo todo)
	{
		model.addAttribute("todo",new Todo() );
		return "addtodo";
		
	}

@RequestMapping(value = "/add-todo",method = RequestMethod.POST)
public String addTodoListPage(ModelMap model,@Valid Todo todo,BindingResult result)
	{
	if(result.hasErrors()) {
		return "addtodo";
	}
	usrservice.addTodo( (String) model.get("name"),todo.getDesc(),new Date(),false );
	model.clear();
	return "redirect:listtodos";
		
	}

@RequestMapping(value = "/update-todo",method = RequestMethod.GET)
public String callListPage(ModelMap model,@RequestParam int id)
	{
	
	Todo todo = usrservice.retrieveTodo(id);
	model.addAttribute("todo",todo);
	
	return "addtodo";
		
	}


@RequestMapping(value = "/update-todo",method = RequestMethod.POST)
public String updTodoListPage(ModelMap model,@Valid Todo todo,BindingResult result)
{
	if(result.hasErrors()) {
		return "addtodo";
	}
	System.out.println("+++b4 call");
	usrservice.updateTodo(todo);
	model.clear();
	return "redirect:listtodos";
		
}

@RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
public String delTodoListPage(ModelMap model,@RequestParam int id)
	{
	model.clear();	
	usrservice.deleteTodo(id);
	return "redirect:listtodos";
		
	}


}
