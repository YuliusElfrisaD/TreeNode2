package treenode2;
public class Tree2 {
    private TreeNode2 root;
    private int size;

    public Tree2() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TreeNode2 getRoot() {
        return root;
    }

    public void setRoot(TreeNode2 root) {
        this.root = root;
    }

    public void add(int x) {
        TreeNode2 baru = new TreeNode2(x, null);
        if (isEmpty()) {
            root = baru;
        } else {
            root.insert(x);
        }
    }

    public void preOrder(TreeNode2 root) {
        if (root != null) {
            System.out.print(root.getElemen() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        } else {
            return;
        }
    }

    public void inOrder(TreeNode2 root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getElemen() + " ");
            inOrder(root.getRight());
        } else {
            return;
        }
    }

    public void postOrder(TreeNode2 root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getElemen() + " ");
        } else {
            return;
        }
    }
    public TreeNode2 search(Object key) {
        if (isEmpty()) {
            return null;
        } else {
            TreeNode2 bantu = root;
            while (bantu != null) {
                if (key == bantu.getElemen()) {
                    return bantu;
                } else if (((Comparable) key).compareTo(bantu.getElemen()) < 0 ) {
                    bantu = bantu.getLeft();
                } else {
                    bantu = bantu.getRight();
                }
            }
            return null;
        }
    }
    public TreeNode2 searchChild(int key, TreeNode2 child1, TreeNode2 child2){
        if(isEmpty()){
            return null;
        }else{
            TreeNode2 bantu = root;
            while(bantu != null){
                if(key == bantu.getElemen()){
                    if(bantu.getLeft()==null){
                        child1=null;
                        System.out.println("tidak mempunyai anak kiri");
                    }else{
                        child1=bantu.getLeft();
                        System.out.println("anak kirinya adalah :"+bantu.getLeft().getElemen());
                    }
                    if(bantu.getRight()== null){
                        child2=null;
                        System.out.println("tidak mempunyai anak kanan");
                    }else{
                        child2=bantu.getRight();
                        System.out.println("anak kanannya adalah :"+bantu.getRight().getElemen());
                    }
                    return bantu;
                }else if(((Comparable) key).compareTo(bantu.getElemen()) < 0){
                    bantu = bantu.getLeft();
                }else{
                    bantu = bantu.getRight();
                }
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addNonrekur(int key) {

        if (isEmpty()) {
            setRoot(new TreeNode2(key, null));
        } else {
            TreeNode2 bantu = root;
            while (bantu != null) {
                if (((Comparable) key).compareTo(bantu.getElemen()) < 0) {
                    if (bantu.getLeft() == null) {
                        bantu.setLeft(new TreeNode2(key, bantu));
                        bantu = null;
                    } else {
                        bantu = bantu.getLeft();
                    }
                } else {
                    if (bantu.getRight() == null) {
                        bantu.setRight(new TreeNode2(key, bantu));
                        bantu = null;
                    } else {
                        bantu = bantu.getRight();
                    }
                }
            }
        }
    }

    public TreeNode2 getCurrent(int x) {
        TreeNode2 bantu = root;
        while (bantu != null) {
            if (x == bantu.getElemen()) {
                return bantu;
            } else if (((Comparable) x).compareTo(bantu.getElemen()) < 0) {
                bantu = bantu.getLeft();
            } else {
                bantu = bantu.getRight();
            }
        }
        return bantu;
    }
    public TreeNode2 getPredecessor(TreeNode2 x) {
        TreeNode2 bantu = x.getLeft();
        if (bantu == null) {
            return null;
        } else {
            while (bantu.getRight() != null) {
                bantu = bantu.getRight();
            }
        }
        return bantu;
    }
    public TreeNode2 remove(int x) {
        TreeNode2 bantu = search(x);
        if (bantu == null) {
            return null;
        } else {
            if (bantu.getElemen() == root.getElemen()) {
                if (bantu.getLeft() == null && bantu.getRight() == null) {
                    root = null;
                } else {
                    if (bantu.getRight() == null) {
                        root = bantu.getLeft();
                    } else if (bantu.getLeft() == null) {
                        root = bantu.getRight();
                    } else {
                        TreeNode2 predecessor = getPredecessor(bantu);
                        TreeNode2 parentPredecessor = predecessor.getParent();
                        root.setElemen(predecessor.getElemen());
                        if (parentPredecessor != bantu) {
                            if (predecessor.getLeft() != null) {
                                parentPredecessor.setRight(predecessor.getLeft());
                            } else {
                                parentPredecessor.setRight(null);
                            }
                        } else {
                            bantu.setLeft(predecessor.getLeft());
                        }
                    }
                }
            } else {
                TreeNode2 ortu = bantu.getParent();
                if (((Comparable) x).compareTo(ortu.getElemen()) < 0) {
                    if (bantu.getLeft() == null && bantu.getRight() == null) {
                        ortu.setLeft(null);
                    } else if (bantu.getRight() == null) {
                        ortu.setLeft(bantu.getLeft());
                    } else if (bantu.getLeft() == null) {
                        ortu.setLeft(bantu.getRight());
                    } else {
                        TreeNode2 predecessor = getPredecessor(bantu);
                        TreeNode2 parentPredecessor = predecessor.getParent();
                        bantu.setElemen(predecessor.getElemen());
                        if (parentPredecessor != bantu) {
                            if (predecessor.getLeft() != null) {
                                parentPredecessor.setRight(predecessor.getLeft());
                            } else {
                                parentPredecessor.setRight(null);
                            }
                        } else {
                            bantu.setLeft(predecessor.getLeft());
                        }
                    }
                    
                } else {
                    if (bantu.getLeft() == null && bantu.getRight() == null) {
                        ortu.setRight(null);
                    } else if (bantu.getRight() == null) {
                        ortu.setRight(bantu.getLeft());
                    } else if (bantu.getLeft() == null) {
                        ortu.setRight(bantu.getRight());
                    } else {
                        TreeNode2 predecessor = getPredecessor(bantu);
                        TreeNode2 parentPredecessor = predecessor.getParent();
                        bantu.setElemen(predecessor.getElemen());
                        if (parentPredecessor != bantu) {
                            if (predecessor.getLeft() != null) {
                                parentPredecessor.setRight(predecessor.getLeft());
                            } else {
                                parentPredecessor.setRight(null);
                            }
                        } else {
                            bantu.setLeft(predecessor.getLeft());
                        }
                    }
                }
            }
        }
        return bantu;
    }
}
