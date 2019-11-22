package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.repository.TreeRepository;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class TreeServiceLoadNodsToDatabase implements TreeRepository {


    @Override
    public MyNode parsChildrenToNode(DatabaseMetaData meta, MyNode parentNode,
                                     String databaseName, String table) throws SQLException {
        // находим узел, название которого соответствует названию БД
//        MyNode dbNode = parent.getChild(databaseName);
        // узел таблиц
        MyNode tableNode = new MyNode();
        tableNode.setName("TableNodes");
        tableNode.setType("tables");
        // узел Views
        MyNode viewNode = new MyNode();
        viewNode.setName("ViewsNodes");
        viewNode.setType("views");
        // узел Stored_Procedures
        MyNode procedureNode = new MyNode();
        procedureNode.setName("Stored_Procedures_Nodes");
        procedureNode.setType("storedProcedures");
        // узел Functions
        MyNode functionNode = new MyNode();
        functionNode.setName("FunctionsNodes");
        functionNode.setType("functions");
        parentNode.addChild(tableNode);
        parentNode.addChild(viewNode);
        parentNode.addChild(procedureNode);
        parentNode.addChild(functionNode);

        return parentNode;
    }
}
