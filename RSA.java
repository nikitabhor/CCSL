

import java.util.*;
import java.math.BigInteger;


class RSA{
    int num;
    public boolean isPrime(int num){
        boolean flag = true;
        if(num<=1)
        {
            flag= false;
        }
        for ( int i=2;i<num;i++)
        {
            if(num%i==0)
            {
                flag=false;
            }
        }
        return flag;
        
    }
    
   int gcd(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }   

   
    void algo(int p, int q,int msg){
        int n= p*q;
        int phi = (p-1)*(q-1);
        int e=2;
        while(e<phi){
            if(gcd(e,phi)==1){
                break;
            }
            else{
                e++;
            }
        }

        int d =BigInteger.valueOf(e).modInverse(BigInteger.valueOf(phi)).intValue();


        BigInteger E = BigInteger.valueOf(e);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger Msg = BigInteger.valueOf(msg);

        BigInteger C = Msg.modPow(E, N);
        
        BigInteger D = BigInteger.valueOf(d);
        
        BigInteger M = C.modPow(D, N); 

        System.out.println("Public key is "+e);
        System.out.println("Private key is "+d);
        System.out.println("Encrypted Message is "+C);
        System.out.println("Decrypted Message is "+M);
       

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RSA rsa = new RSA();
        
        System.out.println("Enter value of p");
        int p = sc.nextInt();
    while(rsa.isPrime(p)==false){
            System.out.println("Enter a prime number");  
            p = sc.nextInt();
        }
        
        System.out.println("Enter value of q");
        int q = sc.nextInt();
        while(rsa.isPrime(q)==false){
            System.out.println("Enter a prime number");
            q = sc.nextInt();
        }


        System.out.println("Enter Message");
        int msg = sc.nextInt();
        boolean f=false;

        if(msg<p*q){
            f=true;

        }
        while(!f){
            System.out.println("Enter a message less than "+p*q);
            msg = sc.nextInt();
            if(msg<p*q){
                f=true;
            }
            
        }
        rsa.algo(p,q,msg);
        sc.close();
    
    }
}

// Output
// Enter value of p
// 7
// Enter value of q
// 11
// Enter Message
// 9
// Public key is 7
// Private key is 43
// Encrypted Message is 37
// Decrypted Message is 9
