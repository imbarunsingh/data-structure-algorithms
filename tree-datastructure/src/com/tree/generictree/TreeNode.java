package com.tree.generictree;

public class TreeNode {
	
	private Object data;
	private TreeNode firstChild;
	private TreeNode nextSiblings;

	public TreeNode(Object data) {
		super();
		this.data = data;
	}

	public TreeNode(Object data, TreeNode firstChild, TreeNode nextSiblings) {
		super();
		this.data = data;
		this.firstChild = firstChild;
		this.nextSiblings = nextSiblings;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public TreeNode getFirstChild() {
		return firstChild;
	}

	public void setFirstChild(TreeNode firstChild) {
		this.firstChild = firstChild;
	}

	public TreeNode getNextSiblings() {
		return nextSiblings;
	}

	public void setNextSiblings(TreeNode nextSiblings) {
		this.nextSiblings = nextSiblings;
	}
}
