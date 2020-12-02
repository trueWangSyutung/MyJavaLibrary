package cn.syutung.TreeLibrary;


public interface Tree<T> {
    /***
     * 创建二叉数
     * @param args 数组
     * @return 二叉树的根节点
     */
    TreeNode<T> createTree(String[] args);

    /***
     * 获取二叉树的深度
     * @return 深度
     */
    int getNodeDeepin();
    int getNodeDeepin(TreeNode<T> root);

    /***
     * 获取二叉树的节点数
     * @return 节点数
     */
    int getNodeNumber();

    /***
     * 不用递归的后序遍历
     */
    void bac_not_used();
    /***
     * 不用递归的中序遍历
     */
    void ino_not_used();
    /***
     * 不用递归的先序遍历
     */
    void pre_not_used();

    /***
     * 用递归的先序遍历
     */
    void pre();
    void pre(TreeNode<T> p);

    /***
     * 不用递归的层次遍历
     */
    void ceng();
    /***
     * 用递归的中序遍历
     */
    void ino();
    void ino(TreeNode<T> p);
    /***
     * 用递归的后序遍历
     */
    void pos();
    void pos(TreeNode<T> p);
}
