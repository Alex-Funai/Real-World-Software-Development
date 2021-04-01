package Twootr;

public interface TwootRepository {
    Twoot add(String id, String userId, String content);
    Optional<Twoot> get(String id);
    void delete(Twoot twoot);
    void query(TwootQuery twootQuery, Consumer<Twoot> callback);
    void clear();
}
