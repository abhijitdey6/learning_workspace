package dsa;

public class CharacterFrequency {

	public static void main(String[] args) {
		String str="Picture Perfect";
		int[] freq=new int[str.length()];
		int i,j;
		
		char[] charArr = str.toCharArray();
		
		for(i=0; i<str.length(); i++) {
			freq[i] = 1;
			for(j=i+1; j<str.length(); j++) {
				if(charArr[i] == charArr[j]) {
					freq[i]++;
					charArr[j]='0';
				}
			}
		}
		
		System.out.println("Characters and their corresponding frequencies");  
        for(i = 0; i <freq.length; i++) {  
            if(charArr[i] != ' ' && charArr[i] != '0')  
                System.out.println(charArr[i] + "-" + freq[i]);  
        }  

	}

}
