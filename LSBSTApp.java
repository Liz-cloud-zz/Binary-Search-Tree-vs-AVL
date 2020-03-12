import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LSBSTApp {
    public LSBSTApp() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = null;
        Scanner file2 = null;
        String k = null;
        String d = null;
        String line = null;
        String line2 = null;
        BinarySearchTree<String> b = new BinarySearchTree();
        ArrayList<Integer> opcount = new ArrayList();
        ArrayList<Integer> number_of_lines = new ArrayList();
        String[] array = new String[]{"data/random_file_594.txt", "data/random_file_891.txt", "data/random_file_1188.txt", "data/random_file_1485.txt", "data/random_file_1782.txt", "data/random_file_2079.txt", "data/random_file_2376.txt", "data/random_file_2673.txt", "data/random_data.txt", "data/random_file_297.txt"};

        int num;
        int index;
        for(int x = 0; x < array.length; ++x) {
            num = 0;

            try {
                file = new Scanner(new File(array[x]));
                file2 = new Scanner(new File(array[x]));
            } catch (FileNotFoundException var14) {
                System.out.println("File Not Found!");
            }

            while(file.hasNextLine()) {
                line = file.nextLine();
                index = line.indexOf(" ");
                k = line.substring(0, index);
                d = line.substring(index + 1);
                b.insert(d, k);
            }

            while(file2.hasNextLine()) {
                line2 = file2.nextLine();
                ++num;
                index = line2.indexOf(" ");
                k = line2.substring(0, index);
                b.find(k);
            }

            opcount.add(b.getOpCount());
            number_of_lines.add(num);
        }

        PrintWriter operations = new PrintWriter("opCountsResults.txt");

        for(num = 0; num < opcount.size(); ++num) {
            operations.println(opcount.get(num));
        }

        operations.close();
        PrintWriter num_of_lines = new PrintWriter("Number of lines.txt");

        for(index = 0; index < number_of_lines.size(); ++index) {
            num_of_lines.println(number_of_lines.get(index));
        }

        num_of_lines.close();
    }

    public static void printAllAreas(BinarySearchTree<String> x) {
        x.postOrder();
    }

    public static void printAreas(String stage, String day, String startTime, BinarySearchTree<String> ld) {
        String key = stage + "_" + day + "_" + startTime;
        Boolean found = false;
        BinaryTreeNode<String> a = ld.find(key);
        if (a != null) {
            found = true;
            System.out.println(((String)a.data).toString());
        } else {
            System.out.println("Areas not found!");
        }

    }
}
