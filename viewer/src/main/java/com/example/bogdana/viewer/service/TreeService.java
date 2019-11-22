package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.model.tree.MyTree;
import com.example.bogdana.viewer.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class TreeService {

//    @Autowired
//    MyTree myTree;
//
//    @Autowired
//    TreeRepository treeRepository;

    @Autowired
    NodeLoaderChooser nodeLoaderChooser;

    public  MyNode parseNode(DatabaseMetaData meta, MyNode node, String dbName, String tableName) throws SQLException {
        TreeRepository chooseLoader = nodeLoaderChooser.choose(node.getType());
        MyNode myNode = chooseLoader.parsChildrenToNode(meta, node, dbName, tableName);
        return myNode;
    }


    //    public MyNode parsDatabasesToTree(DatabaseMetaData meta) throws SQLException {
//        String databaseName;
//        //создаем корневой узел
//        MyNode startNode = new MyNode();
//        // присваиваем название корневому узлу
//        startNode.setName("SCHEMAS");
//        // устанавливаем startNode (с названием "databases") корнем дерева
//        myTree.setRoot(startNode);
//        //в resultSet получаем все БД
//        ResultSet resultSet = meta.getCatalogs();
//        while (resultSet.next()) {
////            System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
//            // для каждой БД создаем новый узел
//            MyNode dataBaseNode = new MyNode();
//            // получаем имя БД
//            databaseName = resultSet.getString("TABLE_CAT");
//            // устанавливаем название узла, соответственно названию БД
//            dataBaseNode.setName(databaseName);
//            // к startNode (который установлен как корень дерева) добавляем узкл, с названием БД
//            startNode.addChild(dataBaseNode);
//        }
////        resultSet.close();
//        // возвращаем корень дерева (startNode)
//        return startNode;
//    }

}
