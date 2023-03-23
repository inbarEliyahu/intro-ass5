/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2018 
---------------------------------------*/

public class Bank {
/**this class represent the bank itself, which organized in a 2 tree form.
 * the first tree organized the accounts by lexicographic order of names/
 * the second tree organized the accounts by the classic <=of the account number.
 *@author <inbar eliyahu> */
	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	/**this difines the function */
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}
/** This method gets the name and gives you account in Bank management system with the name "name" if any.
 *
 *  @returns account in the back,if there is not then a null value*/
	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	/**This method gets the management system account with bank account number if any.
	 *
	 *  @returns deta of the account ,null value if there is not*/
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	/**This method preserves the effectiveness of the Bank's activity in that it balances
	 *  the saving of data in a way that may adversely affect the data.
	 * */
	public void balance(){
		namesTree.balance();
		accountNumbersTree.balance();
	}
	/**this method is exporting the search tree of names from this class,that it could be use outside this class. */
	public Object exportNames() {
		return this.namesTree;
	}
	/**this method is exporting the search tree of names from this class,that it could be use outside this class. */
	public Object exportAccountNumbers() {
		return this.accountNumbersTree;
	}
	
	// END OF Given code -----------------------------------
	/**this method adds a new account to the bank.
	 * @param newAccount is the new account that need to add
	 * @return if the account add- true; else, false.
	 * */
	//Complete the following method
	public boolean add(BankAccount newAccount) {
		if(lookUp(newAccount.getName())==null&lookUp(newAccount.getAccountNumber())==null){
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
			balance();
			return true;
		}
		else
			return false;

	}
	/**this method removes a account from the bank.
	 * @param name is the name of the owner of the account that need to be removed
	 * @return if the account removed- true; else, false.
	 * */
	//Complete the following method
	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:
		if(toRemove!=null){
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			balance();
			return true;
		}
		else
			return false;
	}
	/**this method removes a account from the bank.
	 * @param accountNumber is the number of the account that need to be removed
	 * @return if the account removed- true; else, false.
	 * */
	//Complete the following method
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		if(toRemove!=null){
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			balance();
			return true;
		}
		else
			return false;
	}
	/**this method deposit money to a specific  account.
	 * @param accountNumber is the number of the account that need to be added money to.
	 * @param amount the amount of money to deposit
	 * @return if the money add- true; else, false.
	 * */
	//Complete the following method
	public boolean depositMoney(int amount, int accountNumber){
if(lookUp(accountNumber)!=null){
	lookUp(accountNumber).depositMoney(amount);
	return true;
}
	else
		return false;
	}
	/**this method withdraw money from a specific  account.
	 * @param accountNumber is the number of the account that need to be remove money from.
	 * @param amount the amount of money to withdraw
	 * @return if the money removed- true; else, false.
	 * */
	//Complete the following method
	public boolean withdrawMoney(int amount, int accountNumber){

		if(lookUp(accountNumber)!=null){
			lookUp(accountNumber).withdrawMoney(amount);
			return true;
		}
		else
			return false;
	}
	


}
