package datastruct.ErChaShu;

/**
 * Created by licheng on 18/5/16.
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        String s = "We are happy!";
        System.out.println(replaceBlank(s));
    }

    public static String replaceBlank(String input){
        if("".equals(input) || input == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)==' '){
                sb.append("20%");
            }else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
