package project;

public class MergeSort {
	private User[] users;
	private User[] helper;
	private int nElems;
	
	public MergeSort(User[] users){
		nElems = users.length;
		this.users = users;
	}

	public void sort(){
		this.helper = new User[nElems];
		mergesort(0, nElems - 1);
	}

	private void mergesort(int low, int high) {
		// check if low is smaller than high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = (high + low) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = users[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			//using to-string because to-string here return the nickName anyway;
			if (helper[i].toString().compareTo(helper[j].toString()) <=0 ) {
				users[k] = helper[i];
				i++;
			} else {
				users[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			users[k] = helper[i];
			k++;
			i++;
		}
		// Since we are sorting in-place any leftover elements from the right side
		// are already at the right position.

	}
	public User[] getArray(){
		return users;
	}
}
