public class BTQueueNode<dataType> {
    BinaryTreeNode<dataType> node;
    BTQueueNode<dataType> next;

    public BTQueueNode(BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt) {
        this.node = n;
        this.next = nxt;
    }
}