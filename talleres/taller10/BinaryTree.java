
public class BinaryTree {
	
	// Sirve como raíz del árbol
	public Node root;

    public void insertar(int n) {
        if (root == null) {
            root = new Node(n);
        } else {
            insertarAux(root, n);
        }
    }

    private void insertarAux(Node node, int n) {
        if (node == null) {
            node = new Node(n);
        }
        if (n > node.data) {
            if (node.right == null) {
                node.right = new Node(n);
            }
            insertarAux(node.right, n);
        }
        if (n < node.data) {
            if (node.left == null) {
                node.left = new Node(n);
            }
            insertarAux(node.left, n);
        }
    }

    public boolean buscar(int n) {
        return buscarAux(root, n);
    }
    
	private boolean buscarAux(Node node, int n) {
	   if (node == null) {
            return false;
        }
        if (n == node.data) {
            return true;
        }
        if(n < node.data){
		return buscarAux(node.left, n);
	}else{
		return buscarAux(node.right, n);
	}
    }
	
    public void borrar(int n) {
        borrarAux(root, n);
    }

     private Node borrarAux(Node node, int n) {
    }



    /*
	 
	 Los metodos posteriores son para imprimir el arbol de manera
	 que sirven para debuggeo

	private void recursivePrintAUX(Node node)
	{
		if (node != null)
		{
			recursivePrintAUX(node.left);
			recursivePrintAUX(node.right);
			System.out.println(node.data);
		}
		
	}

	/**
	* Metodo auxiliar de recursivePrintAUX
	*
	*/
	public void recursivePrint()
	{
		recursivePrintAUX(root);
	}
		

	
 
}
