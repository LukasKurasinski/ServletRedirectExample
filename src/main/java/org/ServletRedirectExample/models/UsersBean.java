package org.ServletRedirectExample.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class UsersBean implements Serializable {

    private List<String[]> data = null;
    private String fname;

    public UsersBean(){};

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }

}
