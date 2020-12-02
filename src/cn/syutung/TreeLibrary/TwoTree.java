package cn.syutung.TreeLibrary;
import cn.syutung.ListLibrary.MyQueue;
import cn.syutung.ListLibrary.MyStack;

public class TwoTree<T> implements Tree<T> {
    TreeNode<T> root = new TreeNode<>() ;
    int NodeNumber;
    int NodeDeepin;
    public TwoTree(){
        this.root = new TreeNode<>();
    }
    public TwoTree(String[] args){
        this.root=createTree(args);
    }
    private int i =0;
    public TreeNode<T> createTree(String[] args){
        TreeNode<T> point = null;
        if(i<args.length){
            String m = args[i++];
            if(!m.equals("#"))
            {
                TreeNode<T> bakPoiNode = point;
                point = new TreeNode<>((T)m);
                NodeNumber++;
                point.leftNode= createTree(args);
                point.rightNode= createTree(args);
            }
        }
        
        return point;

    }
    public int getNodeDeepin(){
        return this.getNodeDeepin(this.root);
    }
    public int getNodeDeepin(TreeNode<T> root){
        if (root==null){
            return 0;
        }
        int left = getNodeDeepin(root.leftNode);
        int right = getNodeDeepin(root.rightNode);
        if (left>right){
            return left+1;
        }else{
            return right+1;
        }

    }

    public int getNodeNumber(){
        return NodeNumber;
    }

    public void bac_not_used(){
        if (root == null){
            return;
        }
        TreeNode<T> tNode = this.root;
        TreeNode<T> treeNode = null;
        //System.out.print(tNode.data.toString()+" ");
        MyStack<TreeNode<T>> bakTreeNodes = new MyStack<>();

        while (tNode!=null||!bakTreeNodes.isEmpty()){
            while (tNode!=null){
                bakTreeNodes.push(tNode);
                tNode = tNode.leftNode;
            }
            if (!bakTreeNodes.isEmpty()){
                tNode = bakTreeNodes.get();
                if (tNode.rightNode==null || tNode.rightNode == treeNode){
                    tNode=bakTreeNodes.pop();
                    System.out.print(tNode.data.toString()+" ");
                    treeNode=tNode;
                    tNode=null;
                }else{
                    tNode =tNode.rightNode;
                }
            }
        }
        System.out.print("\n");
    }
    
    public void ino_not_used(){
        if (root == null){
            return;
        }
        TreeNode<T> tNode = this.root;
        //System.out.print(tNode.data.toString()+" ");
        MyStack<TreeNode<T>> bakTreeNodes = new MyStack<>();
        bakTreeNodes.push(tNode);
        while (!bakTreeNodes.isEmpty()){
            if (tNode!=null && tNode.isLeftEmpty()){
                bakTreeNodes.push(tNode.leftNode);
                tNode=tNode.leftNode;
            }else{
                tNode = bakTreeNodes.pop();
                System.out.print(tNode.data.toString()+" ");
                if (tNode!=null && tNode.isRightEmpty()){
                    bakTreeNodes.push(tNode.rightNode);
                    tNode=tNode.rightNode;
                }else{
                    tNode=null;
                }
            }

        }

        System.out.print("\n");
    }
    public void pre_not_used(){
        if (root == null){
            return;
        }
        TreeNode<T> tNode = root;
        MyStack<TreeNode<T>> bakTreeNodes = new MyStack<>();
        while(tNode!=null){
                System.out.print(tNode.data.toString()+" ");
                if(tNode.isLeftEmpty()){
                    if(tNode.isRightEmpty()){
                        bakTreeNodes.push(tNode.rightNode);
                    }
                    
                    tNode = tNode.leftNode;
                    continue;
                }
                if(tNode.isRightEmpty()){
                    
                    tNode = tNode.rightNode;
                    continue;
                }
                if(bakTreeNodes.isEmpty()){
                    break;
                }else{
                    tNode = bakTreeNodes.pop();
                }
            }
        System.out.print("\n");

    }


    public void pre(){
        pre(this.root);
        System.out.println();
    }
    public void pre(TreeNode<T> p){
        if(p!=null){
            System.out.print(p.data.toString()+" ");
            pre(p.leftNode);
            pre(p.rightNode);
        }// System.out.print("# ");

    }
    

    public void ceng(){
        MyQueue<TreeNode<T>> bak = new MyQueue<>();
        TreeNode<T> p = this.root;
        bak.enqueue(p);
        while(p != null){
            p = bak.dequeue();
            if(p != null){
                System.out.print(p.data.toString()+" ");
                if(p.isLeftEmpty()){
                    bak.enqueue(p.leftNode);
                }
    
                if(p.isRightEmpty()){
                    bak.enqueue(p.rightNode);
                }
            }

            if(bak.isEmpty()){
                break;
            }
        }
        System.out.println();
    }
   

    public void ino(){
        ino(this.root);
        System.out.println();
    }
    public void ino(TreeNode<T> p){
        if(p!=null){
            ino(p.leftNode);
            System.out.print(p.data.toString()+" ");
            ino(p.rightNode);
        }// System.out.print("# ");

    }

    public void pos(){
        this.pos(this.root);
        System.out.println();
    }
    public void pos(TreeNode<T> p){
        if(p!=null){
            pos(p.leftNode);
            pos(p.rightNode);
            System.out.print(p.data.toString()+" ");
            
        }//  System.out.print("# ");

    }
    public String toString(){
        if (this.root == null){
            return null;
        }
        return this.root.toString();
    }
    public boolean isEmpty(){
        return this.root == null;
    }
}
