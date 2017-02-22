package cn.zy.LinearList;

public class TestSeqList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinearList l = new SequenceList();
//		System.out.println(l.size());
//		System.out.println(l.indexof(null));
		l.add("1");
		l.add("2");
		l.add(3);
		l.add(4);
		//l.display();
		l.add(2, 23);
		//l.display();
		//l.remove(2);
		//l.display();
		l.clear();
		l.display();

	}

}
