public class Manacher {
    /**
     * 求字符串中最大回文数
     * @param str
     * @return
     */
    public  static int[] getManacher(char[] str) {
        int l = str.length;
        char[] strs = new char[2*l+1];
        for (int i = 0; i< strs.length; i++) {
            if (i%2==0) strs[i]='#';
            else strs[i]=str[(i-1)/2];
        }
        System.out.println(strs);
        return new int[]{0, 1};
    }
    public static void main(String[] args) {
        getManacher("siheufaiu".toCharArray());
    }
}
