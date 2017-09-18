<%@ include file="/init.jsp" %>

<p>
	<div class='row' ng-controller='PaisController as ctrl'>

	<div>	
  	
	</div>
		
	<div class="container">
	  <p style="padding-left: 1cm">
		  <button type="button" class="btn btn-success btn-small" ng-click="ctrl.getPaises()">
	    	<span class="glyphicon glyphicon-search"></span> Países 
	    </button>
    </p>
	  <hr>            
	  <table class="table table-striped" style="width:600px">
	    <thead>
	      <tr>
	       <th align="center"> NOMBRE</th>
					<th align="center"> CAPITAL</th>
					<th align="center"> MONEDA</th>
					<th align="center"> IDIOMA</th>
	      </tr>
	    </thead>
	    <tbody>
	     <tr ng-repeat="pais in ctrl.paises">
						<td> {{pais.nombre}}</td>
						<td> {{pais.capital}}</td>
						<td> {{pais.moneda}}</td>
						<td> {{pais.idioma}}</td>
				</tr>
	    </tbody>
	  </table>
	</div>

</p>
