<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "Controller.Controller, Bean.SegnalazionePagamentoBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">
    
    
        <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script type='text/javascript'>
$(function(){
$('.input-group.date').datepicker({
    calendarWeeks: true,
    todayHighlight: true,
    autoclose: true
});  
});

</script>
        
    <title>Hello, world!</title>
    
    <script type="text/javascript">
        $(".form_datetime").datetimepicker({
            format: "dd MM yyyy - hh:ii",
            autoclose: true,
            todayBtn: true,
            startDate: "2013-02-14 10:00",
            minuteStep: 10
        });
    </script>             
  </head>
  <%
    Controller controllerProva = Controller.getInstance(); %>
    
    <%
    if (request.getParameter("1") != null) {
       
        SegnalazionePagamentoBean bean = new SegnalazionePagamentoBean();
        bean.setID(Integer.parseInt(request.getParameter("id")));
        bean.setNumeroReclamo(Integer.parseInt(request.getParameter("numeroReclamo")));
        controllerProva.incrementaSegnalazione(bean);

}
    if (request.getParameter("2") != null) {
       
        SegnalazionePagamentoBean bean = new SegnalazionePagamentoBean();
        bean.setID(Integer.parseInt(request.getParameter("id")));
        controllerProva.setContrattoArchiviato(bean);

}
%>
    
    <%
    List<Integer> IDSegnalazioni = new LinkedList<>();
    List<SegnalazionePagamentoBean> listaResult = controllerProva.getSegnalazioniPagamento(); %>
  <body>
      
      

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="#">Features</a>
      <a class="nav-item nav-link" href="#">Pricing</a>
      <a class="nav-item nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
    </div>
  </div>
</nav>
      
    	  <br>
<div class="container">
                <%
    		for (SegnalazionePagamentoBean temp : listaResult) {
		%>
    <form action="test1.jsp" name="myform" method="POST"><div class="row justify-content-md-center ">
    <div class="col-md">
        <b>ID Contratto:</b> <%= temp.getIDContratto() %>
    </div>
    <div class="col-md">
        <b>Numero reclamo:</b> <%= temp.getNumeroReclamo() %>
    </div>
      
    <div class="col-md">
        <b>Scadenza reclamo:</b> <%= temp.getScadenzaReclamo() %>
    </div>
      
    <div class="col-md">
        
        <%
            switch(temp.getStato()){
                case 0: %>
                    <button type="button" class="btn btn-outline-secondary" disabled>In attesa del locatario</button>
            <% 

                    break;
                
                case 1:
                %>
        <input name = "1" type="submit" class="btn btn-info" value="Reinoltra segnalazione">
        <input type="hidden" id="custId" name="id" value="<%= temp.getID() %>"> 
         <input type="hidden" id="custId" name="numeroReclamo" value="<%= temp.getNumeroReclamo() %>"> 

                <%

                    
                
                    break;
                    
                case 2:                        
                %> 
        <input name = "2" type="submit" class="btn btn-info" value="Archivia contratto">
        <input type="hidden" id="custId" name="id" value="<%= temp.getID() %>"> 
            <%
                    break;
                    
                case 3:
                    %>
        <button type="button" class="btn btn-outline-secondary" disabled>Archivia contratto</button>
                    <%
                    break;
            }
            %>
        
            
    </div>
      
  </div></form>
    <br>
                    <%
                }
            %>
</div>      


<br><br><br>

    <div class="input-append date form_datetime" data-date="2013-02-21T15:25:00Z">
        <input size="16" type="text" value="" readonly>
        <span class="add-on"><i class="icon-remove"></i></span>
        <span class="add-on"><i class="icon-calendar"></i></span>
    </div>
      
      <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    
    
    
    
    
    
  
    
    
    
    
    
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <!-- Bootstrap Date-Picker Plugin -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    

    
</body>
</html>