package modelo;

import java.sql.Blob;

public class Users {
	private final Integer num_employ;
	private String dni,name,password;
	private Integer sales, type;
	
	
	
	public Users() {
		this.num_employ=null;
		this.dni=null;
		this.name=null;
		this.password=null;
		this.sales=null;
		
		this.type=null;
	}


	public Users(Integer num_employ, String dni, String name, String password, Integer sales, 
			Integer type) {
		super();
		this.num_employ = num_employ;
		this.dni = dni;
		this.name = name;
		this.password = password;
		this.sales = sales;
		
		this.type = type;
	}
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getSales() {
		return sales;
	}


	public void setSales(Integer sales) {
		this.sales = sales;
	}


	


	


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getNum_employ() {
		return num_employ;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Users{"+"num_employ"+num_employ+"DNI"+dni+"name"+name+"password"+password+"sales"+sales+"type"+type+'}';
		
	}
	
	
	

}
