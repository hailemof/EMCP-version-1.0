<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




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
<br>
<br>

<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" >New User </button>
<br><br>
	<div class="panel panel-primary">
					<table class="table table-striped table-advance  table-bordered " id="datatable"  >
                <thead class="thead-dark">
                  <tr>
                   
                    <th><i class="icon_table"></i>Name:</th>
                    <th><i class="icon_table"></i>lastName:</th>
                     <th><i class="icon_table"></i>Username</th>
                     
                      <th><i class="icon_table"></i> OrgCode</th>
                       <th><i class="icon_table"></i> Directorate</th>
                     <th><i class="icon_table"></i> Status</th>
                     <th><i class="icon_cogs"></i>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${cashexperts}" var="user">
						<tr>
						
						    <td>${user.firstName}</td>
						    <td>${user.lastName}</td>
							<td>${user.username}</td>
							
							<td>${user.org_id}</td>
							<td>${user.user_dir_name}</td>
							<td>${user.status}</td>
							
			
							  <td>
							
                           <a class="btn btn-success custom-width" href="<c:url value='/edit-user-${user.id}' />" >Update</a>
						    <a  class="btn btn-danger " href="<c:url value='/delete-user-${user.id}' />" >Delete</a>
								
								</td>
								
                       
							
								  
						</tr>
					</c:forEach>
        </tbody>
        
       </table>
	</div>
</div>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document" style="width:100%">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLabel"> New User Registration</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
     
        
    
      
        <form:form action="/signup" method="POST" modelAttribute="user">
        <table width="100%">
			<tr>
				<td width="50%">
				
			
             <div class="form-group row ">
                <label for="recipient-name" class="col-sm-4 col-form-label">FirstName:</label>
               <div class="col-sm-6">
                   <input type="text" class="form-control" id="firstedit" name="firstName"  >
                <form:errors path="firstName" ></form:errors>
              </div>
            </div>
           
            
           
         <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">LastName:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="lastedit" name="lastName"  >
           <form:errors path="lastName"></form:errors>
            </div>
          </div>
         
          
      
           <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Email:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="emailedit" name="email"  >
          
            </div>
          </div>
                 
          <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Username:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="usernameedit" name="username"  required>
             <form:errors path="username"></form:errors>
            </div>
          </div>
    
          </td>
		<td width="50%" style="padding-left:10px">
        
          <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Password:</label>
            <div class ="col-sm-6">
            <input type="text" class="form-control" id="passwordedit" name="password"  >
            <form:errors path="password"></form:errors>
            </div>
          </div>
         
           <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Confirm:</label>
            <div class ="col-sm-6">
            <input type="text" class="form-control" id="confirmedit" name="confirmPassword" >
           <form:errors path="confirmPassword"></form:errors>
            
            </div>
          </div>
          
         
          
          <div class="form-group row">
		    <label for="trainee" class="col-sm-4 col-form-label">Organization: </label>
		    <div class ="col-sm-6">
			    <select class="form-control" id="orgid" name="org_id"  >
			       <option>--SELECT--</option>
			     	 <c:forEach items="${organizations}" var="course">
				      <option value="${course.id}">${course.orgname}
				   </option>
				   </c:forEach>
				   
			    </select>
			    <form:errors path="organization"></form:errors>	
			    </div>		    
		  </div> 
		  
          <div class="form-group row">
		    <label for="trainee" class="col-sm-4 col-form-label">Directorate: </label>
		    <div class ="col-sm-6">
			    <select class="form-control" id="orgid" name="user_dir_name"  >
			       <option>--SELECT--</option>
			     	 <c:forEach items="${directorates}" var="director">
				      <option value="${director.directoratename}">${director.directoratename}
				   </option>
				   </c:forEach>
				   
			    </select>
			    <form:errors path="organization"></form:errors>	
			    </div>		    
		  </div> 
		  
		     <!-- the following id="roles" and name ="roles" is very important to add user_id and role_id in to db -->

		<div class="form-group row">
			<label class="col-sm-4 control-lable" for="roles">
					Roles:</label>
				 <div class="form-group row">
            
        </div>
			</div>
	 				
	 	
		      
           <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Status:</label>
            <div class ="col-sm-6">
            <input type="number" class="form-control" id="statusEdit" name="status" >
           <form:errors path="status"></form:errors>
            
            </div>
          </div>
          
       
        
       		

  





									<div class="modal-footer">
         <div class="form-group row" class="col-sm-4 col-form-label">
          <button type="submit"  class="btn btn-primary">Save</button>  
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>      
        </div>  
      </div>
      </td>
      </tr>
      </table>
      </form:form>
       
    </div>
  </div> 
