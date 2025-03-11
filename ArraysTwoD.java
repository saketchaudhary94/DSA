public class ArraysTwoD {

    // function to print a spiral matrix
    public static void spiralMatrix(int mat[][]){
        int startRow =0;
        int startCol = 0;
        int endRow = mat.length-1;
        int endCol = mat[0].length-1;

        while(startRow <= endRow && startCol <= endCol){

            // top part
            for(int i =startCol ; i <= endCol;i++){
                System.out.print(mat[startRow][i] + " ");
            }
            
            // right part
            for(int i = startRow+1;i <= endRow;i++){
                System.out.print(mat[i][endCol] + " ");
            }

            // bottom part 
            for(int i = endCol -1;i >= startCol;i--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(mat[endRow][i]+" ");
            }

            // left part
            for(int i = endRow-1;i >= startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(mat[i][startCol]+" ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }

    // diagonal sum 
    public static void diagonalSum(int mat[][]){
        int sum =0;

        for(int i =0;i < mat.length;i++){
            // primary diagonal 
            sum += mat[i][i];

            // secondary diagonal
            if(i != mat.length-i-1){
                sum += mat[i][mat.length-i-1];
            }
        }
        System.out.println(sum);
    }

    // function to search in a sorted matrix
    public static boolean search(int mat[][] , int k ){
        int row = 0;
        int col = mat[0].length-1;

        while(row <= mat.length && col >= 0){
            if(mat[row][col] == k){
                return true;
            }
            if(mat[row][col] < k){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // spiralMatrix(mat);
        // diagonalSum(mat);
        System.out.println(search(mat, 14));
    }
}
