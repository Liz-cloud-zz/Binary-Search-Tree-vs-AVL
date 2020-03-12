

public class BinaryTreeNode<dataType> {
    dataType data;
    dataType key;
    BinaryTreeNode<dataType> left;
    BinaryTreeNode<dataType> right;
    int height;

    public BinaryTreeNode(dataType d, dataType k, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r) {
        this.data = d;
        this.key = k;
        this.left = l;
        this.right = r;
        this.height = 0;
    }

    BinaryTreeNode<dataType> getLeft() {
        return this.left;
    }

    BinaryTreeNode<dataType> getRight() {
        return this.right;
    }

    public String toString() {
        return this.key + " " + this.data;
    }
}
