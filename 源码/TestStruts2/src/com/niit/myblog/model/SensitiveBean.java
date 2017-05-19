
package com.niit.myblog.model;

public class SensitiveBean {
    private String S_Word;
    public SensitiveBean(){}
    public SensitiveBean(String S_Word){
        this.S_Word=S_Word;
    }
    public String getS_Word(){
        return S_Word;
    }
    public void setS_Word(String S_Word){
        this.S_Word=S_Word;
    }
}
