import java.util.Iterator;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

    private BankAccountsBinarySearchTree bankAccountsTree;
    private BankAccount current;

    //Complete the following method
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree) {
this.bankAccountsTree= new BankAccountsBinarySearchTree(bankAccountsTree.comparator);
        Iterator<BankAccount> it=new BinaryTreeInOrderIterator<BankAccount>(bankAccountsTree.root);
        while(it.hasNext()) {
            BankAccount temp = it.next();
            if (temp.getBalance() > 100) {
                this.bankAccountsTree.insert(temp);
                this.bankAccountsTree.balance();
            }
        }
this.current=this.bankAccountsTree.root.data;
        }


    //Complete the following method
    @Override
    public boolean hasNext() {
        Iterator<BankAccount> IT= new BinaryTreeInOrderIterator<BankAccount>(this.bankAccountsTree.root);
        if (IT.hasNext())
            return true;
        else
            return false;
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        Iterator<BankAccount> IT = new BinaryTreeInOrderIterator<BankAccount>(this.bankAccountsTree.root);
        BankAccount TEMP = IT.next();
        this.bankAccountsTree.remove(TEMP);
        return TEMP;
    }
    public void remove() {
        return;
    }
}
