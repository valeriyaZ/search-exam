package project1;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		MySearchEngine curEngine = new MySearchEngine();
		curEngine.add(new Document(new DocumentId(0) , "shalom dog"));
		curEngine.add(new Document(new DocumentId(1) , "dog cat frog"));
		curEngine.add(new Document(new DocumentId(2) , "cat frog "));
		curEngine.add(new Document(new DocumentId(3) , "cat frog dog mouse"));
		
		
		List<String> terms = new ArrayList<String>();
		terms.add("cat");
		terms.add("dog");
		terms.add("bla");
		
		List<DocumentId> result = curEngine.search(terms);
		// TODO Auto-generated method stub

	}

}
