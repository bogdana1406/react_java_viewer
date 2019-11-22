package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.repository.TreeRepository;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class TreeServiceLoaderDefault implements TreeRepository {
    @Override
    public MyNode parsChildrenToNode(DatabaseMetaData meta, MyNode parentNode, String databaseName, String tableName) throws SQLException {
        return null;
    }
}
