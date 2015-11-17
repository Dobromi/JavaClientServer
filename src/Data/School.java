package Data;

import java.util.ArrayList;


public class School {
	public String SchoolName;
	private int numberOfClassesRequired;
	private static String[][] educationList={
		EducationFactory.getEducation("ICT"),
		EducationFactory.getEducation("Marketing")
	};
	
	
	public School(String name){
		this.SchoolName=name;
		numberOfClassesRequired=0;
	}
	
	public int gerNumberOfClassesRequired(){
		for(int i=0;i<educationList.length;i++){
			for(int j=1;j<educationList[i].length;j++){
				numberOfClassesRequired++;
			}
		}
		return numberOfClassesRequired;
	}
	
	public String[] getAllSubjects(){
		ArrayList<String> strArr = new ArrayList<>();
		for(int i=0;i<educationList.length;i++){
			for(int j=1;j<educationList[i].length;j++){
				strArr.add(educationList[i][j]);
			}
		}
		String[] arr=strArr.toArray(new String[strArr.size()]);
		return arr;
	}
	
	public String toString(){
		String result="";
		result+="School name " + this.SchoolName + "\n";
		for(int i=0;i<educationList.length;i++){
			result+=educationList[i][0] + ":";
			for(int j=1;j<educationList[i].length;j++){
				result+=educationList[i][j] + " ";
			}
			result+="\n";
		}
		return result;
	}
}