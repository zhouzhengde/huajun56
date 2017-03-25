package com.huajun56.common.entity;

import javax.persistence.MappedSuperclass;
import java.util.List;

/**
 * Base Entity for commonly attributes
 */
@MappedSuperclass
public class TreeBaseEntity<T> extends BaseEntity {

    private String text;

    private List<T> nodes;

    private T parent;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<T> getNodes() {
        return nodes;
    }

    public void setNodes(List<T> nodes) {
        this.nodes = nodes;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }
}
