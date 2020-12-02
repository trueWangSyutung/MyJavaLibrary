package cn.syutung.TreeLibrary;

public interface Nodes<T> {
     boolean isLeaf();
     boolean isRightEmpty();
     boolean isLeftEmpty();
     boolean isEmpty();
     T getData();
}
