import java.util.Scanner;

public class n_queen {
    public static boolean isSafe(int arr[][],int x,int y,int n){
        for(int r=0;r<x;r++){
            if(arr[r][y]==1){
              return false;
            }
        }
        int row = x;
        int col=y;
        while(row>=0 && col>=0){
            if(arr[row][col]==1){
                return false;
            }
            row--;
            col--;
        }
        row = x;
        col=y;
         while(row>=0 && col<n){
            if(arr[row][col]==1){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    public static boolean nqueen(int arr[][],int x,int n){
        if(x>=n){
            return true;
        }
        for(int col =0;col<n;col++){
            if(isSafe(arr, x, col, n)){
                arr[x][col]=1;

                if(nqueen(arr, x+1, n)){
                   return true;
                }
                arr[x][col]=0;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=0;
            }
        }
        if(nqueen(arr, 0, n)){
            for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               System.out.print(arr[i][j]+" ");
            //    System.out.println();
            }
            System.out.println();
        }
        }
    }
}
