import java.awt.List;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
    import java.io.PrintWriter;
	import java.util.Random;
	import java.util.Scanner;
	/**
	*Name: Duy TRuong
	*Class: CS 3345
	*Section: 003
	*Semester: Fall 2018
	*Project: 5
	*Description: This program analyzes the run time of quicksort for each way of choosing the pivot 
	*/ 
public class mainclass 
{	
	private static final int CUTOFF = 10;
	public static void main(String[] agrs) throws IOException
	{
		Scanner kb = new Scanner(System.in);
		
		int select;
		do
		{
			System.out.println("Select a size for the list:\n0. Exit\n"
					+ "1. 100\n"
					+ "2. 1000\n"
					+ "3. 5000\n"
					+ "4. 10000\n"
					+ "5. 50000\n");
			
			
			select = kb.nextInt();
			if(select!=0)
			{
				//open file to write the outputs
				PrintWriter outfile2 = new PrintWriter("sorted.txt");
				PrintWriter outfile1 = new PrintWriter("unsorted.txt");
				int size=0;
				switch(select)
				{
					case 1:
						size =100;
						break;
					case 2:
						size =1000;
						break;
					case 3:
						size =5000;
						break;
					case 4:
						size= 10000;
						break;
					case 5: 
						size =50000;
						break;
					default:
						break;
				}
				
				int i, j;
				long endtime, starttime, totaltime;
				
				
				
					//create an array1 with random elements
					int[] array1= arrayMaker(size);
					i=0;
					outfile1.println("--4 UNSORTED LISTS: ");
					outfile1.println("-First element as pivot sort:");
					while(i<array1.length)
					{
						outfile1.print(array1[i]+" ");
						i++;
					}
					outfile1.println();
					//measure the run time of sort 1
					starttime= System.nanoTime();
					quickSortUsingFirst(0,size-1,array1);
					endtime =System.nanoTime();
					totaltime = endtime-starttime;
					System.out.println("----------------------------------------------");
					System.out.println("-First element as pivot sort");
					System.out.println("-RUNNING TIME = " +totaltime +"(ns)");
					System.out.println("----------------------------------------------");
					j=0;
					outfile2.println("---4 SORTED LISTS: ");
					outfile2.println("-First element as pivot sort:");
					while(j<array1.length)
					{
						outfile2.print(array1[j]+" ");
						j++;
					}
					outfile2.println();
					
					
					
					//create an array2 with random elements
					int[] array2 =arrayMaker(size);
					i=0;
					outfile1.println("-Randomly choosing the pivot element:");
					while(i<array2.length)
					{
						outfile1.print(array2[i]+" ");
						i++;
					}
					outfile1.println();
					//measure the run time
					starttime= System.nanoTime();
					QuickSortRandom(0,size-1,array2);
					endtime =System.nanoTime();
					totaltime = endtime-starttime;
					System.out.println("-Randomly choosing the pivot element");
					System.out.println("-RUNNING TIME = " +totaltime +"(ns)");
					System.out.println("----------------------------------------------");
					j=0;
					outfile2.println("-Randomly choosing the pivot element:");
					while(j<array2.length)
					{
						outfile2.print(array2[j]+" ");
						j++;
					}
					outfile2.println();
					
					
					
					
					//create an array3 with random elements
					int[] array3= arrayMaker(size);
					i=0;
					outfile1.println("-Choosing the median of 3 randomly chosen elements as the pivot:");
					while(i<array3.length)
					{
						outfile1.print(array3[i]+" ");
						i++;
					}
					outfile1.println();
					//measure the run time
					starttime= System.nanoTime();
					quickSort3(0,size-1,array3);
					endtime =System.nanoTime();
					totaltime = endtime-starttime;
					System.out.println("-Choosing the median of 3 randomly chosen elements as the pivot");
					System.out.println("-RUNNING TIME = " +totaltime +"(ns)");
					System.out.println("----------------------------------------------");
					j=0;
					outfile2.println("-Choosing the median of 3 randomly chosen elements as the pivot:");
					while(j<array3.length)
					{
						outfile2.print(array3[j]+" ");
						j++;
					}
					outfile2.println();
					
					
					
					
					//create an array4 with random elements
					int[] array4= arrayMaker(size);
					i=0;
					outfile1.println("-Median of first center and last element (book technique):");
					while(i<array4.length)
					{
						outfile1.print(array4[i]+" ");
						i++;
					}
					outfile1.println();
					//measure the run time
					starttime= System.nanoTime();
					quickSortUsingMedianOfFirstCentreLast(0,size-1,array4);
					endtime =System.nanoTime();
					totaltime = endtime-starttime;
					System.out.println("-Median of first center and last element (book technique)");
					System.out.println("-RUNNING TIME = " +totaltime +"(ns)");
					System.out.println("----------------------------------------------");
					j=0;
					outfile2.println("-Median of first center and last element (book technique):");
					while(j<array4.length)
					{
						outfile2.print(array4[j]+" ");
						j++;
					}
					outfile2.println();
					
				System.out.println("CHECK!!!!THE UNSORTED LISTS AND SORTED LISTS WERE WRITTEN IN 2 OUTPUT FILES!---");outfile1.close();
				outfile2.close();
			}	
		}while(select!=0);
		
	}
	
