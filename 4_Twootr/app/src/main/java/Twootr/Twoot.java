///////////////////////////////////////////////////////////////////////////////
// Main Class File: Twootr.java
// File: class.Twoot.java
// Date: April 1, 2021
// Programmer: Alexander Kitaro Funai
// Email: alexanderfunai@protonmail.com
// Website: https://www.alexanderfunai.com
///////////////////////////////////////////////////////////////////////////////
// Sources: Real World Software Development
// Authors: Rauol-Gabriel Urma & Richard Warburton
// Sources: github.com/Iteratr-Learning/Real-World-Software-Development.git
///////////////////////////////////////////////////////////////////////////////

package Twootr;

import java.util.Objects;

public final class Twoot {
    private final String id;
    private final String senderId;
    private final String content;
    private final Position position;

    public Twoot(final String id, final String senderId, final String content, final Position position) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(senderId, "senderId");
        Objects.requireNonNull(content, "content");
        Objects.requireNonNull(position, "position");

        this.id = id;
        this.position = position;
        this.senderId = senderId;
        this.content = content;
    }

    public boolean isAfter(final Position otherPosition) {
        return position.getValue() > otherPosition.getValue();
    }

    public String getId() {
        return id;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getContent() {
        return content;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Twoot twoot = (Twoot) o;

        return id.equals(twoot.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Twoot{" +
                "id='" + id + '\'' +
                ", senderId='" + senderId + '\'' +
                ", content='" + content + '\'' +
                ", position=" + position +
                '}';
    }
}