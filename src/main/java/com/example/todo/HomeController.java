package com.example.todo;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.Service.TodoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	TodoService service;
	
	
	
	/**
	 * THis method will display the various list on page 
	 * @param locale
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String retriveList(Locale locale, ModelMap model) throws SQLException{
		int flag=0;
		int cflag=1;
		model.addAttribute("todos",service.retrieveTodosAll());
		model.addAttribute("todosd",service.retrieveTodosBasedonFlag(cflag));
		model.addAttribute("todosp",service.retrieveTodosBasedonFlag(flag));
		return "list-todos";
	}
	
	/**
	 * This method will take the user to add/update page 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)    
	public String showTodo(ModelMap model) {
		model.addAttribute("todo", new Todo(1,"",0));
   	return "todo";                                              
	} 
	
	/**
	 * This method will add the row
	 * @param model
	 * @param todo
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)    
	public String addTodo(ModelMap model, @Valid Todo todo ,BindingResult result) throws SQLException {  
		if(result.hasErrors()) {
			return "todo";
		}
	service.addTodo(todo.getItem());
   	return "redirect:list-todos";                                              
	}   
	
	/**
	 * This method will delete the row
	 * @param model
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)    
	public String deleteTodo (ModelMap model, @RequestParam("todoitem") String item)throws SQLException { 
		System.out.println("item is " +  item);
		service.deleteTodo(item);
		return "redirect:list-todos";                                                
	} 
	
	/**
	 * This method will update the list with completed
	 * @param model
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/completed-todo", method = RequestMethod.GET)    
	public String completeTodo (ModelMap model, @RequestParam("completeitem") String item)throws SQLException { 
		System.out.println("deeps item is " +  item);
		service.updateFlag(item);
		return "redirect:list-todos";                                                
	} 
	
	/**
	 * THis method will take user to update page
	 * @param model
	 * @param item
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)    
	public String showupdateTodo (ModelMap model, @RequestParam("updateitem") String item) throws Exception { 
		System.out.println("item is " +  item);
		Todo todo=service.showTodo(item);
		model.addAttribute("todo", todo);
		
		return "todo";                                                
	} 
	
	/**
	 * This method will update the row
	 * @param model
	 * @param todo
	 * @param result
	 * @param olditem
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)    
	public String updateTodo(ModelMap model,  @Valid Todo todo ,BindingResult result ,@RequestParam("updateitem") String olditem) throws Exception {  
		if(result.hasErrors()) {
			return "/todo";
		}
	service.update(todo.getItem(),olditem);
   	return "redirect:/list-todos";                                              
	}  
}                                                                     
                                                                          