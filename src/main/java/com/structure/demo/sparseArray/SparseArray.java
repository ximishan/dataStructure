package com.structure.demo.sparseArray;


/**
 * 稀疏数组
 * @author zhangfeng
 * @date 2019/8/6 10:15 AM
 */
public class SparseArray {

    public static void main(String[] args) {
        // 初始化一个二维数组 11*11
        // 0，没有棋子，1，黑子  2，蓝子
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[2][4] = 2;
        chessArray1[3][4] = 1;
        // 输出原始的二维数组
        System.out.println("===========开始输出原始的二维数组==========");
        for (int[] row: chessArray1) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("===========结束输出原始的二维数组==========");

        // 将二维数组转成稀疏数组
        // 稀疏数组为n行3列
        // 首先便利初始化数组，得到非0数据的个数sum，然后稀疏数组的行数 sum+1（其中1为第一行，）
        int sum = 0;
        for (int i=0;i<chessArray1.length;i++) {
            for (int j=0;j<chessArray1[i].length;j++) {
                if (chessArray1[i][j] != 0) {
                    sum ++;
                }
            }
        }
        System.out.println("原始数组的总共的有效值 sum="+sum);
        // 初始化稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        // 原始数组的行数
        sparseArr[0][0] = chessArray1.length;
        // 原始数组的列数
        sparseArr[0][1] = chessArray1[0].length;
        // 有效的数值
        sparseArr[0][2] = sum;

        int count = 0;
        // 遍历原始数组，将有效数值放到稀疏数组中
        for (int i=0;i<chessArray1.length;i++) {
            for (int j=0;j<chessArray1[i].length;j++) {
                if (chessArray1[i][j] != 0) {
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray1[i][j];
                }
            }
        }
        System.out.println("打印稀疏数组");
        // 打印稀疏数组
        for (int i=0;i<sparseArr.length;i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        System.out.println();
        System.out.println("将稀疏数组恢复成原始的二维数组");

        // 读取稀疏数组的第一行，初始化二维数组，然后遍历稀疏数组的剩下的行数，读取数据给二维数组进行赋值
        int sparseArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //
        for (int i=1;i<=sparseArr[0][2];i++) {
            sparseArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复的二维数组====");
        for (int[] row: sparseArr2) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
