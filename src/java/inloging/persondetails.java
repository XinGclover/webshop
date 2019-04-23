package inloging;

import java.util.Date;

public class persondetails{
	String name;
	String fname;
	String paddress;
	String email;
	Date dob;
	Long phoneno;
	Long mobileno;

	public persondetails(){}

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

}