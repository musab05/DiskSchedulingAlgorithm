// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class Main {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("Enter the cylinder requests (space-separated): ");
//         String input = scanner.nextLine();
//         String[] requests = input.split(" ");

//         System.out.println("Enter the current request: ");
//         int currentRequest = scanner.nextInt();

//         System.out.println("Choose the disk scheduling algorithm:");
//         System.out.println("1. FCFS (First Come First Serve)");
//         System.out.println("2. SSTF (Shortest Seek Time First)");
//         System.out.println("3. SCAN (Elevator Algorithm)");
//         System.out.println("4. C-SCAN (Circular SCAN)");
//         System.out.println("5. LOOK");
//         System.out.println("6. C-LOOK");

//         int choice = scanner.nextInt();

//         switch (choice) {
//             case 1:
//                 System.out.println("FCFS Seek Time: " + FCFS(requests, currentRequest));
//                 break;
//             case 2:
//                 System.out.println("SSTF Seek Time: " + SSTF(requests, currentRequest));
//                 break;
//             case 3:
//                 System.out.println("SCAN Seek Time: " + SCAN(requests, currentRequest));
//                 break;
//             case 4:
//                 System.out.println("C-SCAN Seek Time: " + C_SCAN(requests, currentRequest));
//                 break;
//             case 5:
//                 System.out.println("LOOK Seek Time: " + LOOK(requests, currentRequest));
//                 break;
//             case 6:
//                 System.out.println("C-LOOK Seek Time: " + C_LOOK(requests, currentRequest));
//                 break;
//             default:
//                 System.out.println("Invalid choice. Please choose from 1 to 6.");
//         }

//         scanner.close();
//     }

//     public static int FCFS(String[] requests, int currentRequest) {
//         int seekTime = Math.abs(Integer.parseInt(requests[0]) - currentRequest);
//         for (int i = 1; i < requests.length; i++) {
//             seekTime += Math.abs(Integer.parseInt(requests[i]) - Integer.parseInt(requests[i - 1]));
//         }
//         return seekTime;
//     }

//     public static int SSTF(String[] requests, int currentRequest) {
//         List<Integer> remainingRequests = new ArrayList<>();
//         for (String request : requests) {
//             remainingRequests.add(Integer.parseInt(request));
//         }

//         int seekTime = 0;
//         int currentTrack = currentRequest;

//         while (!remainingRequests.isEmpty()) {
//             int shortestSeekTime = Integer.MAX_VALUE;
//             int nextRequest = 0;

//             for (int i = 0; i < remainingRequests.size(); i++) {
//                 int distance = Math.abs(remainingRequests.get(i) - currentTrack);
//                 if (distance < shortestSeekTime) {
//                     shortestSeekTime = distance;
//                     nextRequest = i;
//                 }
//             }

//             seekTime += shortestSeekTime;
//             currentTrack = remainingRequests.get(nextRequest);
//             remainingRequests.remove(nextRequest);
//         }

//         return seekTime;
//     }

//     public static int SCAN(String[] requests, int currentRequest) {
//         int seekTime = 0;
//         List<Integer> remainingRequests = new ArrayList<>();
//         List<Integer> leftRequests = new ArrayList<>();
//         List<Integer> rightRequests = new ArrayList<>();

//         for (String request : requests) {
//             int req = Integer.parseInt(request);
//             if (req >= currentRequest)
//                 rightRequests.add(req);
//             else
//                 leftRequests.add(req);
//         }

//         rightRequests.sort(null);
//         leftRequests.sort(null);

//         for (int i = 0; i < 2; i++) {
//             List<Integer> currentList = (i == 0) ? rightRequests : leftRequests;
//             int direction = (i == 0) ? 1 : -1;

//             for (int j = 0; j < currentList.size(); j++) {
//                 int nextRequest = currentList.get(j);
//                 seekTime += Math.abs(nextRequest - currentRequest);
//                 currentRequest = nextRequest;
//             }
//         }

//         return seekTime;
//     }

//     public static int C_SCAN(String[] requests, int currentRequest) {
//         int seekTime = 0;
//         List<Integer> remainingRequests = new ArrayList<>();
//         List<Integer> leftRequests = new ArrayList<>();
//         List<Integer> rightRequests = new ArrayList<>();

//         for (String request : requests) {
//             int req = Integer.parseInt(request);
//             if (req >= currentRequest)
//                 rightRequests.add(req);
//             else
//                 leftRequests.add(req);
//         }

//         rightRequests.sort(null);
//         leftRequests.sort(null);

//         for (int i = 0; i < 2; i++) {
//             List<Integer> currentList = (i == 0) ? rightRequests : leftRequests;
//             int direction = (i == 0) ? 1 : -1;

//             for (int j = 0; j < currentList.size(); j++) {
//                 int nextRequest = currentList.get(j);
//                 seekTime += Math.abs(nextRequest - currentRequest);
//                 currentRequest = nextRequest;
//             }
//         }

//         return seekTime;
//     }

//     public static int LOOK(String[] requests, int currentRequest) {
//         int seekTime = 0;
//         List<Integer> remainingRequests = new ArrayList<>();
//         List<Integer> leftRequests = new ArrayList<>();
//         List<Integer> rightRequests = new ArrayList<>();

//         for (String request : requests) {
//             int req = Integer.parseInt(request);
//             if (req >= currentRequest)
//                 rightRequests.add(req);
//             else
//                 leftRequests.add(req);
//         }

//         rightRequests.sort(null);
//         leftRequests.sort(null);

//         for (int i = 0; i < 2; i++) {
//             List<Integer> currentList = (i == 0) ? rightRequests : leftRequests;
//             int direction = (i == 0) ? 1 : -1;

//             for (int j = 0; j < currentList.size(); j++) {
//                 int nextRequest = currentList.get(j);
//                 seekTime += Math.abs(nextRequest - currentRequest);
//                 currentRequest = nextRequest;
//             }
//         }

//         return seekTime;
//     }

//     public static int C_LOOK(String[] requests, int currentRequest) {
//         int seekTime = 0;
//         List<Integer> remainingRequests = new ArrayList<>();
//         List<Integer> leftRequests = new ArrayList<>();
//         List<Integer> rightRequests = new ArrayList<>();

//         for (String request : requests) {
//             int req = Integer.parseInt(request);
//             if (req >= currentRequest)
//                 rightRequests.add(req);
//             else
//                 leftRequests.add(req);
//         }

//         rightRequests.sort(null);
//         leftRequests.sort(null);

//         for (int i = 0; i < 2; i++) {
//             List<Integer> currentList = (i == 0) ? rightRequests : leftRequests;
//             int direction = (i == 0) ? 1 : -1;

//             for (int j = 0; j < currentList.size(); j++) {
//                 int nextRequest = currentList.get(j);
//                 seekTime += Math.abs(nextRequest - currentRequest);
//                 currentRequest = nextRequest;
//             }
//         }

//         return seekTime;
//     }
// }
