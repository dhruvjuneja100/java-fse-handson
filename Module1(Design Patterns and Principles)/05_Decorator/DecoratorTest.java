public class DecoratorTest {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();

        notifier = new SMSNotifierDecorator(notifier);

        notifier = new SlackNotifierDecorator(notifier);

        System.out.println("--- Sending via Email + SMS + Slack ---");
        notifier.send("Server downtime alert!");
    }
}
