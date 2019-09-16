<%
  String res=(String)request.getAttribute("msg");
  String emp_id=(String)request.getAttribute("empid");
  String name=(String)request.getAttribute("name");
  String mob=(String)request.getAttribute("mobile no");
  String join_date=(String)request.getAttribute("joining date");
  String Dob=(String)request.getAttribute("birth date");
  String degn=(String)request.getAttribute("degn");
  
 %>
<html ng-app="demoApp">
<body onLoad='isReloading()'>
<script src="/susant/src/main/webapp/lib/angular.js"></script>
<script src="angu.js"></script>
<div ng-controller="demoCtlr">
Welcone  {{message}}
</div>
<form name=f action='empdemo' method='post'>
 <center>
 <span style="width=500;height=60;filter:shadow(color=blue,direction=135)">
 Emp_id     <input type="text" name="emp_id" required="required"> <br></br>
 Name<input type="text" name="name" required="required"><br></br>
 Mob<input type="number" name="mob" required="required" maxlength="10" min="999999999"><br>
 Join Date<input type="date" name="join_date" required="required">
 DoB<input type="date" name="Dob" required="required" ><br>
 Degn<input type="text" name="degn" required="required"><br></br>
 <input type="submit" value='insert' name='sub'>
 <input type="submit" value='delete' name='sub'>
 <input type="submit" value='update' name="sub">
 <input type="submit" value='display'name='sub'>
<!--  <input type="text" name='setVal' readonly style='visibility:hidden'>
 --> 
 </span>
 </center>
</form>
<script language='javascript'>
/* function isInsert()
{
  f.setVal.value="insert";
  check();
}
function isDelete()
{
  f.setVal.value="delete";
  check1();
}
function isUpdated()
{
 f.setVal.value="update";
 check();
}
function isDisplay()
{
  f.setVal.value="display";
  check1();
}
function check()
{
  var dateFormat=/^(0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])[\/\-]\d{4}$/;
  if(f.emp_id.value=="")
  {
    alert("please provide Employee ID");
    f.emp_id.focus();
  }
  else if(isNaN(f.emp_id.value))
  {
    alert("Employee id should be numeric");
    f.emp_id.value="";
    f.emp_id.focus();
  }
  else if(isNaN(f.mob.value))
  {
   alert("should be numeric");
   f.mob.focus();
  }
  
  else if(!(f.join_date.value.match(dateFormat)))
  {
    alert("Invalid date");
    f.join_date.focus();
  }
  else if(!(f.Dob.value.match(dateFormat)))
  {
    alert("Invalid date");
    f.Dob.focus();
  }
  if(f.degn.value=="")
  {
    alert("please provide Employee ID");
    f.degn.focus();
  }
  else
  {
    f.submit();
  }
  
}
function check1()
{
   if(f.emp_id.value=="")
  {
    alert("please provide Employee ID");
    f.emp_id.focus();
  }
  else if(isNaN(f.emp_id.value))
  {
    alert("Employee id should be numeric");
    f.emp_id.value="";
    f.emp_id.focus();
  }
  else
  {
   f.submit();
  }

}

 */
 function dis_output()
{
  var i=<%=emp_id%>;
  var n=<%=name%>;
  var m=<%=mob%>;
  var j=<%=join_date%>;
  var d=<%=Dob%>;
  var dg=<%=degn%>;
  f.emp_id.value=i;
  f.name.value=n;
  f.mob.value=m;
  f.join_date.value=j;
  f.Dob.value=d;
  f.degn.value=dg;
 
}


function isReloading() {

 <%
 if(res!=null)
 {
  if(res.equals("1"))
  out.println("alert('information stored successfully')");
  else if(res.equals("2"))
  out.println("alert('Given id already exist')");
  else if(res.equals("3"))
  out.println("alert('information deleted successfully')");
  else if(res.equals("4"))
  out.println("alert('Given id is invalid')");
  else if(res.equals("5"))
  out.println("alert('information updated successfully')");
  else if(res.equals("6"))
  {
  out.println("disp1_output()");
  }
  else if(res.equals("7"))
  out.println("alert('unknown problem occurs')"); 
 }
 %>	
}

</script>


</body>
</html>
