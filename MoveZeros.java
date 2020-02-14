public class MoveZeros {
	
	static void moveZeroAtEnd(int[] arr)
	{
		int reader = 0;
		int writer = 0;
		while(reader < arr.length)
		{
			if(arr[reader]!=0) {
				arr[writer] = arr[reader];
				writer ++;
			}
			reader++;
		}
		while(writer<arr.length)
		{
			arr[writer] = 0;
			writer++;
		}
		
		for(int i:arr)
		{
			System.out.println(i);
		}
	}

	public static void main (String args[])
	{
		int a[]= {5,0,6,7,2,0,8};
		moveZeroAtEnd(a);
	}
}
