package project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MySearchEngine implements SearchEngine{

	HashMap<String, List<DocumentId>> documentsMap = new HashMap<String, List<DocumentId>>();

	@Override
	public void add(Document document) {
		for(int i = 0; i < document.getTerms().length; i++ ){
			if(documentsMap.containsKey(document.getTerms()[i])){
				documentsMap.get(document.getTerms()[i]).add(document.getId());
			}
			else{
				List<DocumentId> newDocumentIdList =  new ArrayList<DocumentId>();
				newDocumentIdList.add(document.getId());
				documentsMap.put(document.getTerms()[i], newDocumentIdList);
			}
		}

	}
	
	
	public List<DocumentId> search(String... terms) {
	    return search(Arrays.asList(terms));
	  }



	@Override
	public List<DocumentId> search(List<String> terms) {
		List<DocumentId> result = new ArrayList<DocumentId>();
		if(!terms.isEmpty()){
			int i = 0;
			if(documentsMap.containsKey(terms.get(i))){
				result = new ArrayList<DocumentId>(documentsMap.get(terms.get(i)));
				while( i < terms.size() - 1 && documentsMap.containsKey(terms.get(i + 1))){
					result.retainAll(documentsMap.get(terms.get(i + 1)));
					i++;
				}
				if(i < terms.size() - 1 && !documentsMap.containsKey(terms.get(i + 1))){
					result = new ArrayList<DocumentId>();
				}
			}
		}
		return result;
	}
}
