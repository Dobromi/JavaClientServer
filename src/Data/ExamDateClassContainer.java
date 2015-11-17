package Data;

import java.util.Date;
import java.util.Iterator;


public class ExamDateClassContainer implements Iterable{

	private ExamDateClass front;
	private int size;
	public ExamDateClassContainer(){
		this.front=null;
		size=0;
	}
	
	public void addToContainer(ExamDateClass node){
		if(front==null){
			front=new ExamDateClass(node.getTheClass(),node.getDate(),node.getSubject());
			front.setNext(null);
		}
		else{
			ExamDateClass temp=front;
			ExamDateClass prev=null;
			while(temp.getNext()!=null){
				temp=temp.getNext();
			}
			prev=new  ExamDateClass(node.getTheClass(),node.getDate(),node.getSubject());
			temp.setNext(prev);
			prev.setNext(null);
			
		}
		size++;
	}
	
	public int getSize(){
		return size;
	}
	
	public void print(){
		ExamDateClass temp=front;
		while(temp!=null){
			System.out.println(temp.toString());
			temp=temp.getNext();
		}
	}
	
	@Override
	public Iterator iterator() {
		return new ExamDateClassIterator();
	}
	
	private class ExamDateClassIterator implements Iterator{
		
		private ExamDateClass temp;
		public ExamDateClassIterator(){
			temp=front;
		}
		
		public boolean hasNext() {
			if(temp.getNext()==null)return false;
			return true;
		}
		
		
		
		@Override
		public Object next() {
			ExamDateClass next=temp;
			temp=temp.getNext();
			return next;
		}
		
		public void remove() {
			
		}
		
	}
}