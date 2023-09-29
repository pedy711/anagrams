package org.example;

import java.util.HashSet;
import java.util.Set;

public class TextSubject implements Subject, Observer {
  private final Set<TextSubject> anagrams;
  private final String text;

  public TextSubject(String text) {
    anagrams = new HashSet<>();
    this.text = text;
  }

  @Override
  public void addObserver(Observer observer) {
    if(observer instanceof TextSubject textSubject) {
      anagrams.add(textSubject);
    }
    notifyObservers();
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : anagrams) {
      observer.update(this);
    }
  }

  @Override
  public void update(Subject subject) {
    if(subject instanceof TextSubject textSubject) {
      this.anagrams.add(textSubject);
      this.anagrams.addAll(textSubject.getAnagrams());
      this.anagrams.removeIf(item -> item == this);
    }
  }

  public Set<TextSubject> getAnagrams() {
    return this.anagrams;
  }

  public String getText(){
    return this.text;
  }

}
