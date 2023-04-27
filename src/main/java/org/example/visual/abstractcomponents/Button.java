package org.example.visual.abstractcomponents;

import java.util.function.Consumer;

public interface Button extends VisualComponent {
    void addOnClickListener(Consumer<?> listener);

    void setText(String text);
}
