package Sort;

public class MergeSort_2 {

	private static void mergeSort(int[] arr) {

		// �ӽ� �������
		int[] tmp = new int[arr.length];

		// �迭, �ӽ� �����, �ε�������, �ε�����
		mergeSort(arr, tmp, 0, arr.length - 1);
	}

	// �迭, �ӽ� �����, �ε�������, �ε�����
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {

		// �ε��������� �ε��������� �������� ����
		if (start < end) {
			// ����� �κ�
			int mid = (start + end) / 2;

			// �迭�� �պκ����� ��ŸƮ�� ���带 �����ؼ� ȣ��
			mergeSort(arr, tmp, start, mid);
			// �迭�� �޺κ����� �������� �����ؼ� �ٽ� ȣ��
			mergeSort(arr, tmp, mid + 1, end);

			merge(arr, tmp, start, mid, end);

		}
	}

	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		while (part1 <= mid && part2 <= end) {
			if (tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}
	
	private static void printArray(int[] arr) {
		
		for (int data: arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
	}

}
