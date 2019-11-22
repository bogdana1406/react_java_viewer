package com.example.bogdana.viewer.repository;

import com.example.bogdana.viewer.model.tree.MyNode;
import org.springframework.stereotype.Repository;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Repository
public interface TreeRepository {

    MyNode parsChildrenToNode(DatabaseMetaData meta, MyNode parentNode,
                              String databaseName, String tableName) throws SQLException;

    }
