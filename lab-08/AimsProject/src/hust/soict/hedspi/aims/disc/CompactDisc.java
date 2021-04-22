package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;

    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String id, String title, String category, String artist, float cost) {
        super(id, title, cost);
        this.artist = artist;
        this.category = category;
    }

    public void addTrack(Track track) {
        if(tracks.contains(track)) {
            System.err.println("Track has been existed");
        }else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if(tracks.contains(track)) {
            tracks.remove(track);
        }else {
            System.err.println("Don't find track");
        }
    }

    public int getLength() {
        int sum = 0;
        for(Track track: tracks) {
            sum += track.getLength();
        }
        super.length = sum;
        return sum;
    }

    @Override
    public void play() {
        for(Track track: tracks) {
            System.out.println("Playing CD: " + track.getTitle() + "CD length: " + track.getLength());
        }
    }

    public int compareTo(Media media) {
        if(media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc)media;
            if(tracks.size() == cd.tracks.size()) {
                return Integer.compare(this.length, cd.getLength());
            }
            else if(tracks.size() < cd.tracks.size())
                return -1;
            else return 1;
        }else {
            return super.compareTo(media);
        }
    }
}
