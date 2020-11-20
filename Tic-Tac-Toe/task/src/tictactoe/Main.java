package tictactoe;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells:");
        String in = "_________";
        int count = 0;
        int underCount = 0;
        boolean xwin = false;
        boolean owin = false;
        
        //printing the tictactoe;
        System.out.println("---------");
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                if(j==0 || j==4){
                    System.out.print("| ");
                }else{
                    System.out.print(in.charAt(count)+" ");
                    count++;
                }
                
            }
            System.out.println("");
        }
        System.out.println("---------");
        
        
        //entering the input 
        char[][] x = {{'_','_','_'},{'_','_','_'},{'_','_','_'}};
        boolean turnX = true;
while(true)
{        
        // int c = 0;
        // for(int i=0;i<3;i++){
        //     char[] n = new char[3];
        //     for(int j=0;j<3;j++){
        //         n[j] = in.charAt(c);
        //         c++;
        //     }
        //     arr[i] = n;
        // }
        
        
        
        int cordx = 0;
        int cordy = 0;
        boolean inpCheck = true;
        while(inpCheck){
            System.out.print("Enter the coordinates: ");
            cordx = scanner.nextInt();
            cordy = scanner.nextInt();
            if(cordx < 1 || cordx > 3 || cordy < 1 || cordy > 3){
                System.out.println("Coordinates should be from 1 to 3!");
                inpCheck = true;
                continue;
            }else{
                inpCheck = false;
                
            }
            
            int temp = cordx;
            cordx = 3-cordy;
            cordy = temp-1;
            
            if(x[cordx][cordy] == '_'){
                if(turnX){
                    x[cordx][cordy] = 'X';
                    turnX = false;
                }else{
                    x[cordx][cordy] = 'O';
                    turnX = true;
                }
            }else{
                System.out.println("This cell is occupied! Choose another one!");
                inpCheck = true;
                continue;
            }
            
            
        }
        
        
        System.out.println("---------");
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                if(j==0 || j==4){
                    System.out.print("| ");
                }else{
                    System.out.print(x[i][j-1]+" ");
                    
                }
                
            }
            System.out.println("");
        }
        System.out.println("---------");
        
        
        //checking code of the tictactoe
        // int count1 = 0;
        // for(int i = 0;i<3;i++){
        //     char[] ne = new char[3];
        //     for(int j=0;j<3;j++){
        //         ne[j] = in.charAt(count1);
        //         count1++;
        //     }
        //     x[i] = ne;
        // }
        int sumR = 0;
        int sumC = 0;
        int sumD1 = 0;
        int sumD2 = 0;
        int xcount = 0;
        int ocount = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(x[i][j] == 'X'){
                    xcount++;
                }else if(x[i][j] == 'O'){
                    ocount++;
                }
                sumR += x[i][j];
                sumC += x[j][i];
                if(i == j){
                    sumD1 += x[i][j];
                    sumD2 += x[2-i][j];
                }
            }
            if(sumR == 264 || sumC == 264 || sumD1 == 264 || sumD2 == 264){
                System.out.println("X wins");
                xwin = true;
                return;
            }else if(sumR == 237 || sumC == 237 || sumD1 == 237 || sumD2 == 237){
                System.out.println("O wins");
                owin = true;
                return;
            }
            sumR = 0;
            sumC = 0;
            
        }
        if(Math.abs(xcount-ocount)>=2 || (xwin && owin)){
            // System.out.println(xcount);
            // System.out.println(ocount);
            System.out.println("Impossible");
        }    
        else if(xcount+ocount == 9){
            if(!xwin && !owin){
                System.out.println("Draw");
                return;
            }
        }}
        
    }
}
