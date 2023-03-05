import java.lang.reflect.*; // импортируем пакет с классами рефлексии

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Получаем класс для нашего объекта
        MyClass obj = new MyClass();
        Class<?> cls = obj.getClass();

        // Выводим имя класса
        System.out.println("Class name: " + cls.getName());

        // Получаем все публичные поля класса и выводим их имена
        Field[] fields = cls.getFields();
        System.out.println("Public fields:");
        for (Field field : fields) {
            System.out.println("- " + field.getName());
        }

        // Получаем все методы класса и выводим их имена и параметры
        Method[] methods = cls.getMethods();
        System.out.println("Public methods:");
        for (Method method : methods) {
            System.out.print("- " + method.getName() + "(");
            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getName());
                if (i < params.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }
}

// Простой класс, который мы будем использовать для демонстрации рефлексии
class MyClass {
    public int myIntField;
    public String myStringField;

    public void myPublicMethod(int arg1, String arg2) {
        System.out.println("myPublicMethod called with arg1=" + arg1 + " and arg2=" + arg2);
    }
}
