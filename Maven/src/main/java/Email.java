public class Email {
    public String username;
    public String password;

    public String sender;
    public String receiver;
    public String subject;
    public String html;

    public void login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void buildMessage(String subject, String html) {
        this.subject = subject;
        this.html = html;
    }

    public Email() {
    }

    public Email(String username, String password, String sender, String receiver, String subject, String html) {
        this.username = username;
        this.password = password;
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.html = html;
    }
}
