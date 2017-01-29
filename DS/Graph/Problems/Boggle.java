
// TO do....
class Boggle  {

	String[] dictionary;

	public String[] getWords(String[] dictionary, int[][] boggle) {

		String[] wordList = new String[dictionary.length];

		int m = boggle.length;

		for (int i = 0 ; i < m; i++) {
			for (int j = 0 ; j < boggle[i].length; j++) {
				String temp = ""+boggle[i][j];
				while(isPrefix(temp)){
					temp += boggle[i+1][j];					
				}

				while(isPrefix(temp)){
					temp += boggle[i][j+1];					
				}

				while(isPrefix(temp)){
					temp += boggle[i+1][j+1];					
				}
				
			}
		}
		return wordList;
	}

	public boolean isWord(String str) {
		for (String s : dictionary) {
			if (str.equals(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPrefix(String str) {
		for (String s : dictionary) {
			if (s.startsWith(str)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
		char  boggle[][]   = {{'G', 'I', 'Z'},
			{'U', 'E', 'K'},
			{'Q', 'S', 'E'}
		};
	}
}