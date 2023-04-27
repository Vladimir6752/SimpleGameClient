package org.example.visual.abstractcomponents;

import java.util.function.Consumer;

public interface ComboBox extends VisualComponent {
    void addOnSubmitListener(Consumer<?> listener);

    String getSelectedElement();
}
