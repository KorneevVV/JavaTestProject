/**
 * Created by USERrr on 26.04.2017.
 */
public class Mail {
    private String recipient;
    private String subject;
    private String text;

    public Mail(String recipient, String subject, String text) {
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
