<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset="UTF-8">
<title>Master Transaction Lists</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
 </head>
 <body>
<div class="container">
<br>
<br>
<br><br>
	<div>
					<table class="table table-striped table-advance  table-bordered " id="datatable"  >
                <thead class="thead-dark">
                  <tr>
                    <th><i class="icon_table"></i>Submission Date</th>
                    <th><i class="icon_table"></i> Username</th>
                     <th><i class="icon_table"></i>Document</th>
                     <th><i class="icon_table"></i>Status</th>
                      <th><i class="icon_table"></i>File Name</th>
                      <th><i class ="icon_table"></i> OrgCode</th>
                      <th><i class ="icon_table"></i> Download</th>   
                         
                    <th><i class="icon_cogs"></i>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${mastertransactionlists}" var="transaction">
						<tr>
							<td>${transaction.createdDate}</td>
							<td>${transaction.createdBy}</td>
							<td>${transaction.transactiondocumentid}</td>
							<td>${transaction.reportstatus}</td>
							<td>${transaction.docname}</td>
							<td>${transaction.organizaid}</td>
					        <td><a href="download?id=${transaction.id}">Download</a></td>
					         					 
							<td><a type="button" class="btn btn-success" id="editButton"
								href="/mastertransactionlists/findById?id=${transaction.id}">Assign expert</a>
							</td>
								
						</tr>
					</c:forEach>
        </tbody>
        
       </table>
	</div>
</div>

<div class="modal fade" id="editModal" tabindex="-1"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header"> 
        <h3 class="modal-title" id="exampleModalLabel"><align="center" >Assign Experts for the Task !!</align></h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="/accounttransactionlists/update" method="put"> 
            <div class="col-md-6">
				             
          <div class="form-group">
            <label for="recipient-id" class="col-form-label">ID:</label>
            <input type="text" class="form-control" id="idEdit" name="id" readonly>
          </div>
          
          <div class="form-group">
            <label for="recipient-id" class="col-form-label">Document ID:</label>
            <input type="text" class="form-control" id="idtransaction" name="transactiondocumentid" readonly>
          </div>
          
          <div class="form-group">
            <label for="recipient-id" class="col-form-label">Document name:</label>
            <input type="text" class="form-control" id="iddocname" name="docname" readonly>
          </div>
          
         
            
          <div class="form-group" >
            <label for="recipient-id" class="col-form-label">Send By :</label>
            <input type="text" class="form-control" id="idcreate" name="createdBy" readonly>
          </div>
          
            
          <div class="form-group" hidden="true">
            <label for="recipient-id" class="col-form-label"> Date Sent :</label>
            <input type="text" class="form-control" id="idcdate" name="createdDate" readonly >
          </div>
          
            </div>
             <div class="col-md-6">
          <div class="form-group" hidden="true">
            <label for="recipient-id" class="col-form-label">Last Modified By :</label>
            <input type="text" class="form-control" id="idmodifyby" name="lastModifiedBy" readonly>
          </div>
          
          <div class="form-group"  hidden="true">
            <label for="recipient-id" class="col-form-label">Last Modified Date :</label>
            <input type="text" class="form-control" id="idlastmodify" name="lastModifiedDate" readonly>
          </div>
          
          
         <div class="form-group">
            <label for="recipient-id" class="col-form-label"> Org Code:</label>
            <input type="text" class="form-control" id="idorgid" name="organizaid" readonly>
          </div>
          
                
           <div class="form-group">
		    <label for="ddlCountryDetails" class="col-form-label">Expert: </label>
			    <select class="form-control" id="idexpert" name="assigned_expert_user_id"
			    style="width:200px;
            height:40px;
            background-color:#25383C;
            color:white;
            font-size: 16px;" >
			      
			       <c:forEach items="${accountexperts}" var="organization">
				      <option value="${organization.id}">${organization.firstName} ${organization.lastName}
				   </option>
				   </c:forEach>
			    </select>	
			    		    
		  </div>  
          
                   
						<div class="form-group">
							<label for="ddlCountryDetails" class="col-form-label">
								Status: </label> <select class="form-control" 
            style="width:200px;
            height:40px;
            background-color:#25383C;
            color:white;
            font-size: 16px;"
            id="idreportstatus" name="reportstatus">
                                <option value="Pending" >Pending</option>
								<option value="Incomplete">Incomplete</option>
								<option  value="Complete">Complete</option>
							</select>

						</div>
						<div class="form-group">
            <label for="recipient-id" class="col-form-label"> Remarks:</label>
            <textarea id="idremarks" name="remarks" placeholder="enter remarks if u have any" rows="6" cols="6" class="form-control"></textarea>
          </div>
		
        </div>
        <div class="modal-footer">
        <div class="form-group">
          <button type="submit" class="btn btn-primary">Save</button> 
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> 
        </div>
               
        </div> 
         </form>
                 
      </div>
    </div>
  </div>
</div>
      
<%@ include file="common/footer.jspf"%>
<script type ="text/javascript"  src="js/mastertransaction.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.print.min.js"></script>
<script>
$(document).ready(function() {
    $('#datatable').DataTable( {
    	"iDisplayLength": 2,
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
        } );
} );
</script>
</body>
</html>

  