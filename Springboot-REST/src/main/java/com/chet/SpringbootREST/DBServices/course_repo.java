package com.chet.SpringbootREST.DBServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface course_repo extends JpaRepository<Course, Integer>{

}
