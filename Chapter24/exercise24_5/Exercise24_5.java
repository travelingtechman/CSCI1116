package exercise24_5;

public class Exercise24_5<E>  {
	public static void main(String[] args) {
		GenericQueue<String> q = new GenericQueue<>();
		q.enqueue("\"Final Countdown\" (Europe)");
		q.enqueue("\"Life is a Highway\" (Rascal Flatts)");
		q.enqueue("\"MEGALOVANIA\" (undertale soundtrack)");
		q.enqueue("\"Haboglabotribin\" (Bernard Wright)");
		q.enqueue("\"Stunted\" (San Francisco Rush 2049 soundtrack)");
		q.enqueue("\"115\" (black ops1 zombies moon rock easter egg song");
		System.out.print("there are " + q.getSize() + " songs in the queue \n" + q.toString());
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println("\nthere are now " + q.getSize() + " songs in the queue \n" + q.toString());
		
	}
}
