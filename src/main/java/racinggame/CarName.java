package racinggame;

public class CarName {

    private static final int LENGTH_LIMIT = 5;
    private static final String ERROR_MESSAGE = "[ERROR]";

    private String name;

    public CarName(String name) {
        validateEmpty(name);
        name = name.trim();
        validateLengthLimit(name);
        this.name = name;
    }

    private void validateEmpty(String name) {
        if (name == null || ("").equals(name.trim())) {
            System.out.println(ERROR_MESSAGE + " 이름이 입력되지 않았습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateLengthLimit(String name) {
        if (name.length() > LENGTH_LIMIT) {
            System.out.println(ERROR_MESSAGE + " 이름의 길이는 " + LENGTH_LIMIT + "자 이하만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

}
