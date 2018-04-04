class Substringof
{
public static void main (String args[])
{
String s ="sakshi";
String sub;
int len=s.length();
for(int c=0;c<len;c++)
{
for(int i=1; i<=len-c ;i++)
{
sub= s.substring(c,c+i);
System.out.println("Substring of a string is :" +sub);
}
}
}
}
