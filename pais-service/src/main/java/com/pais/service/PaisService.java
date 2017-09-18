package com.pais.service;

import com.pais.api.PaisApi;
import com.pais.model.Pais;
import com.pais.util.JSONRead;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {}, service = PaisApi.class)
public class PaisService implements PaisApi {
	private List<Pais> paises;
	
	@Override
	public List<Pais> getPaises() {
		if (paises == null || paises.size()==0) {
			paises = new JSONRead().getDataPaises();
		}
		return paises;
	}

    

}
