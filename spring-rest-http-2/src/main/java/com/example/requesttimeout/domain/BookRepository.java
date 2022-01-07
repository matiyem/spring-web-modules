package com.example.requesttimeout.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by Atiye Mousavi
 * Date: 9/21/2021
 * Time: 12:02 PM
 */

public interface BookRepository extends JpaRepository<Book,String> {

    default int wasteTime(){
        int i=Integer.MIN_VALUE;
        while(i<Integer.MAX_VALUE){
            i++;
        }
        return i;
    }

}
