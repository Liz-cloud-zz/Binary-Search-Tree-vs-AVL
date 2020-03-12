

public class BinaryTree<dataType> {
    BinaryTreeNode<dataType> root = null;

    public BinaryTree() {
    }

    public int getHeight() {
        return this.getHeight(this.root);
    }

    public int getHeight(BinaryTreeNode<dataType> node) {
        return node == null ? -1 : 1 + Math.max(this.getHeight(node.getLeft()), this.getHeight(node.getRight()));
    }

    public int getSize() {
        return this.getSize(this.root);
    }

    public int getSize(BinaryTreeNode<dataType> node) {
        return node == null ? 0 : 1 + this.getSize(node.getLeft()) + this.getSize(node.getRight());
    }

    public void visit(BinaryTreeNode<dataType> node) {
        System.out.println(node.key + " " + node.data);
    }

    public String toString() {
        return this.root.toString();
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    public void preOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            this.visit(node);
            this.preOrder(node.getLeft());
            this.preOrder(node.getRight());
        }

    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    public void postOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            this.postOrder(node.getLeft());
            this.postOrder(node.getRight());
            this.visit(node);
        }

    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    public void inOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            this.inOrder(node.getLeft());
            this.visit(node);
            this.inOrder(node.getRight());
        }

    }

    public void levelOrder() {
        if (this.root != null) {
            BTQueue<dataType> q = new BTQueue();
            q.enQueue(this.root);

            BinaryTreeNode node;
            while((node = q.getNext()) != null) {
                this.visit(node);
                if (node.getLeft() != null) {
                    q.enQueue(node.getLeft());
                }

                if (node.getRight() != null) {
                    q.enQueue(node.getRight());
                }
            }

        }
    }
}
