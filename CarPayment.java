import java.util.*;
public class CarPayment {

	static public void main(String[] args)
	{
		List<Integer> payments = new ArrayList<Integer>();
		Scanner myscan = new Scanner(System.in);
		int lastInt = 0;
		while(lastInt != -1)
		{
			System.out.print("Your Payment: ");
			lastInt = myscan.nextInt();
			if(lastInt != -1)
				payments.add(lastInt);
		}
		if(payments.size() == 0)
		{
			System.out.println("No Car Payments");
			myscan.close();
			return;
		}
		int min = Collections.min(payments);
		int max = Collections.max(payments);
		
		// get mode
		int maxValue = 0, maxCount = 0;
		
	    for (int i = 0; i < payments.size(); ++i) {
	        int count = 0;
	        for (int j = 0; j < payments.size(); ++j) {
	            if (payments.get(j) == payments.get(i)) ++count;
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            maxValue = payments.get(i);
	        }
	    }
	    int mode = maxValue;
	    double sum = 0;
	    for( int i : payments)
			sum += i;
		System.out.println("Min Payment: " + min);
		System.out.println("Max Payment: " + max);
		System.out.println("Sum Of Payments" + (int) sum);
		System.out.println("Average Payment: " + sum/payments.size());
		System.out.println("Modal Payment: " + mode);
		myscan.close();
	}
	
}