</div>

</div>

<div class="modal fade" id="editModal" tabindex="-1"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Update User</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
       <form:form method="POST" modelAttribute="user" action="/edit-user" >
        <table width="100%">
			<tr>
				<td width="50%">
		
		      <div class="form-group row ">
                <label for="recipient-name" class="col-sm-4 col-form-label">ID:</label>
               <div class="col-sm-6">
                   <input type="text" class="form-control" id="idEdit" name="id" readonly >
                <form:errors path="id" ></form:errors>
              </div>
            </div>
        
			
             <div class="form-group row ">
                <label for="recipient-name" class="col-sm-4 col-form-label">FirstName:</label>
               <div class="col-sm-6">
                   <input type="text" class="form-control" id="firstNameEdit" name="firstName"  >
                <form:errors path="firstName" ></form:errors>
              </div>
            </div>
            
            
           
         <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">LastName:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="lastNameEdit" name="lastName"  >
           <form:errors path="lastName"></form:errors>
            </div>
          </div>
          
          
          
           <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Email:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="emailEdit" name="email"  >
          
            </div>
          </div>
                 
          <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Username:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="userNameEdit" name="username"  required>
             <form:errors path="username"></form:errors>
            </div>
          </div>
        
          </td>
		<td width="50%" style="padding-left:10px">
        
          <div class="form-group row">
            <label for="recipient-name" class="col-sm-4 col-form-label">Password:</label>
            <div class ="col-sm-6">
            <input type="text" class="form-control" id="passEdit" name="password"  >
            <form:errors path="password"></form:errors>
            </div>
          </div>
          
           <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Confirm:</label>
            <div class ="col-sm-6">
            <input type="text" class="form-control" id="confirmPassEdit" name="confirmPassword" >
           <form:errors path="confirmPassword"></form:errors>
            
            </div>
          </div>
          
          
          
          <div class="form-group row">
		    <label for="trainee" class="col-sm-4 col-form-label">Organization: </label>
		    <div class ="col-sm-6">
			    <select class="form-control" id="orgIdEdit" name="org_id"  >
			       <option>--SELECT--</option>
			     	 <c:forEach items="${organizations}" var="course">
				      <option value="${course.id}">${course.orgname}
				   </option>
				   </c:forEach>
				   
			    </select>
			    <form:errors path="organization"></form:errors>	
			    </div>		    
		  </div> 
		   <div class="form-group row">
		    <label for="trainee" class="col-sm-4 col-form-label">Directorate: </label>
		    <div class ="col-sm-6">
			    <select class="form-control" id="orgid" name="user_dir_name"  >
			       <option>--SELECT--</option>
			     	 <c:forEach items="${directorate}" var="director">
				      <option value="${director.directoratename}">${director.directoratename}
				   </option>
				   </c:forEach>
				   
			    </select>
			    <form:errors path="organization"></form:errors>	
			    </div>		    
		  </div> 
		  
		 
          
          
          <!-- the following id="roles" and name ="roles" is very important to add user_id and role_id in to db -->

		<div class="form-group row">
			<label class="col-sm-4 control-lable" for="roles">
					Roles:</label>
				 <div class="form-group row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="roles"> Roles:</label>
                <div class="col-md-7">
                    <form:select  path="roles" role="${roles}" 
                    items="${roles}" multiple="true"  itemValue="id"
                    itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="roles" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
			</div>
	 				
	 						
	 	
           <div class="form-group row ">
            <label for="recipient-name" class="col-sm-4 col-form-label">Status:</label>
            <div class ="col-sm-6">
            <input type="number" class="form-control" id="statusEdit" name="status" >
           <form:errors path="status"></form:errors>
            
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
    </div>
  </div>
</div>
<div class="modal" id="deleteModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form method="post" action="/delete-user">
      <div class="modal-header">
        <h5 class="modal-title">Confirm Delete</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
  
      <div class="modal-body">
        <p>Are you sure you want to delete this record?</p>
      </div>
      <div class="modal-footer">
        <a class="btn btn-primary" id="confirmDeleteButton" href="">Yes, Delete</a>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
      </div>
      
      </form>
    </div>
  </div>
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

  