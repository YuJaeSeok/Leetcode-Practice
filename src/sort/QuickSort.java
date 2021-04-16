package sort;

public class QuickSort {
	public int[] quickSort(int[] nums) {
		if (nums == null || nums.length == 0) return null; 
		
		int[] i = nums;
		quickSort(i, 0, nums.length - 1);
		return i;
	}

	public void quickSort(int[] nums, int left, int right) {	
		int i = left;
		int j = right;
		
		// 支点
		int pivot = nums[i + (j - i) / 2];
		
		// 左右两端进行扫描，只要两端还没交接，就一直扫描
		while (i <= j) {
			// 寻找直到比支点大的数
			while (pivot > nums[i]) {
				i++;
			}
			// 寻找直到比支点小的数
			while (pivot < nums[j]) {
				j--;
			}
			
			// 此时已经找到左边比支点大的数，右边比支点小的数，将其交换
			if (i <= j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
		}
		
		// 上面while循环保证了第一趟排序支点的左边比支点小，支点的右边比支点大
		
		// 左边再做排序
		if (left < j) {
			quickSort(nums, left , j);
		}
		
		// 右边再做排序
		if (i < right) {
			quickSort(nums, i, right);
		}
	}
}
