package treenode2;
public class TreeNode2 {
private TreeNode2 left, right, parent;
    private Object elemen;

    public TreeNode2(TreeNode2 parent, Object elemen) {
        this.parent = parent;
        this.elemen = elemen;
    }

    public TreeNode2 getParent() {
        return parent;
    }

    public void setParent(TreeNode2 parent) {
        this.parent = parent;
    }

    public TreeNode2() {
    }

    public TreeNode2(int elemen, TreeNode2 parent) {
        this.elemen = elemen;
        this.parent = parent;
    }

    public Object getElemen() {
        return elemen;    }
    public void setElemen(int elemen) {
        this.elemen = elemen;    }

    public TreeNode2 getLeft() {
        return left;    }
    public void setLeft(TreeNode2 left) {
        this.left = left;    }

    public TreeNode2 getRight() {
        return right;    }
    public void setRight(TreeNode2 right) {
        this.right = right;    }   
    
    public void insert(Object x){
        if (((Comparable) x).compareTo(elemen) < 0){
            if (this.left==null){
                left = new TreeNode2(this, x);                
            } else {
                left.insert(x);
            }
        } else {
            if (this.right==null){
                right = new TreeNode2(this, x);                
            } else {
                right.insert(x);
            }
        }
    }

    void setElemen(Object elemen) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
