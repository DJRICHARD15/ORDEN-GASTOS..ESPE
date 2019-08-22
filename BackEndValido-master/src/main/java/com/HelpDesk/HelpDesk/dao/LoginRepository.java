package com.HelpDesk.HelpDesk.dao;

import org.springframework.data.repository.CrudRepository;

import com.HelpDesk.HelpDesk.model.Login;

public interface LoginRepository extends CrudRepository<Login, Long> {

}
