package com.example.bogdana.viewer.service;

import com.example.bogdana.viewer.repository.TreeRepository;


public class NodeLoaderChooser {

    public NodeLoaderChooser() {
    }

    public TreeRepository choose(String typeNode) {
        TreeRepository treeRepository;
        switch (typeNode) {
            case ("schema"):
                treeRepository = new TreeServiceLoadDatabases();
                break;

            case ("database"):
                treeRepository = new TreeServiceLoadNodsToDatabase();
                break;

            case ("tables"):
                treeRepository = new TreeServiceLoadTables();
                break;

            default:
                treeRepository = new TreeServiceLoaderDefault();
                break;
        }
        return treeRepository;
    }
}
