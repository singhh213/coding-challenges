public class LowestCommonAncestor {

    /* Find the lowest common ancestor of two given values, num1 and num2, in a Binary Search Tree.
       Tree below is created as an example in main method


                20
               /  \
              8    22
             / \
            4   12
               /  \
              10   14
    */

    public static void main(String[] args) {
        Node a = new Node(20);
        Node b = new Node(8);
        Node c = new Node(4);
        Node d = new Node(12);
        Node e = new Node(14);
        Node f = new Node (22);
        Node g = new Node (10);

        a.left = b;
        a.right = f;
        b.left = c;
        b.right = d;
        d.left = g;
        d.right = e;

        int num1 = 10;
        int num2 = 14;
        Node lca = lowestCommonAncestor(a, 10, 14);
        System.out.println("LCA of " + num1 + " and " + num2 + " is " + lca.data);

        num1 = 10;
        num2 = 22;
        lca = lowestCommonAncestor(a, 10, 22);
        System.out.println("LCA of " + num1 + " and " + num2 + " is " + lca.data);

        num1 = 14;
        num2 = 8;
        lca = lowestCommonAncestor(a, 14, 8);
        System.out.println("LCA of " + num1 + " and " + num2 + " is " + lca.data);
    }


    private static Node lowestCommonAncestor(Node root, int num1, int num2) {
        if (root == null) {
            return null;
        } else if (root.data > num1 && root.data > num2) {
            return lowestCommonAncestor(root.left, num1, num2);
        } else if (root.data < num1 && root.data < num2) {
            return lowestCommonAncestor(root.right, num1, num2);
        } else {
            return root;
        }
    }

    private static class Node {
        private Node left;
        private Node right;
        private int data;

        Node(int data) {
            left = right = null;
            this.data = data;
        }
    }
}
