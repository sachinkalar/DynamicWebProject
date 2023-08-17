<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marksheet</title>
</head>
<body>
	<form action="MarksheetCtl" method="post">
		<table align="center" border=1
			style="width: 40% margin: 10%; padding: 10%">

			<tr>
				<th>name</th>
				<td><input ="text" name="name"></td>
			</tr>
			<tr>
				<th>rollNo</th>
				<td><input type="text" name="rollNo"></td>
			</tr>
			<tr>
				<th>physics</th>
				<td><input type="text" name="physics"></td>
			</tr>
			<tr>
				<th>chemistry</th>
				<td><input type="text" name="chemistry"></td>
			</tr>
			<tr>
				<th>maths</th>
				<td><input type="text" name="maths"></td>
			</tr>
			<tr>

				<td colspan="4"><input type="submit" value="SingUp"></td>
			</tr>
		</table>
	</form>

</body>
</html>