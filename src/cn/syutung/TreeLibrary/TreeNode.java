package cn.syutung.TreeLibrary;

public class TreeNode<T> implements Nodes<T>{
    public TreeNode<T> leftNode;
    public TreeNode<T> rightNode ;
     T data;

    TreeNode(T data){
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
    TreeNode(){
        this.data = null;
        this.leftNode = null;
        this.rightNode = null;
    }
    TreeNode(T data,TreeNode<T> lNode,TreeNode<T> rNode){
        this(data);
        this.leftNode = lNode;
        this.rightNode = rNode;
    }
    public boolean isLeaf(){
        return leftNode == null && rightNode == null;
    }
    public boolean isRightEmpty(){
        return rightNode != null;
    }
    public boolean isLeftEmpty(){
        return leftNode != null;
    }
    public boolean isEmpty(){
        return this == null;
    }
    public T getData(){
        return this.data;
    }

    public String toString(){
        if (isEmpty()){
            return "#";
        }
        return "("+data.toString()+"{"+this.leftNode.toString()+","+this.rightNode.toString()+"}"+")";

    }

}
