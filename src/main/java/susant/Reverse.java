package susant;

public class Reverse {
	public static void main(String args[]) {
		int[] Arr= {1,2,3,4,5,6,7,8,9,10};
		reverse(Arr);
		
	}
	public static void reverse(int[] Arr)
	{
		int temp=0;
		int middle=Arr.length/2;
		int end=Arr.length-1;
		int start=0;
		for(;start<middle;start++,end--)
		{
			temp=Arr[start];
			Arr[start]=Arr[end];
			Arr[end]=temp;
		}
	}
	

}
