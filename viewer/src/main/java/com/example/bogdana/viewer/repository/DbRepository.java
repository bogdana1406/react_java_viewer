package com.example.bogdana.viewer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepository {

    @Autowired
    JdbcTemplate jdbcTemplate = null;

}
