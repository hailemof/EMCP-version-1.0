<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<br>
<br>
<br>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> User Lists</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.dataTables.min.css"/>
 <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
 </head>
 <body>



	




<div class="container">
<h3>User Registration Form Validation</h3>

        <form:form action="/signup" method="POST" modelAttribute="user">
        <table width="100%">
			<tr>
				<td width="50%">
				
			
             <div class="form-group row ${status.error ? 'has-error' : ''}">
                <label for="recipient-name" class="col-sm-4 col-form-label">FirstName:</label>
               <div class="col-sm-6">
                   <input type="text" class="form-control" id="recipient-name" name="firstName"  >
                <form:errors path="firstName" style="color:red;"></form:errors>
              </div>
            </div>
        
            
            
         <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">LastName:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="lastName"  >
           <form:errors path="lastName" style="color:red;"></form:errors>
            </div>
          </div>
         
           <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">Email:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="email"  >
          <form:errors path="email" style="color:red;"></form:errors>
            </div>
          </div>
                 
          <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">Username:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="username"  required>
             <form:errors path="username" style="color:red;"></form:errors>
            </div>
          </div>
          
          </td>
		<td width="50%" style="padding-left:10px">
        
          <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">Password:</label>
            <div class ="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="password"  >
            <form:errors path="password" style="color:red;"></form:errors>
            </div>
          </div>
         
          
          
           <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">Confirm:</label>
            <div class ="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="confirmPassword" >
           <form:errors path="confirmPassword" style="color:red;"></form:errors>
            
            </div>
          </div>
          
       
          <div class="form-group row ${status.error ? 'has-error' : ''}" >
		    <label for="trainee" class="col-sm-4 col-form-label">Organization: </label>
		    <div class ="col-sm-6">
			    <select class="form-control" id="orgid" name="org_id"  >
			       
			     	 <c:forEach items="${organizations}" var="course">
				      <option value="${course.id}">${course.orgname}
				   </option>
				   </c:forEach>
			    </select>	
			    <form:errors path="org_id" style="color:red;"></form:errors>
			    </div>		    
		  </div> 
		
		   <div class="form-group row ${status.error ? 'has-error' : ''}">
		    <label for="trainee" class="col-sm-4 col-form-label">Directorate: </label>
		    <div class ="col-sm-6">
			    <select class="form-control" id="orgid" name="user_dir_name"  >
			       
			     	 <c:forEach items="${directorates}" var="director">
				      <option value="${director.directoratename}">${director.directoratename}
				   </option>
				   </c:forEach>
				   <form:errors path="user_dir_name" style="color:red;"></form:errors>
			    </select >
			   
			    </div>		    
		  </div> 
		
		  
		  
          
          
          <!-- the following id="roles" and name ="roles" is very important to add user_id and role_id in to db -->

		<div class="form-group row ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-lable" for="roles">
					Roles:</label>
				<div class="col-sm-6">
					<select class="form-control"  id="roles"  name="roles" multiple="true" >
						
							<c:forEach items="${roles}"  var="role">
						<option value="${role.id}">${role.name} </option>
							</c:forEach>
					</select>
                 <form:errors path="roles" style="color:red;"></form:errors>
				</div>
			</div>
	 	
   <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">Status:</label>
            <div class ="col-sm-6">
            <input type="number" class="form-control" id="statusEdit" name="status" >
           <form:errors path="status" style="color:red;"></form:errors>
            
            </div>
          </div>


    
    

									<div class="modal-footer">
         <div class="form-group row" class="col-sm-4 col-form-label">
          <button type="submit" value="Update" class="btn btn-primary">Save</button>  
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>      
        </div>  
      </div>
      </td>
      </tr>
      </table>
      </form:form>
                 
  </div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>

<script type="text/javascript">
function confirmDelete(id){
	$('#deleteModal').modal('show');
	$("#userIdHiddenInput").val(id);
}

function deleteUser(){
	var id = $("#userIdHiddenInput").val();
    window.location = "deleteUser/"+id;
}
</script>

<script>
$(document).ready( function() {
	  $('#datatable').dataTable( {
	    "iDisplayLength": 5
	    
	  } );
	} ) 

</script >


</body>
</html>
     
        
    
      