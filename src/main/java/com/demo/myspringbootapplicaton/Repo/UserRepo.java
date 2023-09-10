package com.demo.myspringbootapplicaton.Repo;

import com.demo.myspringbootapplicaton.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
