package test.ec.arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/*
1. Create a ArrayList subclass that would adapt its size on the fly when it is requested for an element at a certain position. Use generics to adapt to any class.
For example:
Let's say we have an instantiated list having no elements. As a consequence,  list.size() == 0 is true.
Write the subclass in such a way that if I would call list.get(2), I would get back an entity and not a array index out of bounds exception . Moreover it would create 3 entities and fill the list up to index 2.
*/

public class MyArrayList<T> extends ArrayList<T> {

	private static final long serialVersionUID = 9201154858006970545L;

	T entityObj;

	private int getLastIndex() {
		return size() - 1;

	}

	@Override
	public T get(int position) {
		while (position > getLastIndex()) {
			add(entityObj);
		}

		return super.get(position);

	}

	public MyArrayList(T fillerObjPar) {
		super();
		entityObj = fillerObjPar;
	}

	public MyArrayList(Collection<? extends T> c, T fillerObjPar) {
		super(c);
		entityObj = fillerObjPar;
	}

	public MyArrayList(int initialCapacity, T fillerObjPar) {
		super(initialCapacity);
		entityObj = fillerObjPar;
	}

	public static void main(String[] args) {

		test1();
		test2();
	}
	
	//test for String
	private static  void test1()
	{
		{
			String entity = "I am the entity";

			MyArrayList<String> mya = new MyArrayList<String>(entity);

			System.out.println("BEFORE:" + mya.toString());
			System.out.println(mya.get(4));
			System.out.println("AFTER:" + mya.toString());
		}
		System.out.println("");

		{
			String entity = "I am the entity";

			MyArrayList<String> mya = new MyArrayList<String>(7, entity);

			System.out.println("BEFORE:" + mya.toString());
			System.out.println(mya.get(4));
			System.out.println("AFTER:" + mya.toString());
		}
		System.out.println("");

		{
			String entity = "I am the entity";

			MyArrayList<String> mya = new MyArrayList<String>(7, entity);

			for (int cnt = 0; cnt < 7; cnt++)
				mya.add("Inserted " + cnt);

			System.out.println("BEFORE:" + mya.toString());
			System.out.println(mya.get(4));
			System.out.println("AFTER:" + mya.toString());
		}
		System.out.println("");
	}
	
	//test for Date
	private static  void test2()
	{
		{
			Date entity = new  Date();

			MyArrayList<Date> mya = new MyArrayList<Date>(entity);

			System.out.println("BEFORE:" + mya.toString());
			System.out.println(mya.get(4));
			System.out.println("AFTER:" + mya.toString());
		}
		System.out.println("");

		{
			Date entity = new  Date();

			MyArrayList<Date> mya = new MyArrayList<Date>(7, entity);

			System.out.println("BEFORE:" + mya.toString());
			System.out.println(mya.get(4));
			System.out.println("AFTER:" + mya.toString());
		}
		System.out.println("");

		{
			Date entity = new  Date();

			MyArrayList<Date> mya = new MyArrayList<Date>(7, entity);

			for (int cnt = 0; cnt < 7; cnt++)
				mya.add(new Date());

			System.out.println("BEFORE:" + mya.toString());
			System.out.println(mya.get(4));
			System.out.println("AFTER:" + mya.toString());
		}
		System.out.println("");
	}


}
