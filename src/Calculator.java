    import java.lang.annotation.*;

    public class Calculator {
        @Math(num1 = 100, num2 = 200)
        public void mathSum(int num1, int num2) {
            int result = num1 + num2;
            System.out.println("Результат сложения: " + result);
        }

        public static void main(String[] args) throws Exception {
            Calculator calculator = new Calculator();
            Class<?> clazz = calculator.getClass();
            Math math = clazz.getMethod("mathSum", int.class, int.class).getAnnotation(Math.class);
            int num1 = math.num1();
            int num2 = math.num2();
            calculator.mathSum(num1, num2);
        }
    }
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Math {
        int num1() default 0;

        int num2() default 0;
    }


