import java.math.BigInteger;
import java.util.*;
public class DES{
    int n;
    
        void rithm(int p, int g,int a,int b){
            BigInteger  g1 = BigInteger.valueOf(g);
            BigInteger  b1 = BigInteger.valueOf(b);
            BigInteger  p1 = BigInteger.valueOf(p);
            BigInteger  a1 = BigInteger.valueOf(a);

            BigInteger YA =g1.modPow(a1,p1);
            BigInteger XB =YA.modPow(b1,p1);
            BigInteger YB =g1.modPow(b1,p1);
            BigInteger XA =YB.modPow(a1,p1);

            System.out.println("Secret key of A is:"+XA);
            System.out.println("Secret key of A is:"+XB);




        } 
        
        
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    DES obj = new DES();
    System.out.println("enter prime number:");
    int p =sc.nextInt();
  

   
    System.out.println("enter primitive roots;");
    int g = sc.nextInt();
    System.out.println("enter private key of A;");
    int b = sc.nextInt();
    System.out.println("enter private key of B;");
    int a = sc.nextInt();
    obj.rithm(p,g,b,a);
}
     }
