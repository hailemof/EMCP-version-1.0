$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
			$.get(href, function(transaction, status){
			$('#idEdit').val(transaction.id);
			$('#idtransaction').val(transaction.transactiondocumentid);
			$('#iddocname').val(transaction.docname);
			$('#idcreate').val(transaction.createdBy);
			$('#idcdate').val(transaction.createdDate);
			$('#idmodifyby').val(transaction.lastModifiedBy);
			$('#idlastmodify').val(transaction.lastModifiedDate);
			$('#idorgid').val(transaction.organizaid);
			$('#idreportstatus').val(transaction.reportstatus);
			$('#idremarks').val(transaction.remarks);
			$('#idexpert').val(transaction.assigned_expert_user_id);
					});					
		$('#editModal').modal();
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
	
	$('table #detailButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
			$.get(href, function(transaction, status){
			$('#idEdit').val(transaction.id);
			$('#idtransaction').val(transaction.transactiondocumentid);
			$('#iddocname').val(transaction.docname);
			$('#idcreate').val(transaction.createdBy);
			$('#idcdate').val(transaction.createdDate);
			$('#idmodifyby').val(transaction.lastModifiedBy);
			$('#idlastmodify').val(transaction.lastModifiedDate);
			$('#idorgid').val(transaction.organizaid);
			$('#idreportstatus').val(transaction.reportstatus);
			$('#idremarks').val(transaction.remarks);
					});					
		$('#detailButton').modal();
	});
		
});