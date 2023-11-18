public class Main
{
	public static void main(String[] args)
	{
		ListInterface<Integer> clist = new CircularLinkedList<Integer>();
		testList(clist);
	}

	static void testList(ListInterface<Integer> list)
	{
		System.out.println(list);
		System.out.println("Is empty? " + list.isEmpty());

		for (int i = 0; i < 10; i++)
			list.add((i + 1) * 11);

		System.out.println(list);
		System.out.println("Is empty? " + list.isEmpty());

		final var item1 = Integer.valueOf(44);
		System.out.println("Contains '" + item1 + "'? " + list.contains(item1));
		System.out.println("Index of '" + item1 + "'? " + list.indexOf(item1));

		final var item2 = Integer.valueOf(45);
		System.out.println("Contains '" + item2 + "'? " + list.contains(item2));
		System.out.println("Index of '" + item2 + "'? " + list.indexOf(item2));

		final var changedItem = list.set(list.indexOf(item1), item2);
		System.out.println(list);
		System.out.println("Contains '" + item1 + "'? " + list.contains(item1));
		System.out.println("Contains '" + item2 + "'? " + list.contains(item2));
		System.out.println("What item is changed? '" + changedItem + "'");

		final var removedItem = list.remove(4);
		System.out.println(list);
		System.out.println("What item is removed? '" + removedItem + "'");
		System.out.println("Contains '" + removedItem + "'? " + list.contains(removedItem));
		System.out.println("Index of '" + removedItem + "'? " + list.indexOf(removedItem));

		for (int i = 0; i < 5; i++)
			list.remove(0);

		System.out.println(list);
		System.out.println("Is empty? " + list.isEmpty());

		list.clear();
		System.out.println(list);
		System.out.println("Is empty? " + list.isEmpty());
	}
}
