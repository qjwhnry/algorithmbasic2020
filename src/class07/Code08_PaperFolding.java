package class07;

/**
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折一次，压出折痕后展开。此时这很是凹下去的，即这很突起的方向指向纸条的背面。
 * 如果纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次。请从上到下打印所有折痕的方向。
 */
public class Code08_PaperFolding {

	public static void printAllFolds(int N) {
		printProcess(1, N, true);
	}

	// 递归过程，来到了某一个节点，
	// i是节点的层数，N一共的层数，down == true  凹    down == false 凸
	public static void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i + 1, N, true);
		System.out.println(down ? "凹 " : "凸 ");
		printProcess(i + 1, N, false);
	}

	public static void main(String[] args) {
		int N = 3;
		printAllFolds(N);
	}
}
