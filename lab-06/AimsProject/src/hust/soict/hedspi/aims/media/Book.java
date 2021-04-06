package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<>();

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
    public void addAuthor(String authorName){
        for(String author: authors) {
            if(author.equalsIgnoreCase(authorName))
                System.err.println("Existed author name");
            return;
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
}
