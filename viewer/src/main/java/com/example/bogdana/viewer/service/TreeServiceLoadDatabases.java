package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.model.tree.MyTree;
import com.example.bogdana.viewer.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TreeServiceLoadDatabases implements TreeRepository {

    @Autowired
    MyTree myTree;

    @Override
    public MyNode parsChildrenToNode(DatabaseMetaData meta, MyNode parentNode,
                                     String database, String tableName) throws SQLException {
        String databaseName;
        //создаем корневой узел
//        MyNode startNode = new MyNode();
//        // присваиваем название корневому узлу
//        startNode.setName("SCHEMAS");
//        // устанавливаем startNode (с названием "databases") корнем дерева
//        myTree.setRoot(startNode);
//        //в resultSet получаем все БД
        ResultSet resultSet = meta.getCatalogs();
        while (resultSet.next()) {
//            System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
            // для каждой БД создаем новый узел
            MyNode dataBaseNode = new MyNode();
            // получаем имя БД
            databaseName = resultSet.getString("TABLE_CAT");
            // устанавливаем название узла, соответственно названию БД
            dataBaseNode.setName(databaseName);
            dataBaseNode.setType("database");
            // к startNode (который установлен как корень дерева) добавляем узкл, с названием БД
            parentNode.addChild(dataBaseNode);
        }
//        resultSet.close();
        // возвращаем корень дерева (startNode)
        return parentNode;
    }
}
