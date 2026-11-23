// package：声明当前类属于哪个包，包名要与 src 下面的目录名对应。
// 当前类位于 src/string 目录，所以这里写 package string;。
// 加上包名后，这个类的完整名称是：string.StringFormattingScenarios。
package string;

// import：导入其他包中的类，导入后就可以直接使用类名。
// MessageFormat：根据 {0}、{1} 等占位符生成消息，本文件用于多语言消息示例。
import java.text.MessageFormat;

// Date：表示日期和时间，本文件用于显示订单日期。
import java.util.Date;

/**
 * Java 字符串格式化的常见场景。
 *
 * 当前项目使用 JDK 8，因此文本块示例以注释形式保留；
 * 文本块和 String.formatted() 需要 JDK 15 或更高版本。
 */
public class StringFormattingScenarios {

    // main 是程序的入口方法，运行这个类时，Java 会从这里开始执行。
    public static void main(String[] args) {
        // 方法调用的格式：方法名();
        // 下面依次调用五个方法，每个方法负责演示一种字符串处理场景。
        // 方法的详细代码写在本类的下方，执行顺序与这里的调用顺序一致。
        stringConcatenationScenario();    // 1. 使用 + 拼接字符串
        stringFormatScenario();           // 2. 使用 String.format() 生成格式化字符串
        printfScenario();                 // 3. 使用 System.out.printf() 格式化输出
        messageFormatScenario();          // 4. 使用 MessageFormat 生成多语言消息
        textBlockAndFormattedScenario();  // 5. 生成多行 JSON 字符串

        // 学习时，如果只想运行其中一个示例，可以暂时用 // 注释掉其他方法调用。
    }

    /**
     * 场景一：少量变量的简单拼接，使用 + 最直观。
     */
    private static void stringConcatenationScenario() {
        printTitle("1. 字符串拼接：生成用户信息");

        String name = "张三";
        int age = 20;

        String message = "姓名：" + name + "，年龄：" + age;
        System.out.println(message);

        String userId = "U1001";
        String cacheKey = "user:info:" + userId;
        System.out.println("缓存键：" + cacheKey);
    }

    /**
     * 场景二：需要得到一个格式化字符串，使用 String.format()。
     */
    private static void stringFormatScenario() {
        printTitle("2. String.format()：生成订单信息");

        String orderId = "ORD20261123001";
        int quantity = 3;
        double amount = 1299.5;

        String message = String.format(
                "订单号：%s，数量：%d，应付金额：%.2f 元",
                orderId, quantity, amount
        );
        System.out.println(message);

        int id = 25;
        String userNumber = String.format("USER-%06d", id);
        System.out.println("用户编号：" + userNumber);
    }

    /**
     * 场景三：直接格式化输出到控制台，使用 System.out.printf()。
     */
    private static void printfScenario() {
        printTitle("3. System.out.printf()：输出控制台报表");

        String name = "李四";
        int points = 860;
        double balance = 256.8;

        System.out.printf(
                "用户：%s，积分：%d，余额：%.2f 元%n",
                name, points, balance
        );

        System.out.printf("%-12s %8s %12s%n", "商品", "数量", "金额");
        System.out.printf("%-12s %8d %12.2f%n", "键盘", 2, 398.00);
        System.out.printf("%-12s %8d %12.2f%n", "鼠标", 1, 99.90);
    }

    /**
     * 场景四：国际化消息模板，使用 MessageFormat。
     */
    private static void messageFormatScenario() {
        printTitle("4. MessageFormat：生成多语言消息");

        String chinese = "你好，{0}，你有 {1} 条未读消息";
        String english = "Hello, {0}, you have {1} unread messages";

        System.out.println(MessageFormat.format(chinese, "张三", 5));
        System.out.println(MessageFormat.format(english, "Tom", 5));

        String orderTemplate = "用户 {0} 于 {1,date,yyyy-MM-dd} 购买了 {2} 件商品，"
                + "应付金额：{3,number,#,##0.00} 元";

        String orderMessage = MessageFormat.format(
                orderTemplate,
                "张三",
                new Date(),
                3,
                1299.5
        );
        System.out.println(orderMessage);
    }

    /**
     * 场景五：多行 JSON、SQL、HTML 等模板。
     *
     * JDK 8 替代写法：使用多行字符串和 String.format()。
     */
    private static void textBlockAndFormattedScenario() {
        printTitle("5. 多行模板：生成 JSON");

        String name = "张三";
        int age = 20;
        double balance = 256.8;

        // 当前 JDK 8 可运行的替代写法。
        String json = String.format(
                "{\n"
                        + "  \"name\": \"%s\",\n"
                        + "  \"age\": %d,\n"
                        + "  \"balance\": %.2f\n"
                        + "}",
                name, age, balance
        );
        System.out.println(json);

        /*
         * JDK 15+ 推荐写法：文本块 + formatted()。
         *
         * String json = """
         *         {
         *           "name": "%s",
         *           "age": %d,
         *           "balance": %.2f
         *         }
         *         """.formatted(name, age, balance);
         *
         * System.out.println(json);
         */
    }

    private static void printTitle(String title) {
        System.out.println();
        System.out.println("========== " + title + " ==========");
    }
}
