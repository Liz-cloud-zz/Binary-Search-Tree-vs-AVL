

public class AVLTreeTest {
    public AVLTreeTest() {
    }

    public static void main(String[] args) {
        AVLTree<Integer> bt = new AVLTree();
        bt.insert(5, 7);
        bt.insert(1, 0);
        bt.insert(2, 9);
        bt.insert(4, 8);
        bt.insert(7, 8);
        bt.insert(9, 5);
        bt.insert(8, 3);
        bt.insert(3, 2);
        bt.insert(6, 4);
        System.out.println("Inorder : ");
        bt.treeOrder();
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
        bt.delete(9, 9);
        bt.treeOrder();
        System.out.println("Delete 7 : ");
        bt.delete(6, 5);
        bt.treeOrder();
        System.out.println("Delete 5 : ");
        bt.delete(7, 4);
        bt.treeOrder();
        System.out.println("Delete 3 : ");
        bt.delete(8, 5);
        bt.treeOrder();
        System.out.println("Delete 10 : ");
        bt.delete(5, 4);
        bt.treeOrder();
    }
}
