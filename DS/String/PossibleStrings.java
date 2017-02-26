import java.util.*;

class PossibleStrings {

	public static List<String> getStrings(String s) {

		List<String> list = new ArrayList<>();

		for (int i = 0 ; i < s.length(); i++) {
			String sub1 = s.substring(0, i) + s.charAt(i) + " " + s.substring(i + 1);
			list.add(sub1);
		}

		return list;
	}

	// with bugs
	public static Set<String> getStrings2(String s) {

		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < s.length(); i++) {
			sb.append(s.charAt(i)+" ");	
		}		

		System.out.println(sb.toString());

		String t = sb.toString();

		Set<String> set = new HashSet<>();

		set.add(t);
		System.out.println(" " +s.length() );
		System.out.println(" " +sb.length() );
		while(true){
					//System.out.println(" " +s.length() );
		
			if(sb.length() == s.length()){
				break;
			}

			if(sb.charAt(sb.length()-2) != ' '){
				for (int i = sb.length()-2; i >= 0 ; i-- ) {
					if(sb.charAt(i) == ' '){
						sb = new StringBuilder(sb.substring(0,i)+sb.substring(i+1,sb.length())+ ' '+
							sb.charAt(sb.length()-1));
						set.add(sb.toString());
						System.out.println("Adding " +sb.toString() );
						System.out.println(" " +sb.length() + sb.toString()+"*****");
					}	
				}
			}
			else {
				set.add(sb.toString());
				//System.out.println("Adding " +sb.toString() );
				sb = new StringBuilder(sb.substring(0,sb.length()-1)+
							sb.charAt(sb.length()-1));
			}

		}

		return set;
	}


	public static void main(String[] args) {
		String s = "ABCD";

		Set<String> set = getStrings2(s);



		for (String str : set) {
			System.out.println(str);
		}

	}
}