package project1;

import java.util.Arrays;

/**
 * Created by Ohad Serfaty on 6/9/15.
 */
public class Document {

  final String[] terms;
  private final DocumentId id;

  public Document(DocumentId id, String text){
    this.id = id;
    terms = text.split(" ");
  }

  public String[] getTerms(){
    return this.terms;
  }

  public DocumentId getId(){
    return this.id;
  }

}	