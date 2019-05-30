package P35_abstractTextAnalyzer;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        String text = "If this thing=(";
        //String text = "";

        new Main().doCheck(text);
    }

    public void doCheck(String textToCheck) {
        TextAnalyzer[] analyzers = new TextAnalyzer[] {
                new SpamAnalyzer(new String[]{"fuck", "dick"}),
                new TooLongTextAnalyzer(20),
                new NegativeTextAnalyzer()
        };
        System.out.println(checkLabels(analyzers, textToCheck));
    }

    // SOLUTION START
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }

        return Label.OK;
    }

    abstract class KeywordAnalyzer implements TextAnalyzer {
        protected abstract String[] getKeywords();
        protected abstract Label getLabel();

        public Label processText(String text) {
            String ans = Arrays.stream(getKeywords())
                    .filter(text::contains)
                    .findAny()
                    .orElse(null);

            if (ans != null) return getLabel();

            return Label.OK;
        }
    }

    class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        private void setKeywords(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        public String[] getKeywords() {
            return this.keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }

        public SpamAnalyzer(String[] keyWords) {
            setKeywords(keyWords.clone());
        }
    }

    class NegativeTextAnalyzer extends KeywordAnalyzer {
        String[] negativeSmiles = new String[]{":(","=(",":|"};

        public NegativeTextAnalyzer() {
        }

        @Override
        protected String[] getKeywords() {
            return negativeSmiles;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public int getMaxLength() {
            return this.maxLength;
        }

        private void setMaxLength(int maxLength) {
            this.maxLength = maxLength;
        }

        public TooLongTextAnalyzer(int maxLong) {
            setMaxLength(maxLong);
        }

        @Override
        public Label processText(String text)
        {
            if (text.length() > getMaxLength()) {
                return Label.TOO_LONG;
            }
            return Label.OK;
        }
    }
    // SOLUTION END
}