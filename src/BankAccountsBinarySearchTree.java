/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2018 
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	//Complete the following method
	/**this function is macking the most useful data saving by re-organizing the accounts in the bank.*/
	public void balance(){

		BankAccountsBinarySearchTree tree = new BankAccountsBinarySearchTree(this.comparator);
		Iterator<BankAccount> iter=new BinaryTreeInOrderIterator<BankAccount>(this.root);
		List<BankAccount> list= new LinkedList<>();
		int index=0;
		while(iter.hasNext()){
			list.add(index,iter.next());
			index++;
		}

		buildBalancedTree(tree,list,0,list.size()-1);
		this.root=tree.root;
}
	
	//Complete the following method
	private void buildBalancedTree(BankAccountsBinarySearchTree tree, List<BankAccount> list, int low, int high){
		if(low<=high){
			int middle =(1+low+high)/2;
			tree.insert(list.get(middle));
			buildBalancedTree(tree,list,0,middle-1);
			buildBalancedTree(tree,list,middle+1,high);
		}
	}

	public Iterator<BankAccount> iterator(){
		return new FilteredBankAccountsIterator(this);
	}
	
}
