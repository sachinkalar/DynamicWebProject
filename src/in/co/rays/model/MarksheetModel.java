package in.co.rays.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.utill.JDBCDataSource;

     public class MarksheetModel {
    	 
    	 public Integer nextPk(MarksheetBean bean) throws Exception {
    		 
    		 int pk =0;
    		 
    		Connection conn = JDBCDataSource.getConnection();   
    		
    	 PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
    			
    		ResultSet rs =	ps.executeQuery();
    		while(rs.next()) {
    			pk = rs.getInt(1);
    		}
    			
    		 
			return pk+1;
    		 
    	 }
	
      public void testAdd(MarksheetBean bean) throws Exception{
		
    	  Connection conn = JDBCDataSource.getConnection();  
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		ps.setInt(1, nextPk(bean));
		ps.setString(2,bean.getName());
		ps.setInt(3, bean.getRollNo());
		ps.setInt(4,bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getPhysics());
		
		int i = ps.executeUpdate();
		
		System.out.println("data inserted "+i);
		

}
      
      public void testUpdate(MarksheetBean bean) throws Exception{
    	  
    	  Connection conn = JDBCDataSource.getConnection();  
    
    PreparedStatement ps = conn.prepareStatement("update marksheet set name = ?,roll_no =?,physics =?,chemistry =?,maths =? where id =?");
    
         ps.setString(1,bean.getName());
         ps.setInt(2, bean.getRollNo());
         ps.setInt(3, bean.getPhysics());
         ps.setInt(4, bean.getChemistry());
         ps.setInt(5,bean.getMaths());
         ps.setInt(6, bean.getId());
         
         int i = ps.executeUpdate();
         
         System.out.println("data updated "+i);
         
      }
      public void testDelete(int id) throws Exception {
    	  
    	  Connection conn = JDBCDataSource.getConnection();  
    	  
    	    PreparedStatement ps = conn.prepareStatement("delete from marksheet where id =?");
    	    
    	    ps.setInt(1, id);
    	    
    	    int i = ps.executeUpdate();
    	    System.out.println("data deleted "+i);
    	    
    	  
      }
      public void testAlter()throws Exception {
    	  
    	  Connection conn = JDBCDataSource.getConnection();  
    	  
  	    PreparedStatement ps = conn.prepareStatement("alter table marksheet add hindi int");
  	    int i = ps.executeUpdate();
  	    
  	    System.out.println("add "+i);
  	      
      }
      public void testLimit() throws Exception{
    	  
    	  Connection conn = JDBCDataSource.getConnection();      	
    	PreparedStatement ps = conn.prepareStatement("select * from marksheet limit 0,5");
    	
    	ResultSet rs = ps.executeQuery();
    	
    	while(rs.next()) {
    
    	System.out.print(" limit  "+rs.getInt(1));
    	System.out.print(rs.getString(2));
    	
    	System.out.println();
    	}
    	
    	
    	
      }
      public MarksheetBean testFindByRoll(int rollNo) throws Exception {
    	  
    	  Connection conn = JDBCDataSource.getConnection();      	
    	  
    	PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll_no = ?");
    	
    	ps.setInt(1, rollNo);
    	
    	ResultSet rs = ps.executeQuery();
    	
    	MarksheetBean bean  = null;
    	
    	while(rs.next()) {
    		bean = new MarksheetBean();
    		
    	bean.setId(rs.getInt(1));
    	bean.setName(rs.getString(2));
    	bean.setRollNo(rs.getInt(3));
    	bean.setPhysics(rs.getInt(4));
    	bean.setChemistry(rs.getInt(5));
    	bean.setMaths(rs.getInt(6));
    		
    	}
		return bean;
      }
      public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception{
    	  
    	  Connection conn = JDBCDataSource.getConnection();      	
    	  
    	StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");
    	
    	if(bean != null) {
    		if(bean.getName() != null) {
    		sql.append(" and name like '"+bean.getName()+"%'");
    		}
    		
    		if(bean.getId() != 0 && bean.getId()>0) {
    			sql.append(" and id = " + bean.getId() + "");
    		}
    		
    		if(bean.getRollNo() != 0) { 
    			sql.append(" and roll_no = " + bean.getRollNo() + "");
    		
    		}
    		
    		if(pageSize > 0) {
    			
    			pageNo = (pageNo-1)*pageSize;
    			sql.append(" limit " + pageNo + "," + pageSize);
    			
    		}
    		
    		System.out.println(sql.toString());
    		
    	}
    	
    	
    	PreparedStatement ps = conn.prepareStatement(sql.toString());
    	
    	ResultSet rs = ps.executeQuery();
    	
    	List list = new ArrayList();
    	
    	while(rs.next()) {
    		 bean = new MarksheetBean();
    		bean.setId(rs.getInt(1));
        	bean.setName(rs.getString(2));
        	bean.setRollNo(rs.getInt(3));
        	bean.setPhysics(rs.getInt(4));
        	bean.setChemistry(rs.getInt(5));
        	bean.setMaths(rs.getInt(6));
        		
        	list.add(bean);
    	}
    	
		return list;
    	  
      }
    	
    	  
    	  
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
