package com.example.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {"com.liferay.portlet.display-category=category.bgeneral",
    "com.liferay.portlet.instanceable=true", "javax.portlet.display-name=test-web Portlet",
    "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
    "javax.portlet.resource-bundle=content.Language",
    "javax.portlet.security-role-ref=power-user,user",
    "com.liferay.portlet.footer-portlet-javascript=/js/test-controller.js",
    "com.liferay.portlet.footer-portlet-javascript=/js/test-service.js"
}, service = Portlet.class)
public class TestPortlet extends MVCPortlet {
}
