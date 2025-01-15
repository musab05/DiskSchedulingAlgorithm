// import java.util.*;

// public class Main {

// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.print("Enter the number of frames: ");
// int numOfFrames = scanner.nextInt();

// System.out.print("Enter the reference string (space-separated): ");
// scanner.nextLine();
// String[] refString = scanner.nextLine().split(" ");

// System.out.println("\nFIFO:");
// fifo(refString, numOfFrames);

// System.out.println("\nLRU:");
// lru(refString, numOfFrames);

// System.out.println("\nOptimal:");
// optimal(refString, numOfFrames);

// scanner.close();
// }

// public static void fifo(String[] refString, int numOfFrames) {
// Queue<String> frames = new LinkedList<>();
// int pageFaults = 0;

// for (String page : refString) {
// if (!frames.contains(page)) {
// if (frames.size() == numOfFrames) {
// frames.poll();
// }
// frames.offer(page);
// pageFaults++;
// }
// System.out.println("Frames: " + frames);
// }

// System.out.println("Page Faults: " + pageFaults);
// System.out.println("Miss Ratio: " + (refString.length - pageFaults) + "/" +
// refString.length);
// System.out.println("Miss Ratio: " + pageFaults + "/" + refString.length);
// }

// public static void lru(String[] refString, int numOfFrames) {
// LinkedList<String> frames = new LinkedList<>();
// int pageFaults = 0;

// for (String page : refString) {
// if (frames.contains(page)) {
// frames.remove(page);
// } else {
// if (frames.size() == numOfFrames) {
// frames.removeFirst();
// }
// pageFaults++;
// }
// frames.addLast(page);
// System.out.println("Frames: " + frames);
// }

// System.out.println("Page Faults: " + pageFaults);
// System.out.println("Miss Ratio: " + (refString.length - pageFaults) + "/" +
// refString.length);
// System.out.println("Miss Ratio: " + pageFaults + "/" + refString.length);
// }

// public static void optimal(String[] refString, int numOfFrames) {
// ArrayList<String> frames = new ArrayList<>();
// int pageFaults = 0;

// for (int i = 0; i < refString.length; i++) {
// String page = refString[i];
// if (!frames.contains(page)) {
// if (frames.size() < numOfFrames) {
// frames.add(page);
// } else {
// int index = getOptimalIndex(refString, frames, i);
// frames.set(index, page);
// }
// pageFaults++;
// }
// System.out.println("Frames: " + frames);
// }

// System.out.println("Page Faults: " + pageFaults);
// System.out.println("Miss Ratio: " + (refString.length - pageFaults) + "/" +
// refString.length);
// System.out.println("Miss Ratio: " + pageFaults + "/" + refString.length);
// }

// public static int getOptimalIndex(String[] refString, ArrayList<String>
// frames, int k) {
// int farthestIndex = -1;
// int farthestDistance = 0;

// for (int i = 0; i < frames.size(); i++) {
// int distance = nextOccurrence(refString, frames.get(i), k);
// if (distance == -1) {
// return i;
// }
// if (distance > farthestDistance) {
// farthestDistance = distance;
// farthestIndex = i;
// }
// }

// return farthestIndex;
// }

// public static int nextOccurrence(String[] refString, String page, int
// startIndex) {
// for (int i = startIndex; i < refString.length; i++) {
// if (refString[i].equals(page)) {
// return i;
// }
// }
// return -1;
// }

// }
