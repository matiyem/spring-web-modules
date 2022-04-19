package com.example.boot.respository;

import com.example.boot.domain.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:13 AM
**/
public interface GenericEntityRepository extends JpaRepository<GenericEntity,Long> {
}
