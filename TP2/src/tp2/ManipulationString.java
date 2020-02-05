package tp2;

public class ManipulationString {

    public int sum(String asciiCode) {
        if(asciiCode == null) {
           throw new NullPointerException();
        }
        int result = 0;
        for(char c: asciiCode.toCharArray()) {
            result += c;
        }
        return result;
    }
}
