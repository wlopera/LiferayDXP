<%@ include file="/init.jsp"%>

<div class='row' ng-controller='PaisController as ctrl'>

	<p style="padding-left: 1cm">
		<button type="button" class="btn btn-success btn-small"
			ng-click="ctrl.getPaises()">
			<span class="glyphicon glyphicon-search"></span> Países
		</button>
		<button type="button" class="btn btn-success btn-small"
			ng-click="ctrl.getPaisByName('Argentina')">
			<span class="glyphicon glyphicon-search"></span> Pais
		</button>

	</p>
	<div class="container">
		<hr>
		<div class="table table-fixed tabla">
			<table class="table table-striped">
				<thead>
					<tr>
						<th align="center">NOMBRE</th>
						<th align="center">CAPITAL</th>
						<th align="center">MONEDA</th>
						<th align="center">IDIOMA</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="pais in ctrl.paises">
						<td>{{pais.nombre}}</td>
						<td>{{pais.capital}}</td>
						<td>{{pais.moneda}}</td>
						<td>{{pais.idioma}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div>
		{{ctrl.pais | json}}
	</div>
</div>
