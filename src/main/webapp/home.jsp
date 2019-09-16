<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/goblal1.css">
<script src="js/bootstrap.min.js" ></script>
<script src="js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript">
function openForm(){
document.getElementById("myform").style.display="block";
}
function closeForm(){
document.getElementById("myform").style.display="none";
}
</script>
<title>Home</title>
</head>
<body>
<div class="popup bg">
<div class="btn">
<button type="button" class="btnb btn-info btn-xs" onclick="openForm()">Log In</button>
</div>
<div class="form-popup" id="myform">
<form class="form-container">
 <h1>Log In Here</h1>
    <label for="Email1">Email address</label>
    <input type="email" class="form-control" id="Email1" placeholder="Email">
    <label for="Password1">Password</label>
    <input type="password" class="form-control" id="Password1" placeholder="Password">
    <label>
     <a  href="login3.jsp" class="btnh btn-link btn-xs active" role="button">Forgot Password ? </a>
    </label>
  <button type="submit" class="btns btn-success btn-lg btn-block ">Submit</button>
<button type="button" class="btnc btn-danger btn-lg btn-block " onclick="closeForm()">Cancel</button>
</form>
</div>
</div>
</body>
</html>