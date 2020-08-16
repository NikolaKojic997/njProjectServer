package com.njProjectServer.repository;

import com.njProjectServer.model.Assistant;

import javax.transaction.Transactional;

@Transactional
public interface AssistantRepository extends EmployeeBaseRepository<Assistant> {
}
