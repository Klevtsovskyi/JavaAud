package T10_Network;

public class A10_03_Protocol {
	
	final static String START    = "START";     // Розпочати обмін між клієнтами
	final static String CLIENT   = "CLIENT";    // Працювати як 1 або 2 клієнт (інше - невідомий клієнт)
	final static String MESSAGE  = "MESSAGE";   // Передати програмі повідомлення
	final static String QUESTION = "QUESTION";  // Надіслати рядок на обробку клієнту 1
	final static String ANSWER   = "ANSWER";    // Результат обробки рядка клієнтом 1
	final static String END      = "END";       // Завершити роботу і роз`єднатися
	
	final static int PORT = 10030; 
	
	private A10_03_Protocol() {}
}
