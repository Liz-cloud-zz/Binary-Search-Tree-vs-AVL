
public class BTQueue<dataType> {
    BTQueueNode<dataType> head = null;
    BTQueueNode<dataType> tail = null;

    public BTQueue() {
    }

    public BinaryTreeNode<dataType> getNext() {
        if (this.head == null) {
            return null;
        } else {
            BTQueueNode<dataType> qnode = this.head;
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }

            return qnode.node;
        }
    }

    public void enQueue(BinaryTreeNode<dataType> node) {
        if (this.tail == null) {
            this.tail = new BTQueueNode(node, (BTQueueNode)null);
            this.head = this.tail;
        } else {
            this.tail.next = new BTQueueNode(node, (BTQueueNode)null);
            this.tail = this.tail.next;
        }

    }
}