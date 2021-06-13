package TOP100;

import java.util.Stack;

/**
 * @author xushu
 * @create 6/6/21 1:56 PM
 * @desc
 */
public class Q394_DecodeString {

    private int i = 0;

    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return null;
        }

        return dfs(s);
    }

    private String dfs(String s) {
        if(i == s.length()){
            return "";
        }


        String res = "";
        int num = 0;
        while (i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num = num * 10 + s.charAt(i) - '0';
            }else if(s.charAt(i) == '['){
                i++;
                String temp = dfs(s);

                for(int j = 0; j < num; j++){
                    res += temp;
                }
                num = 0;
            }else if(s.charAt(i) == ']'){
                break;
            }else {
                res += s.charAt(i);
            }

            i++;
        }


        return res;
    }

//    public String decodeString2(String s) {
//        if(s == null || s.length() == 0){
//            return null;
//        }
//
//        Stack<String> strStack = new Stack<>();
//        Stack<Integer> numStack = new Stack<>();
//
//        String res = "";
//        int num = 0, index = 0;
//        while(index < s.length()){
//            if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
//                num = num * 10 + s.charAt(index) - '0';
//            }else if(s.charAt(index) == '['){
//                numStack.push(num);
//                strStack.push(res);
//                num = 0;
//                res = "";
//            }else if(s.charAt(index) == ']'){
//                String temp = strStack.pop();
//                int frequency = numStack.pop();
//                for(int i = 0; i < frequency; i++){
//                    res += temp;
//                }
//            }else {
//                res += s.charAt(index);
//            }
//            index++;
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(new Q394_DecodeString().decodeString("3[a2[c]]"));
    }
}
