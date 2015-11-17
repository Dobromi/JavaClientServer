package Data;

import java.util.Date;


public class ExamDateClass {

	private Class clasName;
	private Date dateOfExam;
	private String subject;
	private ExamDateClass next;
	
	public ExamDateClass(Class c,Date d,String s){
		clasName=c;
		dateOfExam=d;
		subject=s;
	}
	
	public Date getDate(){
		return dateOfExam;
	}
	
	public Class getTheClass(){
		return clasName;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public void setNext(ExamDateClass nextNode){
		next=nextNode;
	}
	
	public ExamDateClass getNext(){
		return next;
	}
	
	public String toString(){
		return "Class : " + clasName.getName() + " have exam on date " + dateOfExam.getDate() + "/" + dateOfExam.getMonth() + "/" + dateOfExam.getYear() + " on subject : " + subject;
	}
}