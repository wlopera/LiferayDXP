package com.pais.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
   
@Component(immediate = true, property = {"com.liferay.portlet.display-category=categoria.pais",
	    "com.liferay.portlet.instanceable=true", "javax.portlet.display-name=Pais-WEB Portlet",
	    "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
	    "javax.portlet.resource-bundle=content.Language",
	    "javax.portlet.security-role-ref=power-user,user",
	    "com.liferay.portlet.footer-portlet-javascript=/js/pais-controller.js",
	    "com.liferay.portlet.footer-portlet-javascript=/js/pais-service.js"
	}, service = Portlet.class)
public class PaisPortlet extends MVCPortlet { 
}