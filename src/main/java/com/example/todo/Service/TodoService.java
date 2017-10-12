package com.example.todo.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.Todo;
import com.example.todo.Dao.TodoDaoImpl;


@Service
public class TodoService {
	
	
	
	TodoDaoImpl daoImpl =new TodoDaoImpl();
	
	
	
	Todo todo= new Todo();
	
	
	/**
	 * This method will insert the row
	 * @param item
	 * @throws SQLException
	 */
	public void addTodo(String item) throws SQLException {
		daoImpl.insertTodo(item, 0);
		//todo.setItem(item);
	}
	
	/**
	 * This method will delete the row 
	 * @param item
	 * @throws SQLException
	 */
	public void deleteTodo(String item) throws SQLException {
		daoImpl.deleteTodo(item);
	}

	/**
	 * This method will get the wor
	 * @param item
	 * @throws SQLException
	 */
	public void completeTodo(String item) throws SQLException {
		daoImpl.completeTodo(item);
	}
	
	
	/**
	 * 
	 * this method will retrive coplete list of rows 
	 * @return
	 * @throws SQLException
	 */
	public List<Todo> retrieveTodosAll() throws SQLException{
		
		List<Todo> filteredTodos = new ArrayList<Todo>();
		filteredTodos = daoImpl.retriveAll();
		return filteredTodos;
	}
	
	/**
	 * this method will retrived list based on flag
	 * @param flag
	 * @return
	 * @throws SQLException
	 */
	public List<Todo> retrieveTodosBasedonFlag(int flag) throws SQLException{
		List<Todo> filteredTodos = new ArrayList<Todo>();
		filteredTodos = daoImpl.retriveAllForFlag(flag);
		return filteredTodos;
	}
	
	/**
	 * THis method will retrive the row
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public Todo showTodo(String item) throws SQLException {
		todo=daoImpl.retriveTodo(item, 0);
		todo.setFlag(0);
		todo.setItem(item);
		return todo;
		
		
	}
	
	/**
	 * This method will update the row
	 * @param desc
	 * @param olditem
	 * @throws SQLException
	 */
	public void update(String desc,String olditem) throws SQLException {
		
		daoImpl.updateTodo(desc,olditem);
		//todo.setItem(desc);
	}
	
	/**
	 * This method will update the flag
	 * @param item
	 * @throws SQLException
	 */
	public void updateFlag(String item) throws SQLException {
		
		daoImpl.updateFlag(item);
		//todo.setItem(desc);
	}
	
		
		
}
