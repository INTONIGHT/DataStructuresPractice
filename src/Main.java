import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//LIFO last in first out
		//stores in a vertical tower push to add to the top
		//pop to remove form the topo
		Stack<String> stack = new Stack<String>();
//		// TODO Auto-generated method stub
//		//linear search O(n)
		int[] array = {9,1,8,2,7,3,6,5,4};
		int index = linearSearch(array,1);
		if(index != -1) {
			System.out.println("ELement found at index: " + index);
		}else {
			System.out.println("Element not found");
		}
		int secondArray[] = new int[1000000];
		int target = 777777;
		for(int i = 0; i<secondArray.length; i++) {
			secondArray[i] = i;
		}
		//int findIndex = Arrays.binarySearch(array, target);
		int findIndex = binarySearch(secondArray,target);
		if(findIndex == -1) {
			System.out.println(target + " not found");
		}else {
			System.out.println(target + " found at: " + findIndex);
		}
		
		int[] unsortedArray = {8,2,5,3,9,4,7,6,1};
		quickSort(unsortedArray,0,unsortedArray.length - 1);
		for(int i: unsortedArray) {
			System.out.println(i + " ");
		}
		
		String testNum = "6777133339";
		//System.out.println("\n The largest number in : " + testNum + " is: " + largestGoodInteger(testNum));
		HashTable table = new HashTable();
		table.mockHashTable();
		
		Graph graph = new Graph(5);
		graph.addNode(new Node('A'));
		graph.addNode(new Node('B'));
		graph.addNode(new Node('C'));
		graph.addNode(new Node('D'));
		graph.addNode(new Node('E'));
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2,3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		//depth first search pick a route keep going
		//graph.depthFirstSearch(4);
		graph.breadthFirstSearch(4);
		System.out.println(" ");
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(new BinaryTreeNode(3));
		tree.insert(new BinaryTreeNode(5));
		tree.insert(new BinaryTreeNode(7));
		tree.insert(new BinaryTreeNode(4));
		tree.insert(new BinaryTreeNode(8));
		tree.insert(new BinaryTreeNode(9));
		tree.insert(new BinaryTreeNode(10));
		tree.insert(new BinaryTreeNode(2));
		tree.insert(new BinaryTreeNode(1));
		tree.insert(new BinaryTreeNode(6));
		tree.display();
		System.out.println(tree.search(11));
		tree.remove(10);
		System.out.println("");
		tree.display();
	}

	private static void quickSort(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		if(end <= start) {
			return;
		}
		int pivot = partition(array,start,end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot+1, end);
		
	}
	private static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start - 1;
		for(int j = start; j<= end -1; j ++) {
			if(array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		i ++;
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;
		return i;
	}

	private static int binarySearch(int[] array, int target) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = array.length - 1;
		while(low <= high) {
			int middle = low + (high - low) / 2;
			int value = array[middle];
			//to demonstrate the ste[s
			System.out.println("middle: " + value);
			if(value < target) {
				low = middle + 1;
			}
			else if (value > target) {
				high = middle - 1;
			}else {
				return middle;
			}
		}
		return -1;
	}

	private static int linearSearch(int[] array, int value) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < array.length;i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;
	}
	public static String reverse(String str) {
        if (str.isEmpty())
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }
	
	public static String largestGoodInteger(String num) {
        ArrayList<Integer> validNums = new ArrayList<Integer>();
         String holder = "";
        for(int i = 0; i< num.length() - 1; i ++){
        	
            if(holder == "" || holder.charAt(0) == num.charAt(i)){
                holder += num.charAt(i);
                if(holder.length() == 3){
                    int newNum = Integer.valueOf(holder);
                    validNums.add(newNum);
                    holder = "";
                }
            }
        }
        if(validNums.isEmpty()){
            return "";
        }
        int largestNum = 0;
        for(int i = 0;i<validNums.size(); i++){
            if(validNums.get(i) > largestNum){
                largestNum = validNums.get(i);
            }
        }
        return Integer.toString(largestNum);
    }
	public static boolean validSquare(int number) {
		int left =1;
		int right = number;
		while (left <= right){
			int middle = left + (right - left) / 2;
			int middleSquared = middle * middle;
			if (number == middleSquared){
				return true;
			}
			else if(middleSquared < number) {
				left = middle + 1;
			}
				else {
					right = middle - 1;
				}
			
			}
		return false;
		}
		
	

}
