public class MyException {
    public static void main(String[] args) {
    }
}

class EmptyTreeException extends Exception {
    public EmptyTreeException(String message) {
        super(message);
    }
}
