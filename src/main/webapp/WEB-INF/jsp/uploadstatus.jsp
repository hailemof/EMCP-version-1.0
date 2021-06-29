<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

  <br>
  <br>
<h3 align ="center"> Dear  ${pageContext.request.userPrincipal.name}, </h3>  
<h4 align ="center">Your Report has been Successfully sent! </h4> 

<div  align ="center">
     <a  type="button" class="btn btn-success" id="editUploadsuccess" href="/">Back to homepage </a>
</div> 


<%@ include file="common/footer.jspf"%>