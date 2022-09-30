package com.svv.hibernatedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svv.hibernatedemo.entity.Options;

public interface OptionsRepository extends JpaRepository<Options,Long>{

}
