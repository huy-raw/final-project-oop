package data;

import java.util.Comparator;

public class Comparison {

    public Comparison() {
    }

    public static class sortByID implements Comparator<Document> {
        @Override
        public int compare(Document a, Document b) {
            return b.getID().compareTo(a.getID());
        }
    }

    public static class sortByPublisher implements Comparator<Document> {
        @Override
        public int compare(Document a, Document b) {
            return b.getPublisher().compareTo(a.getPublisher());
        }
    }

    public static class sortByReleaseNumber implements Comparator<Document> {
        @Override
        public int compare(Document a, Document b) {
            int releaseNumberOfA = a.getReleaseNumber(),
                    releaseNumberOfB = b.getReleaseNumber();

            return releaseNumberOfA < releaseNumberOfB ? -1 : releaseNumberOfA == releaseNumberOfB ? 0 : 1;
        }
    }
}
