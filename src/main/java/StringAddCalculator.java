import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String regex = ",|:";    // 기본 구분자
    private static final int ZERO = 0;

    public static int splitAndSum(String inputString){
        String string = "";     // 문자열
        String[] strings = new String[]{};  // 구분자로 나눈 문자열
        int[] nums = new int[]{};   // 문자열을 숫자로 변환

        // 유효한 문자열인지 확인
        if(!isValidString(inputString)){
            return ZERO;
        }

        // 커스텀 구분자 지정
        // 입력 문자열 재지정
        string = getString(inputString);

        // 문자열 자르기
        strings = splitString(string);

        // 문자열을 숫자로 바꾸기
        nums = convertToInt(strings);


        return 1;
    }

    /*
    * 유효한 문자열인지 확인하는 함수
    *
    * 유효한 문자열이면 true를 반환
    * 유효하지 않은 문자열(null, 빈 문자열)이면 false를 반환
    * */
    public static boolean isValidString(String inputString){
        if (inputString == null) {
            return false;
        }
        if (inputString.isEmpty()) {
            return false;
        }
        return true;
    }

    /*
    * 구분자를 기준으로 나눌 문자열을 반환해주는 함수
    *
    * 커스텀 구분자가 있으면 변수 regex에 구분자를 추가하고, 구분자 지정하는 코드를 뺀 문자열을 반환
    * 없으면 입력된 문자열을 바로 반환
    * */
    public static String getString(String inputString){
        String returnString = inputString;
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            // 커스텀 구분자 추가
            setRegex(matcher.group(1));
            // 커스텀 구분자를 지정하는 문자열 제외하고 반환
            returnString = matcher.group(2);
        }
        return returnString;
    }

    /*
    * 커스텀 구분자 추가하는 함수
    * */
    public static void setRegex(String customRegex) {
        String addRegex = "|" + customRegex;
        regex += addRegex;
    }

    /*
    * 구분자를 기준으로 문자열을 자르는 함수
    * */
    public static String[] splitString(String inputString){
        String[] strings = inputString.split(regex);
        return strings;
    }

    /*
    * 문자열 배열을 숫자 배열로 변환하는 함수
    * */
    public static int[] convertToInt(String[] strings){
        int[] nums = new int[strings.length];
        for(int i=0; i< strings.length; i++){
            nums[i] = Integer.parseInt(strings[i]);
            checkNegative(nums[i]);
        }
        return nums;
    }

    /*
    * 음수이면 RuntimeException 예외를 throw하는 함수
    * */
    public static void checkNegative(int num){
        if (num<0){
            throw new RuntimeException("negative");
        }
    }
}
