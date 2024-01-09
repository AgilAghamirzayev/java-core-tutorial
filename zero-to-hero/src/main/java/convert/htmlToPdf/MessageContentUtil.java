package convert.htmlToPdf;

public class MessageContentUtil {

    private String content;

    public MessageContentUtil(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static MessageContentBuilder builder() {
        return new MessageContentBuilder();
    }

    @SuppressWarnings("checkstyle:hiddenfield")
    public static class MessageContentBuilder {

        private String content;

        public MessageContentBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public MessageContentBuilder setValue(String key, String value) {
            this.content = this.content.replace(String.format("[%s]", key), value);
            return this;
        }

        public String build() {
            return this.content;
        }

        @Override
        public String toString() {
            return "MessageContent.MessageContentBuilder(content=" + this.content + ")";
        }
    }
}
