<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> User  Profile</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.dataTables.min.css"/>
 <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
 </head>
 <body>
 <br>
 <br>
 <br>
 
 <!--Grid row-->
<div class="row d-flex justify-content-center">
  <!--Grid column-->
  <div class="col-md-6">
  <h2 class="text-center" >User Profile</h2>
    <table class="table table-striped table-advance  table-bordered " >
              <thead class="thead">
               <tr>
                  <th scope ="col"> ID  </th>
                  
                  <th scope="col">${user.id }<span text="${user.id }"></span></th>
                  
                
                  </tr>
              </thead>  
             
                
                <tbody>
               
                  
						<tr>
						<th scope ="col"> First Name  </th>
						    <td>${user.firstName}</td>
						
						</tr>
						<tr>
						<th scope ="col"> Last Name  </th>
						    <td>${user.lastName}</td>
						
						</tr>
						
						<tr>
						<th scope ="col"> User Name  </th>
						    <td>${user.username}</td>
						
						</tr>
						<tr>
						<th scope ="col"> Email  </th>
						    <td>${user.email}</td>
						
						</tr>
						
						<tr>
						<th scope ="col"> Role   </th>
						    <td>${user.roles}</td>
						
						</tr>
						
						
						<tr>
						<th scope ="col"> Organization Code  </th>
						    <td>${user.org_id}</td>
						
						</tr>
						<tr>
						<th scope ="col"> Directorate Name  </th>
						    <td>${user.user_dir_name}</td>
						
						</tr>
						<tr>
						<th scope ="col"> Status   </th>
						    <td>${user.status}</td>
						
						</tr>
						
						
						
				
        </tbody>
        
       </table>
  </div>
  <!--Grid column-->
</div>
<!--Grid row-->
 
 
 
 
 
 



<script type ="text/javascript"  src="js/user.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script>


</script>
</body>
</html>

  