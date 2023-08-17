package in.co.rays.test;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {
	
	public static void main(String[] args) throws Exception{
		
		testAdd();
		//testUpdate();
		//testDelete();
		//testAlter();
		//testLimit();
		//testFindByRoll();
		//search();
	}
	private static void search() throws Exception {
		MarksheetBean bean = new  MarksheetBean();
		//bean.setName("r");
		//bean.setId(2);
		//bean.setRollNo(103);
		
		MarksheetModel model = new MarksheetModel();
		
	     List list =	model.search(bean,2,2);
	
         Iterator it = list.iterator();
         
          while(it.hasNext()) {
	   
	           bean = (MarksheetBean) it.next();
			   System.out.print("\t"+bean.getId());
			   System.out.print("\t"+bean.getName());
			   System.out.print("\t"+bean.getRollNo());
			   System.out.print("\t"+bean.getPhysics());
			   System.out.print("\t"+bean.getChemistry());
			   System.out.println("\t"+bean.getMaths());
	   
   }
	
	
	
	
		
	}
	public static void testFindByRoll() throws Exception {
		MarksheetModel model = new MarksheetModel();
	MarksheetBean bean = model.testFindByRoll(12);
	
	MarksheetBean rollNo = bean;
	
	if(rollNo != null)
	{
	System.out.println(bean.getId());
	System.out.println(bean.getName());
	System.out.println(bean.getRollNo());
	System.out.println(bean.getPhysics());
	System.out.println(bean.getChemistry());
	System.out.println(bean.getMaths());
	}
	else {
		System.out.println("roll no does not exist....");
	}
		
	}
	public static void testAdd() throws Exception{
		MarksheetBean bean = new MarksheetBean();

		bean.setName("seema");
		bean.setRollNo(102);
		bean.setPhysics(54);
		bean.setChemistry(87);
		bean.setMaths(99);
		
		MarksheetModel model = new MarksheetModel();
		model.testAdd(bean);
		
	}
	
	public static void testUpdate() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		bean.setName("sanju");
		bean.setRollNo(103);
		bean.setPhysics(98);
		bean.setChemistry(99);
		bean.setMaths(99);
		bean.setId(2);
		
		MarksheetModel model = new MarksheetModel() ;
		
		model.testUpdate(bean);
		
	}
	public static void testDelete()throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.testDelete(7);
		
	}
	public static void testAlter() throws Exception{
		
		MarksheetModel model = new MarksheetModel();
		model.testAlter();
	}
	public static void testLimit() throws Exception{
		
		MarksheetModel model = new MarksheetModel ();
		model.testLimit();
	}
}



