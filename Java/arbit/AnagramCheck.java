class AnagramCheck  {
    
 

static boolean isAnagram() {

String str1 ="cat";
String str2 ="tac";
int count =0;

    for(int i =0;i<str1.length();i++)
    {
        for (int j=0;j<str2.length();j++)
        {
         if(str1.charAt(i)==str2.charAt(j))
         
             
                count=count +1;
                
                
            
            if(count>0)
            {
                System.out.println("String is anagram:");

            }
            else 
            {
                System.out.println ("String is not anagram");
            }
        }
    }    

    return false;
}

    public static void main(String[] args) {
        
        System.out.println(isAnagram());

    }

}