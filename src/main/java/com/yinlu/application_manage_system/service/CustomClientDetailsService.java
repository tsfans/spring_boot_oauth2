package com.yinlu.application_manage_system.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import com.yinlu.application_manage_system.dao.ClientMapper;
import com.yinlu.application_manage_system.domain.Client;

public class CustomClientDetailsService implements ClientDetailsService{

	@Autowired
	private ClientMapper clientMapper;
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		BaseClientDetails details = new BaseClientDetails();
		Client client = clientMapper.selectByClientId(clientId);
		if(client == null) {
			throw new ClientRegistrationException("the clientId ["+clientId+"] does not exist!");
		}
		details.setClientId(clientId);
		details.setClientSecret(client.getClientsecret());
		details.setAccessTokenValiditySeconds(2592000);
		Collection<String> scope = new ArrayList<String>();
		String scopes = client.getScope();
		String[] scopeArray = scopes.split(",");
		for(String s:scopeArray) {
			scope.add(s);
		}
		details.setScope(scope);
		return details;
	}

}
