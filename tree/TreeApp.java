public class TreeApp {

    public static<E> void traverseInorder(TreeNode<E> root) {
	if (root == null) return;
	traverseInorder(root.getLeft());
	System.out.print(root.getValue() + " ");
	traverseInorder(root.getRight());
    }

    public static<E> void traversePreorder(TreeNode<E> root) {
	if (root == null) return;
	System.out.print(root.getValue() + "");
	traversePreorder(root.getLeft());
	traversePreorder(root.getRight());
    }

    public static<E> void traversePostorder(TreeNode<E> root) {
	if (root == null) return;
	traversePostorder(root.getLeft());
	traversePostorder(root.getRight());
	System.out.print(root.getValue() + "");
    }

    public static<E> int countNodes(TreeNode<E> root) {
	if (root == null) return 0;
	return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }

    public static<E> boolean isLeaf(TreeNode<E> root) {
	/*
	if (root == null) return false;
	return !isLeaf(root.getLeft()) && !isLeaf(root.getRight());
	*/
	return root != null && root.getLeft() == null && root.getRight() == null; 
    }

    public static<E> int height(TreeNode<E> root) {
	//if (root == null) return 0;
	if (root == null || isLeaf(root)) return 0;
	return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    public static<E> int countLeaves(TreeNode<E> root) {
	if (isLeaf(root)) return 1;
	return countLeaves(root.getLeft()) + countLeaves(root.getRight());
    }

    public static void main(String[] args) {
	    TreeNode<Integer> root = new TreeNode<Integer>(1,null,null);
	    root.setLeft(new TreeNode<Integer>(2,null,null));
	    root.setRight(new TreeNode<Integer>(3,null,null));
	    root.getLeft().setRight(new TreeNode<Integer>(4,null,null));
	    root.getRight().setLeft(new TreeNode<Integer>(5,null,null));
	    root.getRight().setRight(new TreeNode<Integer>(6,null,null));
	    root.getRight().getLeft().setLeft(new TreeNode<Integer>(7,null,null));	
	    root.getRight().getLeft().setRight(new TreeNode<Integer>(8,null,null));		 

	    System.out.print("inorder : ");
	    traverseInorder(root);
	    System.out.print("\npreorder : ");
	    traversePreorder(root);
	    System.out.print("\npostorder : ");
	    traversePostorder(root);
	    System.out.println();
    }

}
