import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int x = 0;
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int num = 0;
            if (split.length > 1) {
                num = Integer.parseInt(split[1]);
            }   
           
            switch(split[0]) {
                case "add" : {
                    x = x | (1 << num);
                    break;
                }
                case "delete" : {
                    x = x & ~(1 << num);
                    break;
                }

                case "print" : {
                    System.out.println((x >> num  & 1) == 1 ? 1: 0);
                    break;
                }

                case "toggle" : {
                    x = x ^ (1 << num);
                    break;
                }
                case "clear" : {
                    x = 0;
                    break;
                }
            }
        }
    
    }
}