<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="test_web_TestWebmvcportlet.caption"/></b>

	<div class='row' ng-controller='PaisController as ctrl'>

		<div class='col-sm-6'>

				{{ctrl.paises | json}}
		</div>

		<div class='col-sm-6'>

			<button type='button' ng-click='ctrl.getPaises()'>
				Consultar Paises!
			</button>

		</div>

	</div>

</p>
