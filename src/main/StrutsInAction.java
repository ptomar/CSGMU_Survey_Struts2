package main;

import java.io.IOException;

import javax.servlet.ServletException;
import beans.DataBean;
import beans.StudentBean;
import processor.DataProcessor;
import processor.StudentDAO;

public class StrutsInAction {
	
	private String name;
	private String email;
	private String address;
	private String zip;
	private String city;
	private String state;
	private String cellphone;
	private String url;
	private String dos;
	private String month;
	private String year;
	private String id ;
	private String data;
	private String camp;
	private String university;
	private String recommend;
	private String comments;
	
	private double Mean, SD;
	
	private String[] sidList;
	private StudentBean studentBean;
		
	public String getData() {
		return data;
	}
	public void setData(String sid) {
		this.data = sid;
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDos() {
		return dos;
	}
	public void setDos(String dos) {
		this.dos=dos;
	}
	public String getCamp() {
		return camp;
	}
	public void setCamp(String camp) {
		this.camp = camp;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String[] getSidList() {
		return sidList;
	}
	public void setSidList(String[] sidList) {
		this.sidList = sidList;
	}

	public double getMean() {
		return Mean;
	}
	public void setMean(double mean) {
		Mean = mean;
	}
	public double getSD() {
		return SD;
	}
	public void setSD(double sd) {
		SD = sd;
	}
	public StudentBean getStudentBean() {
		return studentBean;
	}
	public void setStudentBean(StudentBean studentBean) {
		this.studentBean = studentBean;
	}
	
	public String execute() throws IOException, ServletException{

		StudentDAO dao_object= new StudentDAO();
		
		//call to data save function 
		dao_object.datasave(id,name,address,
							zip,city,state,
							cellphone,email,url,
							dos,camp,university,
							comments,month,year,
							recommend,data);
		
		DataProcessor data_object=new DataProcessor();
		//Mean calculation
		double mean=data_object.Mean(data); 
		//standard deviation calculation
		double sd=data_object.StandardDeviation(data, mean); 
		
		Mean = mean;
		SD = sd;
		
		DataBean bean_object=new DataBean();
		
		bean_object.setMean(mean);
		bean_object.setStandardDeviation(sd);
		
		String listid=dao_object.idsRetreiveFromDb();
		
		sidList = listid.split(",");
		if (bean_object.getMean() >= 90)
			return  "winnerjsp";
		else
			return  "simplejsp"; 
	}
	
	
	
	//function that pop up the details of student by making a call to retrive function which retrive all details from database
	public String popstudentdetails(){
		StudentDAO studentObject = new StudentDAO();
		studentBean = studentObject.retrieveForm(id);
	
			return "found";
	}
	
}
