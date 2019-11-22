package com.example.bogdana.viewer.config;

import com.example.bogdana.viewer.model.tree.MyNode;
import com.example.bogdana.viewer.model.tree.MyTree;
import com.example.bogdana.viewer.service.NodeLoaderChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {

    @Bean
    public MyNode myNode() {
        return new MyNode();
    }

    @Bean
    public MyTree myTree() {
        return new MyTree();
    }

    @Bean
    public MyConnection myConnection() {
        return new MyConnection();
    }

    @Bean
    public NodeLoaderChooser nodeLoaderChooser() {
        return new NodeLoaderChooser();
    }
}
