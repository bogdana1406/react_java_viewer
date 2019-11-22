package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.repository.TreeRepository;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TreeServiceLoadTables implements TreeRepository {
    @Override
    public MyNode parsChildrenToNode(DatabaseMetaData meta, MyNode parentNode,
                                     String databaseName, String tableNameParam) throws SQLException {
        String[] types = { "TABLE" };
        // в resultSet получаем все таблицы конкретной БД
        ResultSet resultSet = meta.getTables(databaseName, null, null, types);
        String tableName;
        // из дерева получаем узел (ребенка) с названием БД, а у него узел таблиц
//        MyNode dbTableNode = parentNode.getChild(databaseName).getChild("TableNodes");
        while (resultSet.next()) {
            // пока в resultSet содежаться таблицы создаем новый узел
            MyNode tableNode = new MyNode();
            // получаем имя таблицы
            tableName = resultSet.getString("TABLE_NAME");
            // устанавливаем новому узлу имя, соответсвующее названию таблицы
            tableNode.setName(tableName);
            // добавляем в узел БД узел таблицы (каждой)
            parentNode.addChild(tableNode);
        }
        return parentNode;
    }
}
