package P64_Streams_API;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // Random variables
        String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

        // Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        // Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();

        // Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList("This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!")
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";

        // Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

        // Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";

    }

    // ANSWER - BEGIN
    public static class ABSSomeThing <T> {
        String from;
        String to;
        T content;

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }

    public static class MailMessage extends ABSSomeThing<String> {

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public void setFrom(String from) {
            this.from = from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public void setTo(String to) {
            this.to = to;
        }

        @Override
        public String getContent() {
            return content;
        }

        @Override
        public void setContent(String content) {
            this.content = content;
        }

        public MailMessage(String from, String to, String content) {
            setFrom(from);
            setTo(to);
            setContent(content);
        }
    }
    //=========================================
    public static class Salary {
        String from;
        String to;
        Integer salary;

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public Salary(String fromCompany, String toEmployee, Integer salary) {
            setFrom(fromCompany);
            setTo(toEmployee);
            setSalary(salary);
        }
    }
    //=========================================
    public static class MailService <T> implements Consumer<ABSSomeThing> {
        String from;
        String to;
        T t;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public T getT() {
            return t;
        }

        public void setT(Object t) {
            this.t = (T)t;
        }

        public <T> MailService(String from, String to, T t) {
            setFrom(from);
            setTo(to);
            setT(t);
        }

        public MailService() {
        }

        public Map<String, List<T>> getMailBox() {
            return new HashMap<String, List<T>>();
        }

        @Override
        public void accept(ABSSomeThing s) {
            System.out.println(s);
        }
    }
    // ANSWER - END
}
