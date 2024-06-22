package CSC212_EProject;

public class BT<T> {

	MNode<T> root, current;
	
	public BT() {
		root = current = null;
	}
	
	public boolean empty() {
		return root == null;
	}
	
	public T retrieve() {
		return current.data;
	}
	
	public void update(T val) {
		current.data = val;
	}
	
	public boolean insert (Relative rel,int key, T val) {
		switch (rel) {
			case Root:
				if (!empty()) return false;
				current = root = new MNode<T>(key, val);
				return true;
				
			case Parent:
				return false;
				
			case LeftChild:
				if (current. left != null) return false;
				current. left = new MNode<T> (key, val);
				current = current. left;
				return true;
				
			case RightChild:
				if (current. right != null) return false;
				current.right = new MNode<T>(key, val);
				current = current.right;
				return true;
			
			default:
				return false;
		}
	}
	
	
	//delete sub tree//
	
	
	public boolean find(Relative rel) {
		
		switch(rel) {
		
			case Root:
				current = root;
				return true;
			case Parent:
				if(current == root) return false;
				current = findparent(current, root);
				return true;
			case LeftChild:
				if(current.left == null) return false;
				current = current.left;
				return true;
			case RightChild:
				if(current.right == null) return false;
				current = current.right;
				return true;
			default:
				return false;
		}
	}
		
	private MNode<T> findparent(MNode<T> p, MNode<T> t) {
		LinkedStack<MNode<T>> stack = new LinkedStack<MNode<T>>();
		MNode<T> q = t;
		while(q.right != p && q.left != p) {
			if(q.right != null)
				stack.push(q.right);
			if(q.left != null)
				q = q.left;
			else
				q = stack.pop();
		}
		
		return q;
	}
	
	/*--Method to test if the path indicated by path and starting from t is valid--
	 * ------------A path is valid if its directions are available----------------
	 * -----------It complete the  task by calling recfollow method---------------
	 */
	public boolean follow(MNode<T> t, String path) {

		int n = path.length()/2 + 1;
		int m = 0;
		LinkedStack<Character> stack = new LinkedStack<Character>();
		
		while(n>0) {
			stack.push(path.charAt(m));
			n--;
			m += 2;
		}
		LinkedStack<Character> stack1 = new LinkedStack<Character>();
		
		while(!stack.empty())
			stack1.push(stack.pop());

		return recfollow(t, stack1);
	}

	/*--Recursive method to check if the stack elements--
	 * ------are available starting from maze node t----
	 */
	public boolean recfollow(MNode<T> t, LinkedStack<Character> stack) {
		
	    //--Base case--
		if(t == null) 
			return false;
		
		//--Recursive case--
		
		//Pop the top element from stack
		Character temp = stack.pop();
		
		//Check if temp value equal the data of t
		if(!temp.equals(t.data)) {
			if(!t.data.equals("X"))
				stack.push(temp);
			return false;
		}
		
		//--If stack isn't empty
		//--and t isn't a leaf node
		//--check if the right node or the left node equal temp.
		if(!stack.empty()) {
			if(t.left != null || t.right != null) {
				boolean flag = recfollow(t.left, stack);
				if(!flag && !stack.empty())
					return recfollow(t.right, stack);
					
				return flag;
			}
		}
		//--Check if t is a leaf nood and the stack is not empty
		if(t.left == null && t.right == null && !stack.empty()) {
			stack.push(temp);
			return false;
		}
		return true;
	}

	public boolean findKey(MNode<T> t, int k, boolean flag) {
				
	    //--Base case--		
		if(t.key == k) {
			current = t;
			return true;
		}
		
		//--Recursive case--
		if(flag == false && t.left != null) {
			flag = findKey(t.left, k, flag);
		}
		
		if(flag == false && t.right != null) {
			flag = findKey(t.right, k, flag);
		}
		
		return flag;
		
	}
	
	public String Short() {
        Stack<String> pathStack = new LinkedStack<String>(); //Create stack to store possibilities 
        String shortestPath = ""; // initialize string to store shortest paths 

        AllPaths(root, pathStack, ""); // Calling method AllPaths to check for a short path starting from the root

        int shortestPathLength = Integer.MAX_VALUE; //to set an initial value for the variable `shortestPathLength` that is higher than any possible path length . 

        while (!pathStack.empty()) // Check that the stack is not empty
        {
            String path = pathStack.pop(); // Store in the string the values popped from stack

            if (path.charAt(path.length() - 1) == 'X') // Check if the element stored = X , thu we know we found an exit
               
            if (path.length() < shortestPathLength) // check if the path length that we stored from the stack is less than
            {
                    shortestPathLength = path.length(); // update 
                    shortestPath = path;
            }
        }
        return shortestPath;
    } // end Short 
	
	private Relative getPathType(MNode<T> node) {
	    if (node.left != null && node.right != null) {
	        return Relative.Two_Children;
	    } else if (node.left != null) {
	        return Relative.LeftChild;
	    } else if (node.right != null) {
	        return Relative.RightChild;
	    } else {
	        return Relative.Leaf;
	    }
	}

	private void AllPaths(MNode<T> node, Stack<String> pathStack, String path)
    {
      if (node == null) 
      {
          return;
      }


      switch (getPathType(node)) {
          case Leaf:
              path += node.data.toString();
              pathStack.push(path);
              return;

          case Two_Children:
              AllPaths(node.left, pathStack, path + node.data.toString() + "-" );
              AllPaths(node.right, pathStack, path + node.data.toString() + "-" );
              break;

          case  LeftChild:
              AllPaths(node.left, pathStack, path + node.data.toString() + "-" );
              break;
              
          case RightChild:
              AllPaths(node.right, pathStack, path + node.data.toString() + "-" );
              break;
      }
  }

  
    /*--A boolean Method that searches for an exit starting at t using preorder traversal--
	 * ------------an exit is found if it was a leaf and have the X value as a data----------------
	 * ----------- using ---------------
	 */
    public boolean escape(MNode t) 
    {
    	if (t == null ) 
    		return false ; // we reach the leaf and an exit has been not found 
    	else if(t!= null && t.left == null && t.right == null ) //t is a leaf 
    	{ 
    		if (t.data.equals('X') )
    			return true ; // an exit has been found 
    			else
    			 return false ;
    		} 
    		else // when t it is not a leaf 
    		{
    			return (escape(t.left) || escape(t.right) ) ; 	// Recursively continue searching	
    		} 	
    } // end of escape method      
}