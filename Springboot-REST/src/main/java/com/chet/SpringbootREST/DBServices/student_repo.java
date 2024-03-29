package com.chet.SpringbootREST.DBServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface student_repo extends JpaRepository<Student, Integer>{

}
