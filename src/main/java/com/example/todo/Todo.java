package com.example.todo;


import javax.validation.constraints.Size;


public class Todo {
	@Size(min=3 ,message = "please enter valid list ")
	
	private String item;
	
	private int id;
	 
	private int flag;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int isFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	

	

	@Override
	public String toString() {
		return "Todo [item=" + item + ", id=" + id + ", flag=" + flag + "]";
	}

	public Todo(int id,String item,int flag) {
		super();
		this.id = id;
		this.item = item;
		this.flag = flag;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (flag != other.flag)
			return false;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	public Todo() {
		
	}

}
