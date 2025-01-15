// import java.util.Scanner;

// public class Main {

//   public static void FirstFit(int memoryBlock[], int processBlock[]) {
//     int allocation[] = new int[processBlock.length];
//     boolean[] allocated = new boolean[memoryBlock.length];

//     if (memoryBlock.length >= processBlock.length) {
//       for (int i = 0; i < processBlock.length; i++) {
//         for (int j = 0; j < memoryBlock.length; j++) {
//           if (memoryBlock[j] >= processBlock[i] && !allocated[j]) {
//             allocation[i] = j;
//             allocated[j] = true;
//             break;
//           } else {
//             allocation[i] = -1;
//           }
//         }
//       }
//     } else {
//       System.out.println("Required Number of memory blocks not available");
//     }

//     System.out.println("Processes\tProcess Size\tMemoryblock Allocated");

//     for (int i = 0; i < processBlock.length; i++) {
//       System.out.print(i + "\t\t" + processBlock[i] + "\t\t");
//       if (allocation[i] != -1)
//         System.out.print(allocation[i]);
//       else
//         System.out.print("Not Allocated");
//       System.out.println();
//     }
//   }

//   public static void WorstFit(int memoryBlock[], int processBlock[]) {
//     int allocation[] = new int[processBlock.length];
//     boolean[] allocated = new boolean[memoryBlock.length];

//     if (memoryBlock.length >= processBlock.length) {
//       for (int i = 0; i < processBlock.length; i++) {
//         int ws = findWorstFit(memoryBlock, processBlock[i], allocated);
//         if (ws != -1) {
//           allocation[i] = ws;
//           allocated[ws] = true;
//         } else {
//           allocation[i] = -1;
//         }
//       }
//     } else {
//       System.out.println("Required Number of memory blocks not available");
//     }

//     System.out.println("Processes\tProcess Size\tMemoryblock Allocated");

//     for (int i = 0; i < processBlock.length; i++) {
//       System.out.print(i + "\t\t" + processBlock[i] + "\t\t");
//       if (allocation[i] != -1)
//         System.out.print(allocation[i]);
//       else
//         System.out.print("Not Allocated");
//       System.out.println();
//     }
//   }

//   public static void BestFit(int memoryBlock[], int processBlock[]) {
//     int allocation[] = new int[processBlock.length];
//     boolean[] allocated = new boolean[memoryBlock.length];

//     if (memoryBlock.length >= processBlock.length) {
//       for (int i = 0; i < processBlock.length; i++) {
//         int bs = findBestFit(memoryBlock, processBlock[i], allocated);
//         if (bs != -1) {
//           allocation[i] = bs;
//           allocated[bs] = true;
//         } else {
//           allocation[i] = -1;
//         }
//       }
//     } else {
//       System.out.println("Required Number of memory blocks not available");
//     }

//     System.out.println("Processes\tProcess Size\tMemoryblock Allocated");

//     for (int i = 0; i < processBlock.length; i++) {
//       System.out.print(i + "\t\t" + processBlock[i] + "\t\t");
//       if (allocation[i] != -1)
//         System.out.print(allocation[i]);
//       else
//         System.out.print("Not Allocated");
//       System.out.println();
//     }
//   }

//   public static int findBestFit(int[] memoryBlock, int processSize, boolean[] allocated) {
//     int minSpace = Integer.MAX_VALUE;
//     int bestFitIndex = -1;

//     for (int i = 0; i < memoryBlock.length; i++) {
//       if (!allocated[i] && memoryBlock[i] >= processSize) {
//         int space = memoryBlock[i] - processSize;
//         if (space < minSpace) {
//           minSpace = space;
//           bestFitIndex = i;
//         }
//       }
//     }

//     return bestFitIndex;
//   }

//   public static int findWorstFit(int[] memoryBlock, int processSize, boolean[] allocated) {
//     int maxSpace = Integer.MIN_VALUE;
//     int worstFitIndex = -1;

//     for (int i = 0; i < memoryBlock.length; i++) {
//       if (!allocated[i] && memoryBlock[i] >= processSize) {
//         int space = memoryBlock[i] - processSize;
//         if (space > maxSpace) {
//           maxSpace = space;
//           worstFitIndex = i;
//         }
//       }
//     }

//     return worstFitIndex;
//   }

//   public static void main(String args[]) {
//     int n, m;

//     Scanner sc = new Scanner(System.in);

//     System.out.println("Enter the number of memory blocks:");
//     n = sc.nextInt();

//     System.out.println("Enter the number of process blocks:");
//     m = sc.nextInt();

//     int memoryBlock[] = new int[n];
//     int processBlock[] = new int[m];

//     for (int i = 0; i < n; i++) {
//       System.out.println("Enter the block size of Memoryblock:" + i);
//       memoryBlock[i] = sc.nextInt();
//     }

//     for (int i = 0; i < m; i++) {
//       System.out.println("Enter the block size of processblock:" + i);
//       processBlock[i] = sc.nextInt();
//     }

//     int choice = 0;

//     while (true) {
//       System.out.println("Enter your choice:\n1:First Fit\n2:Best Fit\n3:Worst Fit\n4:Exit");

//       choice = sc.nextInt();

//       switch (choice) {
//         case 1:
//           FirstFit(memoryBlock, processBlock);
//           break;
//         case 2:
//           BestFit(memoryBlock, processBlock);
//           break;
//         case 3:
//           WorstFit(memoryBlock, processBlock);
//           break;
//         case 4:
//           sc.close();
//           return;
//         default:
//           System.out.println("Invalid choice, please try again.");
//       }
//     }
//   }
// }
