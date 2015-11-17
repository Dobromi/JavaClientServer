package Data;



public class EducationFactory {
	
	public static String[] getEducation(String name){
		
		if(name.equals("ICT")){
			ICT obj=new ICT();
			return obj.getEducations();
		}
		else if(name.equals("Marketing")){
			Marketing obj=new Marketing();
			return obj.getEducations();
		}
		return null;
	}
}