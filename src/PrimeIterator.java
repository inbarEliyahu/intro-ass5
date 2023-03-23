/*---------------------------------------
 Genuine author: <INBAR ELIYAHU>, I.D.: <205414824>
 Date: 01-01-2018
---------------------------------------*/
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {

    private List<Integer> primes;
/**this function is making the posiability of getting a new prime number each time you are caling this method*/
	//Complete the following method
    public PrimeIterator(){
        primes= new LinkedList<Integer>();
        Iterator<Integer> PrimeIterator=this.primes.iterator();
    }

	//Complete the following method
    public boolean hasNext(){
    	return true;
    }

	//Complete the following method
    public Integer next() {
        if (primes.size() == 0) {
            this.primes.add(2);
            return 2;
        } else {
            boolean find = false;
            Integer output = primes.get(primes.size() - 1);
            while (!find) {
                output = output + 1;
                boolean isprime = true;
                Iterator<Integer> PRIM = primes.iterator();
                while (PRIM.hasNext() & isprime) {
                    Integer TMP = PRIM.next();
                    if (output!=TMP&output % TMP == 0)
                        isprime = false;
                }
                if (isprime)
                    find = true;
            }

            this.primes.add(output );
            return output ;
        }
    }
	//DO NOT REMOVE OR CHANGE THIS MEHTOD – IT IS REQUIRED 
	public void remove() {
		return;
	}


}
