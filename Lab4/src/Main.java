public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        tree.addElement(3);
        tree.addElement(1);
        tree.addElement(2);
        tree.addElement(0);
        tree.addElement(5);
        tree.addElement(4);
        tree.deleteElement(1);
        tree.lkr();
//        tree.addElement(5);
//        for (int i = 10; i > -1; --i) {
//            tree.addElement(i);
//        }
//        tree.addElement(6);
//        tree.addElement(2);
//        tree.addElement(1);
//        tree.addElement(3);
//        tree.addElement(5);
//        tree.addElement(4);
//        tree.addElement(8);
//        tree.addElement(7);
//        tree.addElement(9);
//        tree.addElement(10);
//        tree.klr();
//
////        System.out.println(tree.count());
//        // tree.klr();
////        tree.lkr();
////        tree.lrk();
//        tree.deleteElement(6);
//    //    System.out.println(tree.count());
//        tree.klr();
//        tree.lkr();
//        tree.lrk();
//
//        Tree<Integer> tree1 = new Tree<Integer>();
//        tree1.addElement(30);
//        tree1.addElement(12);
//        tree1.addElement(11);
//        tree1.addElement(19);
//        tree1.addElement(40);
//        tree1.addElement(32);
//        tree1.addElement(34);
//        tree1.addElement(38);
//        tree1.addElement(36);
//        tree1.addElement(45);
//        tree1.addElement(43);
//        tree1.addElement(50);
//        tree1.addElement(37);
//        tree1.deleteElement(40);
//        tree1.deleteElement(30);
//        tree1.klr();


//        Tree<Train> trainTree = new Tree<Train>();
//        trainTree.addElement(new Train(12, 3));
//        trainTree.addElement(new Train(12, 5));
//        trainTree.addElement(new Train(11, 7));
//        trainTree.addElement(new Train(10, 3));
//        trainTree.addElement(new Train(11, 8));
//        trainTree.addElement(new Train(13, 1));
//        trainTree.klr();
//        System.out.println(trainTree.findElement(new Train(12, 5)));
//        System.out.println(trainTree.findElement(new Train(12, 6)));
    }
}
