
public class BinarySearchTreeTest {
    public BinarySearchTreeTest() {
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt = new BinarySearchTree();
        bt.insert(5, 1);
        bt.insert(1, 2);
        bt.insert(2, 3);
        bt.insert(4, 3);
        bt.insert(7, 2);
        bt.insert(9, 5);
        bt.insert(8, 6);
        bt.insert(3, 8);
        bt.insert(6, 0);
        System.out.println("Inorder : ");
        bt.inOrder();
        System.out.println("Search 2 : ");
        System.out.println(bt.find(2));
        System.out.println("Search 7 : ");
        System.out.println(bt.find(7));
        System.out.println("Search 5 : ");
        System.out.println(bt.find(5));
        System.out.println("Search 3 : ");
        System.out.println(bt.find(3));
        System.out.println("Search 10 : ");
        System.out.println(bt.find(10));
        System.out.println("Delete 2 : ");
        bt.delete(2, 8);
        bt.inOrder();
        System.out.println("Delete 7 : ");
        bt.delete(7, 7);
        bt.inOrder();
        System.out.println("Delete 5 : ");
        bt.delete(5, 0);
        bt.inOrder();
        System.out.println("Delete 3 : ");
        bt.delete(3, 0);
        bt.inOrder();
        System.out.println("Delete 10 : ");
        bt.delete(10, 7);
        bt.inOrder();
    }
}
