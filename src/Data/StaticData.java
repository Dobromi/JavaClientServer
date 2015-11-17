package Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class StaticData {
	
	private ExamDateClassContainer cont;
	
	
	public void LoadData() {
		School sch1=new School("Via");
		ArrayList<Class> classes=new ArrayList<>();
		int lengt=sch1.gerNumberOfClassesRequired();
		for(int i=0;i<lengt;i++){
			String name="Class " + (i+1);
			classes.add(new Class(name));
		}
		
		boolean []usedSubjects=new boolean[lengt];
		boolean []usedClasses=new boolean[lengt];
		String []subjArr=sch1.getAllSubjects();
		Random randInt=new Random();
		int c1=0;int c2=0;
		Date []dateOfExams={new Date(2016,0,5),new Date(2016,0,8),new Date(2016,0,11),new Date(2016,0,15),new Date(2016,0,20),new Date(2016,0,25)};
		ArrayList<ExamDateClass> listWithExamx=new ArrayList<>();
		cont=new ExamDateClassContainer();
		while(true){
			if(c1==lengt && c2==lengt)break;
			int r1=randInt.nextInt(lengt);
			int r2=randInt.nextInt(lengt);
			if(!usedSubjects[r1] && !usedClasses[r2]){
				usedSubjects[r1]=true;usedClasses[r2]=true;
				ExamDateClass obj=new ExamDateClass(classes.get(r2), dateOfExams[c1], subjArr[r1]);
				cont.addToContainer(obj);
				listWithExamx.add(obj);
				c1++;c2++;
			}
			
		}
		
//		Iterator it=cont.iterator();
//		while(it.hasNext()){
//			ExamDateClass obj=(ExamDateClass) it.next();
//			System.out.println(obj.toString());
//		}
		
	}
	
	public ExamDateClassContainer getCont(){
		return cont;
	}
}