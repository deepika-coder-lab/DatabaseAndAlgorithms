public class MoveZeroAtStart {

	static void moveZeroAtStart(int[] arr)
	{
		int reader =  arr.length-1;
		int writer = arr.length-1;
		while(reader>=0)
		{
			if(arr[reader]!=0)
			{
				arr[writer] = arr[reader];
				writer --;
			}
			reader --;
		}
		
		while (writer>=0)
		{
			arr[writer]=0;
			writer --;
		}
		for (int i:arr) {
			System.out.println(i);
		}
	}
	public static void main(String args[]) {
		int a[]= {3,6,4,6,0,4,2,0,0};
		moveZeroAtStart(a);
	}
}
