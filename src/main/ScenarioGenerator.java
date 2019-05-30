public class ScenarioGenerator {

    public static void main(String[] args) {

        String[] roles = {"Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "-2",
                "sdfsdSDfsd",
                "Лука Лукич"};

        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "-5",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        System.out.println(new ScenarioGenerator().printTextPerRole(roles, textLines));
    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        if (roles.length == 0 || roles == null){
            return "";
        }

        StringBuilder builder = new StringBuilder();

        // Промежуточный массив
        String[][] temp = new String[roles.length + 1][textLines.length + 1];

        // Моссив смещений
        int[] var1 = new int[roles.length];

        // Заполняем роли в промежуточном массиве
        for (int i = 0; i < roles.length; i++) {
                temp[i][0] = roles[i];
            }

        // Парсим текст
        for (int i = 0; i < textLines.length; i++) {
            for (int k = 0; k < roles.length; k++) {
                if (textLines[i].startsWith(temp[k][0] + ":")) {
                    int a = textLines[i].indexOf(":") + 2;
                    int b = textLines[i].length();
                    String sbStr = textLines[i].substring(a, b);
                    temp[k][1 + var1[k]++] = i+1 + ") " + sbStr;
                }
            }
        }

        // Собираем итоговый массив
        for (int i = 0; i < roles.length; i++) {
            builder.append(temp[i][0] + ":" + "\n");

            for (int k = 1; k < temp[i].length; k++) {
                if (temp[i][k] == null){
                    break;
                }
                builder.append(temp[i][k] + "\n");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}