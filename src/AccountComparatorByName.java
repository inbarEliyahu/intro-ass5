/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2018 
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByName implements Comparator<BankAccount>{

	@Override
	//Complete the following method
	public int compare(BankAccount account1, BankAccount account2) {
		//String name1=account1.getName(),name2=account2.getName();
		/*int output=0,index=0;
		while(name1.length()>index&name2.length()>index&output==0) {
			output = name1.charAt(index) - name2.charAt(index);
			index = index + 1;
		}
		if(output==0&name1.length()>name2.length())
			output=-1;
		if (output==0&name1.length()<name2.length())
			output=1;
			return output ;*/

		return account1.getName().compareTo(account2.getName());
	}



}
