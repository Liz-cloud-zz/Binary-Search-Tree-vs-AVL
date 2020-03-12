
public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType> {
    int opCount = 0;

    public AVLTree() {
    }

    public int height(BinaryTreeNode<dataType> node) {
        return node != null ? node.height : -1;
    }

    public int balanceFactor(BinaryTreeNode<dataType> node) {
        return this.height(node.right) - this.height(node.left);
    }

    public void fixHeight(BinaryTreeNode<dataType> node) {
        node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
    }

    public BinaryTreeNode<dataType> rotateRight(BinaryTreeNode<dataType> p) {
        BinaryTreeNode<dataType> q = p.left;
        p.left = q.right;
        q.right = p;
        this.fixHeight(p);
        this.fixHeight(q);
        return q;
    }

    public BinaryTreeNode<dataType> rotateLeft(BinaryTreeNode<dataType> q) {
        BinaryTreeNode<dataType> p = q.right;
        q.right = p.left;
        p.left = q;
        this.fixHeight(q);
        this.fixHeight(p);
        return p;
    }

    public BinaryTreeNode<dataType> balance(BinaryTreeNode<dataType> p) {
        this.fixHeight(p);
        if (this.balanceFactor(p) == 2) {
            if (this.balanceFactor(p.right) < 0) {
                p.right = this.rotateRight(p.right);
            }

            return this.rotateLeft(p);
        } else if (this.balanceFactor(p) == -2) {
            if (this.balanceFactor(p.left) > 0) {
                p.left = this.rotateLeft(p.left);
            }

            return this.rotateRight(p);
        } else {
            return p;
        }
    }

    public void insert(dataType d, dataType k) {
        this.root = this.insert(d, k, this.root);
    }

    public BinaryTreeNode<dataType> insert(dataType d, dataType k, BinaryTreeNode<dataType> node) {
        if (node == null) {
            return new BinaryTreeNode(d, k, (BinaryTreeNode)null, (BinaryTreeNode)null);
        } else {
            if (k.compareTo(node.key) <= 0) {
                node.left = this.insert(d, k, node.left);
            } else {
                node.right = this.insert(d, k, node.right);
            }

            return this.balance(node);
        }
    }

    public void delete(dataType d, dataType k) {
        this.root = this.delete(d, k, this.root);
    }

    public BinaryTreeNode<dataType> delete(dataType d, dataType k, BinaryTreeNode<dataType> node) {
        if (node == null) {
            return null;
        } else {
            if (d.compareTo(node.data) < 0) {
                node.left = this.delete(d, k, node.left);
            } else {
                if (d.compareTo(node.data) <= 0) {
                    BinaryTreeNode<dataType> q = node.left;
                    BinaryTreeNode<dataType> r = node.right;
                    if (r == null) {
                        return q;
                    }

                    BinaryTreeNode<dataType> min = this.findMin(r);
                    min.right = this.removeMin(r);
                    min.left = q;
                    return this.balance(min);
                }

                node.right = this.delete(d, k, node.right);
            }

            return this.balance(node);
        }
    }

    public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node) {
        return node.left != null ? this.findMin(node.left) : node;
    }

    public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = this.removeMin(node.left);
            return this.balance(node);
        }
    }

    public BinaryTreeNode<dataType> find(dataType k) {
        return this.root == null ? null : this.find(k, this.root);
    }

    public BinaryTreeNode<dataType> find(dataType k, BinaryTreeNode<dataType> node) {
        ++this.opCount;
        if (k.compareTo(node.key) == 0) {
            return node;
        } else if (k.compareTo(node.key) < 0) {
            ++this.opCount;
            return node.left == null ? null : this.find(k, node.left);
        } else {
            ++this.opCount;
            return node.right == null ? null : this.find(k, node.right);
        }
    }

    public void treeOrder() {
        this.treeOrder(this.root, 0);
    }

    public void treeOrder(BinaryTreeNode<dataType> node, int level) {
        if (node != null) {
            for(int i = 0; i < level; ++i) {
                System.out.print(" ");
            }

            System.out.println(node.key + " " + node.data);
            this.treeOrder(node.left, level + 1);
            this.treeOrder(node.right, level + 1);
        }

    }

    public int getOpCount() {
        return this.opCount;
    }
}
