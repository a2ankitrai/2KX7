/*Segregate Even and Odd numbers
Given an array A[],
write a function that segregates even and odd numbers.
The functions should put all even numbers first, and then odd numbers*/

class SegregateEvenOdd {

	public static void segregate(int[] a) {

		int left = 0;
		int right = a.length - 1 ;

		while (left < right) {

			while (a[left] % 2 == 0 && left < right) {
				left++;
			}
			while (a[right] % 2 != 0 && left < right) {
				right--;
			}

			if (left < right) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				left++;
				right--;
			}

		}

	}

	public static void main(String[] args) {
		int arr[] = {12, 34, 45, 9, 8, 90, 3};
 
        segregate(arr);
 
        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
	}
}