package Pack1;
import java.util.*;
public class Driver {
	
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("PLease enter the key(depth of row)");
		int n =input.nextInt();
		input.nextLine();
		System.out.println("please enter plan text");
		String plan=input.nextLine();
		System.out.println(Encription(n, plan));
		System.out.println(Decryption(n, Encription(n, plan)));

		
	}
	
	public static String Encription(int depth,String plan) {
		String [][]array=new String[depth][plan.length()];
		String cipher="";
		
		int i=0,j=0;
		while(true) {
			if(i==0) {
				while(i<depth) {
					if(j==plan.length()) {
						break;
					}
					
					array[i][j]=plan.charAt(j)+"";
					i++;
					j++;
				}
			}
			
			
			else if(i==depth) {
				i=i-2;
				while(i>0) {
					if(j==plan.length()) {
						break;
					}
					
					
					array[i][j]=plan.charAt(j)+"";


							i--;
					j++;
				}
				
			
			}
			
			if(j==plan.length()) {
				break;
			}
		}
		
		for( i=0;i<array.length;i++) {
			for(j=0;j<array[i].length;j++) {
				if(array[i][j]==null) {
					continue;
					
				}else {
					cipher=cipher+array[i][j];

				}
			}
		}
	
		return cipher;
		
		
	}
	public static String Decryption(int depth, String cipher) {
	    String[][] array = new String[depth][cipher.length()];
	    int i = 0, j = 0, k = 0;

	    while (j < cipher.length()) {
	        if (i == 0 || i == depth - 1) {
	            array[i][j] = cipher.charAt(k) + "";
	            i++;
	            j++;
	        } else {
	            array[i][j] = cipher.charAt(k) + "";
	            i--;
	            j++;
	        }
	        k++;
	    }

	    StringBuilder plaintext = new StringBuilder();

	    for (i = 0; i < array.length; i++) {
	        for (j = 0; j < array[i].length; j++) {
	            if (array[i][j] != null) {
	                plaintext.append(array[i][j]);
	            }
	        }
	    }

	    return plaintext.toString();
	}
	
	

}
