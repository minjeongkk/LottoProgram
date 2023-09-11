public class StringAddCalculator {

    public static int splitAndSum(String inputString){
        // 유효한 문자열인지 확인
        if(!isValidString(inputString)){
            return 0;
        }
        return 1;
    }

    /*
    * 유효한 문자열인지 확인
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
}
