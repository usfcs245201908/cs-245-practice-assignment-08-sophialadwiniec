
public class BST<T extends Comparable<T>> {

  private class Node{
     
    Node(Comparable value){
      data = value;
      left = right = null;
    }

    Comparable data;
    Node left; 
    Node right;
  }

  private Node root;

  public BST() {
    root = null;
  }

  public void insert(Comparable item) {
    root = insert(item, root); 
   }
   public Node insert(Comparable item, Node node){
   	 if (node == null)
      return new Node(item);
  	else if(node.data.compareTo(item) < 0){
  		node.right = insert(item, node.right); 
  	}
  	else{
  		node.left = insert(item, node.left); 
  	}
  	return node; 
   }

  public void delete(Comparable item){
  	 root = delete(root,item); 
  }

  public Node delete(Node tree, Comparable elem){
    if(tree == null)
        return null;
    if(tree.data.compareTo(elem)==0){
      if(tree.left==null)
        return tree.right;
      else if(tree.right==null)
        return tree.left;
    else{
      if(tree.right.left==null){
          tree.data=tree.right.data;
          tree.right=tree.right.right;
          return tree;
      }

    else{
      tree.data=removeSmallest(tree.right);
      return tree;
    }
  }
  }

else if(elem.compareTo((T)tree.data) < 0){
tree.left = delete(tree.left, elem);
return tree;
}

else{
tree.right = delete(tree.right, elem);
return tree;
}
  }


  public Comparable removeSmallest(Node node){
  	if(node.left.left == null){
  		Comparable smallest = node.left.data; 
  		node.left = node.left.right; 
  		return smallest; 
  	}
  	else{
  		return removeSmallest(node.left); 
  	}
  }

  public void print(){
  	print(root); 
  }

  public void print(Node node){
  	if(node != null){
  		print(node.left); 
  		System.out.println(node.data); 
  		print(node.right); 
  	}
  }


  public boolean find(Comparable item) {
   return find(item,root); 
  }


  public boolean find(Comparable item, Node node){
  	if(node == null){
  		return false; 
  	}
  	if(node.data.compareTo(item) == 0){
  		return true; 
  	}
  	else if(node.data.compareTo(item) < 0){
  		return find(item, node.right); 
  	}
  	else{
  		return find(item, node.left); 
  	}
  }
  
}


