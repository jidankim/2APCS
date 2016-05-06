public class BST<E extends Comparable> {

    private TreeNode<E> _root;
    private int _size;

    public BST() {}
    
    // post : inserts a leaf into the tree
    public void insert(E x) {
	if (_root == null) _root = x;
	else if (x.compareTo(_root.getValue()) < 0) {
	    _root = _root.getLeft();
	    insertNode(new TreeNode<E>(x, null, null));
	} else {
	    _root = _root.getRigt();
	    insertNode(new TreeNode<E>(x, null, null));
	}
    }
    
    private void insertNode(TreeNode<E> x) {
	
    }

    // public boolean find(E x) {}
    // public boolean remove(E x) {}

    public int size() {
	return _size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public void inorder() {
	inorderTraversal(_root);
	System.out.println();
    }

    private void inorderTraversal(TreeNode<E> root) {
	if (root == null) return;
	inorderTraversal(root.getLeft());
	System.out.println(root.getValue() + " ");
	inorderTraversal(root.getRight());
    }
    
}
