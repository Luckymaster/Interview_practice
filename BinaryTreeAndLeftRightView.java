public class BinaryTreeAndLeftRightView {

	private Node rootNode;

	static int maxLevel = 0;

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	void add(int value) {
		rootNode = addNode(rootNode, value);
	}

	private void addNode1(Node currentNode, int value) {
		currentNode.value = value;
	}

	private Node addNode(Node currentNode, int value) {

		if (currentNode == null)
			return new Node(value);
		if (currentNode.value > value) {
			currentNode.left = addNode(currentNode.left, value);
		} else if (currentNode.value < value) {
			currentNode.right = addNode(currentNode.right, value);
		}
		return currentNode;
	}

	void leftView(Node currentNode, int level) {

		if (null != currentNode) {

			if (maxLevel < level) {

				System.out.println(currentNode.value + " ");
				maxLevel = level;
			}

			leftView(currentNode.left, level + 1);
			leftView(currentNode.right, level + 1);

		}

	}
	
	void rightView(Node currentNode, int level) {

		if (null != currentNode) {

			if (maxLevel < level) {

				System.out.println(currentNode.value + " ");
				maxLevel = level;
			}

			rightView(currentNode.right, level + 1);
			rightView(currentNode.left, level + 1);
			

		}

	}

	public static void main(String[] args) {

		BinaryTreeAndLeftRightView bl = new BinaryTreeAndLeftRightView();
		bl.add(6);
		bl.rootNode.right = new Node(8);
		bl.rootNode.left = new Node(5);
		bl.rootNode.right.left = new Node(7);
		bl.rootNode.right.right = new Node(9);

		System.out.println("Left  biew");
		bl.leftView(bl.rootNode, 1);
		
		System.out.println("Right biew");
		maxLevel = 0;
		BinaryTreeAndLeftRightView tree = new BinaryTreeAndLeftRightView();
        tree.rootNode = new Node(1);
        tree.rootNode.left = new Node(2);
        tree.rootNode.right = new Node(3);
        tree.rootNode.left.left = new Node(4);
        tree.rootNode.left.right = new Node(5);
        tree.rootNode.right.left = new Node(6);
        tree.rootNode.right.right = new Node(7);
        tree.rootNode.right.left.right = new Node(8);
        tree.rightView(tree.rootNode, 1);
	}

}

class Node {
	int value;
	Node left;
	Node right;

	Node(int v) {
		this.value = v;
		this.left = null;
		this.right = null;
	}
}
