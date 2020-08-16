package com.njProjectServer.repository;

import com.njProjectServer.model.Teacher;
import javax.transaction.Transactional;


@Transactional
public interface TeacherRepository extends EmployeeBaseRepository<Teacher> {


}
