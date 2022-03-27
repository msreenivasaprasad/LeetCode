import java.util.Arrays;

public class MA_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points {
	public static void main(String[] args) {
	}

	public int maxWidthOfVerticalArea(int[][] points) {
		int[] arr = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			arr[i] = points[i][0];
		}
		Arrays.sort(arr);
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] > max) {
				max = arr[i] - arr[i - 1];
			}
		}
		return max;
	}
}