	/*
	 *-------------------------------------------------------------
	 *-------------------------------------------------------------
	 * **************First element as pivot********************
	 *  -------------------------------------------------------------
	 * -------------------------------------------------------------
	 */
	 public static void quickSortUsingFirst( int start, int end,int array[])
	  {
		  int i = start; // index of left-to-right scan
		  int k = end; // index of right-to-left scan

		  if (end - start >= 1) // check that there are at least two elements to sort
		  {
			  int pivot = array[start]; // set the pivot as the first element in the partition
	  
			  while (k > i) // while the scan indices from left and right have not met,
			  {
				  while (array[i] <= pivot && i <= end && k > i) // from the left, look for the first
					  i++; // element greater than the pivot
				  while (array[k] > pivot && k >= start && k >= i) // from the right, look for the first
					  k--; // element not greater than the pivot
				  	if (k > i) // if the left seekindex is still smaller than
				  		swap( i, k,array); // the right index, swap the corresponding elements
			  }
			  swap(start, k,array); // after the indices have crossed, swap the last element in
	  // the left partition with the pivot
	  quickSortUsingFirst( start, k - 1,array); // quicksort the left partition
	  quickSortUsingFirst(k + 1, end,array); // quicksort the right partition
	  }
	  else // if there is only one element in the partition, do not do any sorting
	  {
	  return; // the array is sorted, so exit
	  }
	  }
 /* 
  *------------------------------------------------------------
  * -------------------------------------------------------------
  *-----------Randomly choosing the pivot element----------------
  * -------------------------------------------------------------
  *-------------------------------------------------------------
 */
	 public static void QuickSortRandom(int left, int right, int[] a) 
	    {
	        if (right - left <= 0)
	            return;
	        else 
	        {
	            Random rand = new Random();
	            int pivotIndex = left + rand.nextInt(right - left + 1);
	            swap(pivotIndex, right,a);
	 
	            int pivot =a[right];
	            int partition = partitionIt(left, right, pivot,a);
	            QuickSortRandom(left, partition - 1,a);
	            QuickSortRandom(partition + 1, right,a);
	        }
	    }
	 
	    public static int partitionIt(int left, int right, long pivot, int[]a) 
	    {
	        int leftPtr = left - 1;
	        int rightPtr = right;
	        while (true) 
	        {
	            while (a[++leftPtr] < pivot)
	                ;
	            while (rightPtr > 0 && a[--rightPtr] > pivot)
	                ;
	 
	            if (leftPtr >= rightPtr)
	                break;
	            else
	                swap(leftPtr, rightPtr,a);
	        }
	        swap(leftPtr, right,a);
	        return leftPtr;
	    }
 /*
  * -------------------------------------------------------------
  * -------------------------------------------------------------
  * Choosing the median of 3 randomly chosen elements as the pivot
  * -------------------------------------------------------------
  * -------------------------------------------------------------
 */
		public static void quickSort3(int left, int right,int[]a) 
		{
			if( left + CUTOFF <= right )
		    {
		       int pivot = getMedian2(left,right,a); 
		       //begin partitioning 
		       int i = left;
	   		   int j=right-1;
	   		for(;;)
	   		{
	   			while(a[++i]<pivot) {}
	   			while(a[--j]>pivot)	{}
	   			if(i<j)
	   				swap(i,j,a);
	   			else 
	   				break;	
	   		}
	   		swap(i,right-1,a); //restore pivot
		        quickSortUsingMedianOfFirstCentreLast(left, i-1,a);
		        quickSort3(i+1, right,a);
		  }else
		  {
			  insertionSort( a, left, right );
		  }
		    }
		
		public static int getMedian2(int left, int right, int[] a)
		{
			Random rand = new Random();
		    int num1 = left + rand.nextInt(right - left + 1);
		    int num2 = left + rand.nextInt(right - left + 1);
		    int num3 = left + rand.nextInt(right - left + 1);
		    if(a[num2]< a[num1])
				swap(num1,num2,a);
			if(a[num3]<a[num1])
				swap(num1,num3,a);
			if(a[num3]<a[num2])
				swap(num3,num2,a);
			
			swap(num1,num3-1,a);
			return a[num3-1];
		}

/*
 * -------------------------------------------------------------
 * -------------------------------------------------------------
 ** Median of first center and last element (book technique)**. 
 *-------------------------------------------------------------
 * -------------------------------------------------------------
 */
public static void quickSortUsingMedianOfFirstCentreLast(int left, int right, int[]a)
{
	if( left + CUTOFF <= right )
    {		
    		//Pivot using median of 3 approach
    		int pivot = getMedian(left, right,a);
    		//begin partitioning 
    		int i = left;
    		int j=right-1;
    		for(;;)
    		{
    			while(a[++i]<pivot) {}
    			while(a[--j]>pivot)	{}
    			if(i<j)
    				swap(i,j,a);
    			else 
    				break;	
    		}
    		swap(i,right-1,a); //restore pivot
	        quickSortUsingMedianOfFirstCentreLast(left, i-1,a);
    		quickSortUsingMedianOfFirstCentreLast(i+1, right,a);
	  }else
	  {
		  insertionSort( a, left, right );
	  }

}		    
/*
 * get median method
 */
	public static int getMedian(int left, int right, int[] a)
	{
		int center = (left + right )/2;
		if(a[center]< a[left])
			swap(left,center,a);
		if(a[right]<a[left])
			swap(left,right,a);
		if(a[right]<a[center])
			swap(center,right,a);
		
		swap(center,right-1,a);
		return a[right-1];		
	}
   public static void insertionSort( int[ ] a,int left, int right )
    {
        int j;

        for( int p = 1; p < a.length; p++ )
        {
        	int tmp = a[ p ];
            for( j = p; j > 0 && tmp< a[ j - 1 ] ; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
	/*
	 * swap method
	 */
	public static void swap(int index1, int index2, int[] array)
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	/*
	 * array maker
	 */
	public static int[] arrayMaker(int size)
	{
		Random rand = new Random();
		int[] array = new int[size];
		int i=0;
		while(i<size)
		{
			array[i] = rand.nextInt(size) + 1;
			i++;
		}
		return array;
	}
	
}

