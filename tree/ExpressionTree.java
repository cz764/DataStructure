package tree;

public class ExpressionTree
//creates an expression tree 
//prints infix expression
//prints postfix expression
//evaluates the expression (postorder)
{
	public static void main(String [] args)
	{
		Btree expressionTree = new Btree();
		expressionTree.build();
		System.out.println("inorder traversal");
		expressionTree.infix();
		System.out.println("postorder traversal");
		expressionTree.postfix();
		System.out.println ("evaluates to: " + expressionTree.evaluate());
	}
}

class TreeNode
{
	Object element;
	TreeNode left;
	TreeNode right;
	
	public TreeNode (Object o)
	{
		this (o, null, null);
	}

	public TreeNode (Object o, TreeNode l, TreeNode r)
	{
		element = o;
		left = l;
		right = r;
	}

	public String toString()
	{
		return "" + element;
	}
}

class Btree
{
	
	private TreeNode root;
	
	public Btree ()
	{
		root = null;
	}

	private void leftChild(TreeNode t, Object o)
	//create a left child for node t
	{
		t.left =  new TreeNode(o);
	}
	
	private void rightChild(TreeNode t, Object o)
	//create a right child for node t
	{
		t.right =  new TreeNode(o);
	}
	
	public void build()
	{
		root =  new TreeNode(new Character('+') );
		leftChild(root, new Character('*') );
		rightChild(root, new Character('5') );
		leftChild(root.left, new Character('3'));
		rightChild(root.left, new Character('4'));
	}
	
	public void infix()  //used as a driver for real infix method
	{
		infix(root);
		System.out.println();
	}
	
	private void infix(TreeNode t)  
	{
		if(t.left != null)  //assume all operators are binary operands
		{
			System.out.print("("); 
			infix(t.left);
		}
		System.out.print(t );
		if(t.left != null)  //assume all operators are binary operands
		{
			infix(t.right);
			System.out.print(")");
		}
	}

	public void postfix()  //used as a driver for real postfix method
	{
		postfix(root);
		System.out.println();
	}
	
	private void postfix(TreeNode t)
	{
		if(t != null)
		{
			postfix(t.left);
			postfix(t.right);
			System.out.print(t);
		}
	}

	public int evaluate()
	{
		return evaluate(root);
	}

	private int evaluate(TreeNode t)
	{
		if(t.left == null)	//assume binary operators
			return (((Character)t.element).charValue()) - '0';
		else  
		{
			int left = evaluate (t.left);
			int right = evaluate (t.right);
			switch (((Character)t.element).charValue())
			{
			case '+':
				return left + right; 
			case '-':
				return left - right; 
			case '*':
				return left * right; 
			case '/':
				return left / right; 
			}
		}
		return 0;  //we will never get here
	}
}

