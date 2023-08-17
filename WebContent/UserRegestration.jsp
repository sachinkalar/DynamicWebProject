<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action ="UserCtl" method ="post">
     <table border=1 style="width:46%; margin: 20 auto; ">
          <tr>
              <th> firstNmae :</th>
              <td> <Input type ="text" name="firstName"></td>
              <th></th>
              <th> lastName :</th>
              <td> <input type="text" name="lastName"> </td>
          </tr>
         
           <tr>
          <th> loginId :</th>
          <td colspan= "4"> <input type="text" name="loginId">   </td>
          </tr>
           <tr>
          <th> password :</th>
          <td colspan="4"> <input type="password" name="password">   </td>
          </tr>
           <tr>
          <th> dob :</th>
          <td colspan="4"> <input type="date" name="dob">   </td>
          </tr>
           <tr>
          <th> address :</th>
          <td colspan="4"> <input type="text" name="address">   </td>
          </tr>
           <tr>
          
          <td colspan="4"> <input type="submit" value="singup">   </td>
          </tr>
     </table>
   </form>
</body>
</html>