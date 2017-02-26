import java.util.*;

class BinaryString {

	public static List<String> getStrings(String s) {
		if (s == null || s.length() == 0) return null;

		List<String> list = new ArrayList<>();

		List<Integer> indexList = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				indexList.add(i);
			}
		}

		for (int i = 0 ; i < indexList.size(); i++) {
			for(int j=i+1;j<indexList.size();j++){
				list.add(s.substring(indexList.get(i),indexList.get(j)+1));
			}
		}
		return list;
	}

	public static void main(String[] args) {
		
		String s = "00100101";
		List<String> list = getStrings(s);

		for(String str : list){
			System.out.println(str);
		}
	}

}