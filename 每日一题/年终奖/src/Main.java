import java.util.*;

public class Main{
    //基于动态规划的思想，不仅仅局限于6*6矩阵，适用于所有的N*M矩阵以及所有的方阵。
    public int getMost(int[][] board) {
        //两个for循环用来遍历二维数组不用多说。
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j <board[0].length ; j++){
                if(i==0&&j==0){
                    //如果是起点坐标，不做任何处理。
                }else if(i == 0){
                    //如果走在行的临界边，也就是第一行，那么他只能向右走
                    //向右走的时候该点就要将后面的值加起来。
                    board[i][j] += board[i][j-1];
                }else if(j == 0){
                    //如果走在列的临界边，也就是第一列，那么他只能向下走
                    //向下走的时候该点就要将上面的值加起来。
                    board[i][j] += board[i-1][j];
                }else{
                    //核心点在这，除去两个临界边，剩下的就是既能向右走，也能向下走，
                    //那么这时候就要考虑走到当前点的所有可能得情况，也就是走到当前点
                    //各自路径的和是不是这些所有到达该点路径当中最大的了。
                    //temup用来存储从该点上面走下来的最大路径和。
                    //templeft用来存储从该点左边走过来的最大路径的和，
                    int temup = board[i-1][j];
                    int templeft = board[i][j-1];
                    //这两者肯定只能选其一，进行比较，那个大，就把这个值加给当前点，
                    //因为从一开始我们就进行了大小的比较，每一个点存储的都是到达当前点
                    //的最大值。所以直到最后一个点为止，她的值就是当前最大值的和。只要返回
                    //最后一个点的内容就可以了。
                    if(temup>templeft){
                        board[i][j] +=temup ;
                    }else{
                        board[i][j] +=templeft;
                    }
                }
            }
        }
        /*  初始数组的情况。
            564 448 654 186 490 699
            487 444 563 228 365 261
            429 505 612 564 715 726
            464 617 234 647 702 263
            245 249 231 462 453 646
            669 510 492 512 622 135
         */
        /*结束后返回的数组。
        564     1012    1666    1852    2342    3041
        1051    1495    2229    2457    2822    3302
        1480    2000    2841    3405    4120    4846
        1944    2617    3075    4052    4822    5109
        2189    2866    3306    4514    5275    5921
        2858    3376    3868    5026    5897    6056
        可以看到，最后一个坐标点的值6056，他就是当前最优的路径所得出来的值
         */
        return  board[board.length-1][board[0].length-1];
    }

}