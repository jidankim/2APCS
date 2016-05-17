public class BST<E extends Comparable> {

    private TreeNode<E> _root;
    private int _size;

    public BST() {
	_root = null;
	_size = 0;
    }

    // iterative version
    // returns null if val not found
    public TreeNode<E> find(E val) {
	TreeNode<E> curr = _root;
	while (curr != null && !val.equals(curr.getValue())) {
	    if (val.compareTo(curr.getValue()) < 0) curr = curr.getLeft();
	    else curr = curr.getRight();
	}
	return curr;
    }

    //*************************************************************
    // recursive version
    public TreeNode<E> findR(E val) {
	return findR(_root, val);
    }

    public TreeNode<E> findR(TreeNode<E> rt, E val) {
	if (rt == null && val.equals(rt.getValue())) return rt;
	if (val.compareTo(rt.getValue()) < 0)
	    return findR(rt.getLeft(), val);
	return findR(rt.getRight(), val);
    }

    //*************************************************************
    public boolean isFound() {
	return find(x) != null;
    }

    //*************************************************************
    // pre: !isEmpty()
    public E maxValue() throws IllegalStateException {
	return maxValue(_root);
    }

    private E maxValue(TreeNode<E> rt) throws IllegalStateException {
	if (rt == null) throw new IllegalStateException("empty");
	return maxNode(rt).getValue();
    }

    private TreeNode<E> maxNode(TreeNode<E> rt) {
	if (rt != null) {
	    while (rt.getRight() != null)
		rt = rt.getRight();
	    return rt;
	}
    }

    //*************************************************************   
    // pre: !isEmpty()
    public E minValue() throws IllegalStateException {
	return maxValue(_root):
    }

    private E maxValue(TreeNode<E> rt) throws IllegalStateException {
        if (rt == null) throw new IllegalStateException("empty");
	return minNode(rt).getValue();
    }

    private TreeNode<E> minNode(TreeNode<E> rt) {
	if (rt != null) {
	    while (rt.getLeft() != null)
		rt = rt.getLeft();
	    return rt;
	}
    }

    //*************************************************************
    public boolean remove(E val) {
	if (isFound(val)) {
	    _root = remove(_root, val);
	    _size--;
	    return true;
	}
	return false;
    }

    private TreeNode<E> remove(TreeNode<E> rt, E val) {
	if (rt.isLeaf() return null;
	if (val.equals(rt.getValue())) {
	    // no right subtree
	    if (rt.getRight() == null) {
		E max = maxValue(rt.getLeft());
		rt.setValue(max);
		rt.setLeft(remove(rt.getLeft(), max));
	    } else {
		E min = minValue(rt.getRight());
		rt.setValue(min);
		rt.setRight(remove(rt.getRight(), min));
	    }
	} else if (val.compareTo(rt.getValue) < 0)
	    rt.setLeft(remove(rt.getLeft(), val));
	else rt.setRight(remove(rt.getRight(), val));

	return rt;
    }

    //*************************************************************
    // recursive version
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
    
    // itertive version
    // inserts a node
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
     
    //********************************************************
    public String toString(){
        String ans = toString(_root);
        if (ans.length() > 1) {
            int pos = ans.lastIndexOf(",");
            ans = ans.substring(0,pos);
        }
        return ans;
    }
    // Uses an inorder traversal.
    private String toString(TreeNode<E> rt){
        String ans = "";
        if (rt != null){
            ans = toString(rt.getLeft()) + rt.getValue() + ", " + 
		  toString(rt.getRight());
        }
        return ans;
    }

    //********************************************************
    public static void main(String [] args){
	BST<Integer> tree = new BST<Integer>();
	int N = 10; //Integer.parseInt(args[0]);
	for (int i = 0; i < N; i++){
	    int r = (int) (Math.random() * 100);
	    System.out.println("insert " + r);
	    tree.insert(r);
	    System.out.println("tree: " + tree);
	}
	
	tree.inorder();
	tree.preorder();
	tree.postorder();
	//System.out.println("Max value: " + tree.maxValue());
	while (!tree.isEmpty()){
	    Integer max = tree.maxValue();
	    System.out.println("max : " + max);
	    tree.remove(max);
	    System.out.println("remove max: " + tree);
	}

    }
}

