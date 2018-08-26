package com.practice.algorithms;
import java.util.ArrayList;
import java.util.List;

public class NQueen {

	public static void main(String []arg) {
		int n = 8;
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> allQueenLoc = new ArrayList<String>();
		
		for(int sol=0; sol < n*2; sol++) {
			String []queenLoc = new String[n];
			String [][]board = new String[n][n];
			int j=0;	
			int i=0;
		
			for(int queen=0; queen < n;) {
				for(; i<n;) {
					boolean isValid = false;
					for(; j<n; j++) {
						isValid = validate(queen, n, i, j, queenLoc, allQueenLoc);
						if (isValid) {
							queenLoc[queen] = i+","+j;
							board[i][j] = "Q";
							break;
						} 
						board[i][j]=".";
					}
					if(!isValid) {
						queen--;
						if(queen < 0) 
							break;
						String []loc = queenLoc[queen].split(",");
						i = Integer.parseInt(loc[0]);
						j = Integer.parseInt(loc[1]);
						board[i][j]=".";
						j++;
						queenLoc[queen] = null;
						
						
					} else if(queenLoc[queen] != null) {
						i++;
						j=0;
						break;
					}
				}
				if(queen <0)
					break;
				queen++;
			}
			System.out.println();
			System.out.println();
			for(i=0; i<n; i++) {
				for(j=0;j<n;j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			if(queenLoc[n-1] != null){
                List<String> boardList = new ArrayList<String>();
                for(int row=0; row<n; row++){
                    String str = "";
                    for(int col=0; col<n; col++){
                        if("Q".equals(board[row][col])) {
                            str += "Q";
                            allQueenLoc.add(row+","+col);
                        }
                        else
                            str +=".";
                    }
                    boardList.add(str);
                }
                res.add(boardList);
                
            }
		}
	}
	
	public static boolean validate(int queen, int n, int i, int j, String[] queenLoc, List<String> allQueenLoc) {
		if(allQueenLoc.contains(i+","+j))
			return false;
		for(int q=0; q<queen; q++) {
			String []loc = queenLoc[q].split(",");
			if(loc[0].equals(i+"") || loc[1].equals(j+""))
				return false;
			for(int baki=i, bakj=j; baki>=0 && bakj<n; baki--, bakj++) {
				String locStr = baki+","+bakj;
				if(locStr.equals(queenLoc[q]))
					return false;
			}
			for(int baki=i, bakj=j; baki<n && bakj>=0 ; baki++, bakj--) {
				String locStr = baki+","+bakj;
				if(locStr.equals(queenLoc[q]))
					return false;
			}
			for(int baki=i, bakj=j; baki<n && bakj<n ; baki++, bakj++) {
				String locStr = baki+","+bakj;
				if(locStr.equals(queenLoc[q]))
					return false;
			}
			for(int baki=i, bakj=j; baki>=0 && bakj>=0 ; baki--, bakj--) {
				String locStr = baki+","+bakj;
				if(locStr.equals(queenLoc[q]))
					return false;
			}
		}
		return true;
	}
}
