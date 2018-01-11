package com.yinlu.application_manage_system.dao;

import com.yinlu.application_manage_system.domain.Client;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

	Client selectByClientId(String clientId);
}