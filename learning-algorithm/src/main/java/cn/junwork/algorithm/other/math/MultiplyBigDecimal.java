package cn.junwork.algorithm.other.math;
/////////////////////////////////////////////////
/////////////////////////////////////////////////
/*********************分割线*********************/
////////////////////////////////////////////////
////////////////////////////////////////////////


import java.util.Scanner;

public class MultiplyBigDecimal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            String a = s[0];
            int la = a.length();
            String b = s[1];
            int lb = b.length();
    
            //这个矩阵存放整个运算过程中的临时结果
            int colCount = la + lb;
            int rowCount = lb + 1;
            byte[][] matrix = new byte[rowCount][colCount];
            //进位
            int carry = 0;
            
            //小学数学方法，用b的每一位去乘a的每一位，注意对齐
            for (int i = lb - 1, row = 0; i >= 0; --i, ++row) {
                int digitB = b.charAt(i) - '0';

                int col = colCount - row - 1;
                for (int j = la - 1; j >= 0; --j) {
                    int digitA = a.charAt(j) - '0';
                    int t = digitA * digitB + carry;
                    matrix[row][col--] = (byte) (t % 10);
                    carry = t / 10;
                }

                if (carry != 0) {
                    matrix[row][col] = (byte) carry;
                    carry = 0;
                }
            }

            //对所有结果进行累加
            //矩阵从右至左，由上至下
            byte[] result = matrix[rowCount - 1];
            for (int col = colCount - 1; col >= 0; --col) {
                int digit = 0;

                for (int row = 0; row < rowCount - 1; ++row) {
                    digit += matrix[row][col];
                }

                digit += carry;
                carry = digit / 10;
                result[col] = (byte) (digit % 10);
            }

            //输出最终结果
            int i = result[0] == 0 ? 1 : 0;
            for (; i < colCount; ++i) {
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }
}
