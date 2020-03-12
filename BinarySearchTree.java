
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType> {
    int opCount = 0;

    public BinarySearchTree() {
    }

    public void insert(dataType d, dataType k) {
        if (this.root == null) {
            this.root = new BinaryTreeNode(d, k, (BinaryTreeNode)null, (BinaryTreeNode)null);
        } else {
            this.insert(d, k, this.root);
        }

    }

    public void insert(dataType d, dataType k, BinaryTreeNode<dataType> node) {
        if (k.compareTo(node.key) <= 0) {
            if (node.left == null) {
                node.left = new BinaryTreeNode(d, k, (BinaryTreeNode)null, (BinaryTreeNode)null);
            } else {
                this.insert(d, k, node.left);
            }
        } else if (node.right == null) {
            node.right = new BinaryTreeNode(d, k, (BinaryTreeNode)null, (BinaryTreeNode)null);
        } else {
            this.insert(d, k, node.right);
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

    public void delete(dataType d, dataType k) {
        this.root = this.delete(d, k, this.root);
    }

    public BinaryTreeNode<dataType> delete(dataType d, dataType k, BinaryTreeNode<dataType> node) {
        if (node == null) {
            return null;
        } else {
            if (d.compareTo(node.data) < 0) {
                node.left = this.delete(d, k, node.left);
            } else if (d.compareTo(node.data) > 0) {
                node.right = this.delete(d, k, node.right);
            } else if (node.left != null && node.right != null) {
                node.data = this.findMin(node.right).data;
                node.key = this.findMin(node.right).key;
                node.right = this.removeMin(node.right);
            } else if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }

            return node;
        }
    }

    public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node) {
        if (node != null) {
            while(node.left != null) {
                node = node.left;
            }
        }

        return node;
    }

    public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node) {
        if (node == null) {
            return null;
        } else if (node.left != null) {
            node.left = this.removeMin(node.left);
            return node;
        } else {
            return node.right;
        }
    }

    public int getOpCount() {
        return this.opCount;
    }
}
