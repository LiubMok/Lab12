package decorator;

public class TimedDocument implements Document {
    Document document;
    public TimedDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        return document.parse();
    }
}
