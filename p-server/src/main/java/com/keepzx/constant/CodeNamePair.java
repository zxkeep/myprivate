package com.scxinglin.constant;

import java.io.Serializable;

public class CodeNamePair<K,V> implements Serializable {

    public final static <K,V> CodeNamePair createInstance(K code, V name) {
        return new CodeNamePair(code, name);
    }

    private K code;
    private V name;

    public CodeNamePair(){}

    public CodeNamePair(K code, V name){
        this.code = code;
        this.name = name;
    }

    public K getCode() {
        return code;
    }

    public void setCode(K code) {
        this.code = code;
    }

    public V getName() {
        return name;
    }

    public void setName(V name) {
        this.name = name;
    }
}
