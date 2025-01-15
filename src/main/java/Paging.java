// import java.util.Scanner;

// public class Main {
//   public static void main(String[] args) {
//     int total_memory = 0, frame_size = 0, frame_occupied, fmax;
//     int[] page_table = new int[100];
//     int vm, pm;

//     char ans = 'y';

//     Scanner scanner = new Scanner(System.in);

//     System.out.print("Enter size of physical memory:");
//     total_memory = scanner.nextInt();

//     System.out.print("Enter the size of frame:");
//     frame_size = scanner.nextInt();

//     System.out.print("Enter the number of frames occupied:");
//     frame_occupied = scanner.nextInt();

//     fmax = total_memory / frame_size;

//     if (frame_occupied > fmax) {
//       System.out.println("Memory thrash");
//       return;
//     }

//     System.out.print("Enter the frames used by pages (less than " + fmax + "):");
//     for (int i = 0; i < frame_occupied; i++) {
//       page_table[i] = scanner.nextInt();
//     }

//     System.out.println("Virtual memory locations available are 0 to " + frame_size * frame_occupied);

//     while (ans == 'y') {
//       int r;
//       System.out.print("Enter the virtual memory address:");
//       vm = scanner.nextInt();

//       if (vm >= frame_size * frame_occupied) {
//         System.out.println("Invalid address!!!");
//       } else {
//         r = vm / frame_size;
//         pm = page_table[r] * frame_size + vm % frame_size;
//         System.out.println("Physical Address is " + pm);
//       }

//       System.out.print("\nEnter more(y/n)?: ");
//       ans = scanner.next().charAt(0);
//     }

//     scanner.close();
//   }
// }