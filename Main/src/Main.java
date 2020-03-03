import java.nio.channels.UnresolvedAddressException;

public class Main {
    public static void main(String[] args)  {

        String result = "";

        try {
             result = SheetsQuickstart.main().toString();
        } catch (Exception e){

        }

        try {
            PDF.main(result);
        } catch (Exception e){

        }

        HtmlEmailSender sendEmailToParents = new HtmlEmailSender();

        String parentAdress = "patrick.menendezrosado@saintandrews.net";
        String filename = "example.pdf";
        try {
            sendEmailToParents.sendHtmlEmail("patrick.menendezrosado@saintandrews.net",
                    "dmiskzqbsfytvedb",parentAdress, "Absence Report", "Something here","example.pdf");
        } catch (UnresolvedAddressException | javax.mail.MessagingException e){

        }

    }
}
