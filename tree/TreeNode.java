public class TreeNode<E>{

    private E _value;
    private TreeNode<E> _left, _right;

    public treeNode(E value) {
	this(value, null, null);
    }

    public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
	_value = value;
	_left = left;
	_right = right;
    }

    public E getValue() {
	return _value;
    }

    public TreeNode<E> getLeft() {
	return _left;
    }

    public TreeNode<E> getRight() {
	return _right;
    }

    public E setValue(E newValue) {
	E temp = getValue();
	_value = newValue;
	return temp;
    }

    public TreeNode<E> setLeft(TreeNode<E> newLeft) {
	TreeNode<E> temp = getLeft();
	_left = newLeft;
	return temp;
    }

    public TreeNode<E> setRight(TreeNode<E> newRight) {
	TreeNode<E> temp = getRight();
	_right = newRight;
	return temp;
   }

    public tSTring toString() {
	return getValue() + "";
    }

}
