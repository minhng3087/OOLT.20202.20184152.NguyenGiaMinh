package hust.soict.hedspi.aims.media;

import java.util.*;

public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<>();
    private String content;
    public List<String> contentTokens = new ArrayList<>();
    private Map<String, Integer> wordFrequency = new TreeMap<>();

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }


    public Book(String id, String title, float cost) {
        super(id, title, cost);
    }

    public Book(String id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(String id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);
        if(authors.size() != 0) {
            this.authors = authors;
        }else {
            System.out.println("Authors list is empty!");
        }
    }

    public Book() {
        super();
    }
    public void addAuthor(String authorName){
        for(String author: authors) {
            if(author.equalsIgnoreCase(authorName)) {
                System.err.println("Existed author name");
                return;
            }
        }
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        for(String author: authors) {
            if(author.equalsIgnoreCase(authorName))
                authors.remove(author);
            return;
        }
        System.err.println("Don't find author name");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }

    public void processContent() {

        contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        Collections.sort(contentTokens);
        Iterator<String> iterator = contentTokens.iterator();
        while(iterator.hasNext()) {
            String string = iterator.next();
            if (!wordFrequency.containsKey(string)) {
                wordFrequency.put(string, 1);
            }else {
                int a = wordFrequency.get(string);
                a++;
                wordFrequency.put(string, a);
            }
        }
    }

    public String toString() {
        System.out.println("---------Book Information-----------");
        System.out.println("- Title: " + this.getTitle());
        System.out.println("- Catogory: " + this.getCategory());
        System.out.println("- Cost: " + this.getCost());
        System.out.println("- Author: " + this.getAuthors());
        System.out.println("- Content: " + this.content);
        System.out.println("- Content Length: " + this.contentTokens.size());
        System.out.println("- Content Token in sorted order: " + this.contentTokens);
        System.out.println("- Token List & Frequency: ");
        wordFrequency.forEach((key, value) -> System.out.println("\t" + key + ": \t" + value));
        System.out.println("------------------------------------");
        return content;
    }

}
