package com.practice.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by chakrabo on 8/26/2018.
 * Tic Tac Toe Game
 */
public class DecisionTree {
    static TicTacToeNode root = new TicTacToeNode();
    static int decisionLevel = 8;
    static boolean isTempComputerWinningMove = false;
    static String tempComputerMove = "";
    static String lastSetup = "";

    public static void main(String []arg) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            printTicTacToe(root);
            if (root.isGameHung()) {
                System.out.println("Game over... No more moves left!!");
                break;
            }
            if(!getInput(root, sc))
                continue;
            if (root.isPlayerWinMove()) {
                System.out.println("Congratulation ... Player win!!");
               break;
            }
            lastSetup=root.toString();
            getMove(root);
            giveComputerMove(root);
            lastSetup=root.toString();
            if (root.isComputerWinMove()) {
                System.out.println("Sorry ... Computer win!!");
                break;
            }
            tempComputerMove = "";
        }

    }

    public static void printTicTacToe(TicTacToeNode root) {
        for (int i=0; i<3; i++) {
            for(int j=0 ;j<3; j++) {
                System.out.print(root.value[i][j]+", ");
            }
            System.out.println();
        }
    }

    public static boolean getInput(TicTacToeNode root, Scanner sc) {
        String inputStr = sc.nextLine();
        if (inputStr.equals("")) {
            System.out.println("Input Cannot be Empty");
            return false;
        }else if (inputStr.length() > 2) {
            System.out.println("Wrong input");
            return false;
        }

        int input = Integer.parseInt(inputStr);
        int i = input/10;
        int j = input%10;
        if (root.value[i][j] >-1) {
            System.out.println("Move Already Given");
            return false;
        }
        root.value[i][j] = 1;
        root.presentMove = i+""+j;
        return true;
    }

    public static void getMove(TicTacToeNode node) {
        System.out.println("running... "+node.level);
        if (node.level == decisionLevel) {
            isTempComputerWinningMove = node.isComputerWinMove();
            System.out.println("running... "+node.level + ", "+isTempComputerWinningMove);
            return;
        } else if(node.isComputerWinMove()){
            isTempComputerWinningMove = node.isComputerWinMove();
            System.out.println("running... "+node.level + ", "+isTempComputerWinningMove);
            return;
        } else {
            for (int x=0; x<9; x++) {

                Random rand = new Random();
                int i = rand.nextInt(3);
                int j = rand.nextInt(3);
                if (node.value[i][j] > -1)
                    continue;
                System.out.println("inside loop... "+node.level);
                TicTacToeNode temp = new TicTacToeNode(node, i, j, node.isComputerMove? false: true);
                temp.level = node.level+1;

                node.addChild(temp);

                getMove(temp);
                System.out.println(isTempComputerWinningMove+", "+node.isComputerMove+", "+node.previousMove+", "+lastSetup);
                if (node.isComputerMove && isTempComputerWinningMove) {
                    if (node.previousMove.equals(lastSetup)){
                        tempComputerMove = node.presentMove;
                    }
                    return;
                }

            }

        }
    }

    public static void giveComputerMove(TicTacToeNode node) {
        int tempValue = Integer.parseInt(tempComputerMove);
        int i = tempValue/10;
        int j = tempValue%10;
        node.value[i][j] = 0;
        node.childs = new ArrayList<TicTacToeNode>();
        node.presentMove = "";
    }

}

class TicTacToeNode {
    int [][] value = new int[3][3];
    int level = 0;
    boolean isComputerMove = false;
    String previousMove = "";
    String presentMove = "";
    List<TicTacToeNode> childs = new ArrayList<TicTacToeNode>();

    TicTacToeNode() {
        for(int i=0; i<3; i++) //Initialze with -1
            for(int j=0; j<3; j++)
                value[i][j] = -1;
    }

    TicTacToeNode(TicTacToeNode node, int x, int y, boolean isComputerMove) {
        for (int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                this.value[i][j] = node.value[i][j];
        this.isComputerMove = isComputerMove;
        this.value[x][y] = isComputerMove ? 0 : 1;
        this.previousMove = node.toString();
        this.presentMove = x+""+y;
    }

    void addChild(TicTacToeNode node) {
        childs.add(node);
    }

    boolean isComputerWinMove() {
        return isWin(0);
    }

    boolean isPlayerWinMove() {
        return isWin(1);
    }

    private boolean isWin(int val) {
        if (value[0][0]==val && value[0][1]==val && value[0][2]==val)
            return true;
        else if (value[0][0]==val && value[1][0]==val && value[2][0]==val)
            return true;
        else if (value[0][0]==val && value[1][1]==val && value[2][2]==val)
            return true;
        else if (value[2][0]==val && value[2][1]==val && value[2][2]==val)
            return true;
        else if (value[0][2]==val && value[1][2]==val && value[2][2]==val)
            return true;
        else if (value[2][0]==val && value[1][1]==val && value[0][2]==val)
            return true;
        else if (value[1][0]==val && value[1][1]==val && value[1][2]==val)
            return true;
        else if (value[0][1]==val && value[1][1]==val && value[2][1]==val)
            return true;
        else
            return false;
    }

    boolean isGameHung() {
       return this.toString().contains("-1");
    }

    @Override
    public String toString() {
        String valueStr = "";
        for(int i=0; i<3;i++)
            for(int j=0; j<3;j++)
                valueStr+=value[i][j];
        return valueStr;
    }
}
