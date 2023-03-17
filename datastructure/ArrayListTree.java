package codeStates.datastructure;

import java.util.ArrayList;

public class ArrayListTree {
    private String value;
    private ArrayList<ArrayListTree> children;

    public ArrayListTree() {
        this.value = null;
        this.children = null;
    }
    
    public ArrayListTree(String data){
        this.value = data;
        this.children=null;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    
    public void addChildNode(ArrayListTree node){
        if(children == null) children = new ArrayList<>();
        children.add(node);
    }
    public void removeChildNode(ArrayListTree node){
        String data = node.getValue();
        if(children!=null){
            for(int i=0;i<children.size();i++){
                if (children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                if(children.get(i).children!=null) children.get(i).removeChildNode(node);
            }
        }
    }
}
