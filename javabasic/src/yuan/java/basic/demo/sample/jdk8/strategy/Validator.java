package yuan.java.basic.demo.sample.jdk8.strategy;

/**
 * Created by yuan on 17/6/8.
 */
public class Validator {
    private ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
       return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numbericValidator = new Validator(new IsNumberic());
        numbericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        lowerCaseValidator.validate("aaa");
    }
}
