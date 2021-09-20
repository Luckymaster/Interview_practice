public class BinaryTree {

	Node node;

	public void add(int value) {
		node = add(node, value);
	}

	public boolean contains(int value) {
		return contains(node, value);
	}

	public void delete(int value) {
		node = delete(node, value);
	}

	public int smallestElement() {
		return findSmall(node);
	}

	private Node add(Node curentNode, int value) {

		if (curentNode == null) {
			return new Node(value);
		}
		if (curentNode.value > value) {
			curentNode.left = add(curentNode.left, value);
		} else if (curentNode.value < value) {
			curentNode.right = add(curentNode.right, value);
		} else {
			return curentNode;
		}
		return curentNode;
	}

	private boolean contains(Node currentNode, int value) {
		if (currentNode == null) {
			return false;
		}
		if (currentNode.value == value) {
			return true;
		}
		return currentNode.value > value ? contains(currentNode.left, value) : contains(currentNode.right, value);
	}

	private Node delete(Node currentNode, int value) {

		if (currentNode == null)
			return null;

		if (currentNode.value == value) {

			if (currentNode.left == null && currentNode.right == null) {
				return null;
			}

			if (currentNode.left == null) {
				return currentNode.right;
			}

			if (currentNode.right == null) {
				return currentNode.left;
			}

			int smallectElement = findSmall(currentNode.right);
			currentNode.value = smallectElement;
			currentNode.right = delete(currentNode.right, smallectElement);
			return currentNode;
		}

		if (currentNode.value > value) {
			currentNode.left = delete(currentNode.left, value);
			return currentNode;
		}

		currentNode.right = delete(currentNode.right, value);
		return currentNode;

	}

	private int findSmall(Node node) {
		return node.left == null ? node.value : findSmall(node.left);
	}

	public void preOrderTravershal(Node node) {

		if (null != node) {
			visit(node.value);
			preOrderTravershal(node.left);
			preOrderTravershal(node.right);

		}
	}

	public void postOrderTravershal(Node node) {

		if (null != node) {
			postOrderTravershal(node.left);
			postOrderTravershal(node.right);
			visit(node.value);
		}
	}

	public void inOrderTravershal(Node node) {

		if (null != node) {
			inOrderTravershal(node.left);
			visit(node.value);
			inOrderTravershal(node.right);

		}
	}

	private void visit(int value) {
		System.out.print(value + " ");

	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.add(10);
		tree.add(5);
		tree.add(4);
		tree.add(2);
		tree.add(1);
		tree.preOrderTravershal(tree.node);
		System.out.println();
		tree.inOrderTravershal(tree.node);
		System.out.println();
		tree.postOrderTravershal(tree.node);

	}
}

class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		this.right = null;
		this.left = null;
	}

}
