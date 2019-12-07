package com.lxisoft.RunWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.RunWay.model.BookedDetail;

@Repository
public interface BookingRepository  extends JpaRepository<BookedDetail,String> {

}
