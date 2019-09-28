package project1;
import java.util.Scanner;

/**
*Name: Duy TRuong
*Class: CS 3345
*Section: 003
*Semester: Fall 2018
*Project: 1
*Description: This program is to print all primes smaller than or equal to n using Sieve of Eratosthenes
*/ 
public class Eratosthenes
{
	public static void main(String[] agrs)
{
	int N;
	Scanner keyboard = new Scanner(System.in);//create a Scanner object
	System.out.print("Enter a positive integer: ");
	N= keyboard.nextInt();//get the input
	
	boolean[] prime = new boolean[N+1];//create a boolean array as a table of numbers
	//mark everything true
	for(int i=0; i<=N;i++)
	{
		prime[i]=true;
	}
	//0 and 1 are not primes, so they are false
	prime[0]=false; 
	prime[1]=false;
	
	//apply the algorithm
	for(int factor=0; factor*factor<=N; factor++)
	{
		if(prime[factor])
		{
			for(int j= factor; j*factor<=N;j++)
			{
				prime[factor*j]=false;
			}
		}
	}
	//print all primes up till N 
	System.out.print("All the prime numbers till "+N +":  ");
	for(int i=0;i<=N;i++)
	{
		if(prime[i]==true)
		{
			System.out.print(i+"  ");
		}
	}
	
	
	
	
}
}
