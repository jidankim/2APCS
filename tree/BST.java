public class BST<E extends Comparable> {

    private TreeNode<E> _root;
    private int _size;

    public BST() {
	_root = null;
	_size = 0;
    }

    // returns null if val not found
    public TreeNode<E> find(E val) {
	TreeNode<E> curr = _root;
	while (curr != null && !val.equals(curr.getValue())) {
	    if (val.compareTo(curr.getValue()) < 0) curr = curr.getLeft();
	    else curr = curr.getRight();
	}
	return curr;
    }
    
    // post : inserts a leaf into the tree
    public void insert(E x) {
	//insertNode(new TreeNode<E>(x));
	_root = insertNode(_root, new TreeNode<E>(x));
	_size++;
    }

    private TreeNode<E> insertNode(TreeNode<E> rt, TreeNode<E> x) {
	if (rt == null) return x;
	E val = x.getValue();
	if (val.compareTo(rt.getValue()) < 0)
	    rt.setLeft(insertNode(rt.getLeft(), x));
	else
	    rt.setRight(insertNode(rt.getRight(), x));
	return rt;
    }
    
    private void insertNode(TreeNode<E> x) {
	E val = x.getValue();
	if (_root == null)
	    _root = n;
	else {
	    TreeNode<E> curr = _root;
	    TreeNode<E> prev = curr;
	    while (curr != null) {
		prev = curr;
		if (val.compareTo(curr.getValue()) >= 0)
		    curr = curr.getRight();
		else
		    curr = curr.getLeft();
	    }
	    if (val.compareTo(prev.getValue()) >= 0)
		prev.setRight(x);
	    else
		prev.setLeft(x);
	}
	_size++;
    }

    public int size() {
	return _size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public String toString() {
	String ans = "";
	return ans;
    }

    public void inorder() {
	System.out.print("inorder: ");
	inorderTraversal(_root);
	System.out.println();
    }

    private void inorderTraversal(TreeNode<E> root) {
	if (root == null) return;
	inorderTraversal(root.getLeft());
	System.out.println(root.getValue() + " ");
	inorderTraversal(root.getRight());
    }

    public void preorder() {
	System.out.print("preorder: ");
	preorderTraversal(_root);
	System.out.println();
    }

    private void preorderTraversal(TreeNode<E> root) {
	if (root == null) return;
	System.out.print(root.getValue() + " ");
	preorderTraversal(root.getLeft());
	preorderTraversal(root.getRight());
    }

    public void postorder() {
	System.out.println("postorder: ");
	postorderTraversal(_root);
	System.out.println();
    }

    private void postorderTraversal(TreeNode<E> root) {
	if (root == null) return;
	postorderTraversal(root.getLeft());
	postorderTraversal(root.getRight());
	System.out.print(root.getValue() + " ");
    }
    
}
