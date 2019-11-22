package com.example.bogdana.viewer.repository;

import com.example.bogdana.viewer.model.tree.MyNode;


public interface NodeRepository {
    MyNode parsChildrenToNode(MyNode parentNode);
}
