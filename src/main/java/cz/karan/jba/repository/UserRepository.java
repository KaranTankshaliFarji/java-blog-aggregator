package cz.karan.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import cz.karan.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
