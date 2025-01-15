// import java.util.*;

// public class Main {

//   public static void main(String[] args) {
//     Scanner scanner = new Scanner(System.in);

//     System.out.print("Enter the number of pages: ");
//     int n = scanner.nextInt();

//     System.out.print("Enter the number of frames: ");
//     int capacity = scanner.nextInt();

//     int pages[] = new int[n];
//     System.out.println("Enter the reference string: ");
//     for (int i = 0; i < n; i++) {
//       pages[i] = scanner.nextInt();
//     }

//     int fifoMiss = fifoPageReplacement(pages, n, capacity);
//     System.out.println("Number of Hits using FIFO: " + (n - fifoMiss));
//     System.out.println("Hits Ratio (FIFO): " + (n - fifoMiss) + "/" + n);
//     System.out.println("Miss Ratio (FIFO): " + fifoMiss + "/" + n);

//     int lruMiss = lruPageReplacement(pages, n, capacity);
//     System.out.println("Number of Hits using LRU: " + (n - lruMiss));
//     System.out.println("Hits Ratio (LRU): " + (n - lruMiss) + "/" + n);
//     System.out.println("Miss Ratio (LRU): " + lruMiss + "/" + n);

//     int optimalMiss = optimalPageReplacement(pages, capacity);
//     System.out.println("Number of Hits using Optimal: " + (n - optimalMiss));
//     System.out.println("Hits Ratio (Optimal): " + (n - optimalMiss) + "/" + n);
//     System.out.println("Miss Ratio (Optimal): " + optimalMiss + "/" + n);

//   }

//   public static int fifoPageReplacement(int pages[], int n, int capacity) {
//     Queue<Integer> queue = new LinkedList<>();
//     int miss = 0;

//     for (int i = 0; i < n; i++) {
//       if (queue.contains(pages[i])) {
//         System.out.println("Page " + pages[i] + " already in memory");
//       } else {
//         miss++;
//         if (queue.size() == capacity) {
//           int removedPage = queue.poll();
//           System.out.println("Page " + removedPage + " removed from memory");
//         }
//         queue.offer(pages[i]);
//         System.out.println("Page " + pages[i] + " added to memory");
//       }
//     }

//     return miss;
//   }

//   public static int lruPageReplacement(int pages[], int n, int capacity) {
//     Map<Integer, Integer> map = new LinkedHashMap<>(capacity, 0.75f, true);
//     int miss = 0;

//     for (int i = 0; i < n; i++) {
//       if (map.containsKey(pages[i])) {
//         System.out.println("Page " + pages[i] + " already in memory");
//         map.get(pages[i]); // Access the page to update its position in the LinkedHashMap
//       } else {
//         miss++;

//         if (map.size() == capacity) {
//           int firstKey = map.entrySet().iterator().next().getKey();
//           map.remove(firstKey);
//           System.out.println("Page " + firstKey + " removed from memory");
//         }

//         map.put(pages[i], i);
//         System.out.println("Page " + pages[i] + " added to memory");
//       }
//     }

//     return miss;
//   }

//   public static int optimalPageReplacement(int[] pages, int capacity) {
//     int pageFaults = 0;
//     int n = pages.length;
//     Set<Integer> frames = new HashSet<>();
//     Map<Integer, Integer> nextOccurrence = new HashMap<>();

//     for (int i = 0; i < n; i++) {
//       int page = pages[i];

//       if (!frames.contains(page)) {
//         pageFaults++;

//         if (frames.size() < capacity) {
//           frames.add(page);
//         } else {
//           int farthest = -1;
//           int farthestPage = -1;
//           for (int frame : frames) {
//             if (!nextOccurrence.containsKey(frame)) {
//               return -1; // Handle error condition
//             }
//             if (nextOccurrence.get(frame) == -1) {
//               farthestPage = frame;
//               break;
//             }
//             if (nextOccurrence.get(frame) > farthest) {
//               farthest = nextOccurrence.get(frame);
//               farthestPage = frame;
//             }
//           }
//           frames.remove(farthestPage);
//           frames.add(page);
//         }
//       }

//       // Update next occurrence of pages
//       for (int j = i + 1; j < n; j++) {
//         if (pages[j] == page) {
//           nextOccurrence.put(page, j);
//           break;
//         }
//       }
//     }
//     return pageFaults;
//   }

// }