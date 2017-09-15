<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="test_web_TestWebmvcportlet.caption"/></b>

	<div class='row' ng-controller='TestController as ctrl'>

		<div class='col-sm-6'>

			<input type="text" name="" ng-model="ctrl.name">

		</div>

		<div class='col-sm-6'>

			<button type='button' ng-click='ctrl.sayHello()'>
				Say Hello!
			</button>

		</div>

	</div>

</p>
