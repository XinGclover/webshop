/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author carlo
 */
@Named(value = "loginController")
@RequestScoped
public class BeanController implements Serializable{

    /**
     * Creates a new instance of LoginController
     */
    public BeanController() {
             
        
    }
    	private String name;
	private String fname;
	private String paddress;
	private String email;
	private Date dob;
	private Long phoneno;
	private Long mobileno;
        private String pwd; 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getFname(){
		return fname;
	}

	public void setFname(String fname){
		this.fname = fname;

	}

	public String getPaddress(){
		return paddress;
	}

	public void setPaddress(String paddress){
		this.paddress = paddress;
	}

	public String getSex(){
		return email;	
	}

	public void setSex(String sex){
		this.email = sex;
	}

	public Date getDob(){
		return dob;
	}

	public void setDob(Date dob){
		this.dob = dob;
	}

	public Long getPhoneno(){
		return phoneno;
	}

	public void setPhoneno(Long phoneno){
		this.phoneno = phoneno;
	}

	public Long getMobileno(){
		return mobileno;
	}

	public void setMobileno(Long mobileno){
		this.mobileno = mobileno;
	}

        
        //checks the input fields against the database and return a bool simple login
        public void checkValiduser(){
            
            
        }
        
        
        //Registers the new user to the database 
        public void registerNewUser(){
            
            
            
            
            
        }
        
        
        
        
        
        
        
}
