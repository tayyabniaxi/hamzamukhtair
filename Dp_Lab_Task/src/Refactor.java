import java.util.ArrayList;
import java.util.List;

// Product interface
interface Button {
    void render();
    void onClick();
}

// Concrete Product
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }

    @Override
    public void onClick() {
        System.out.println("Windows Button clicked");
    }
}

// Concrete Product
class HTMLButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering HTML Button");
    }

    @Override
    public void onClick() {
        System.out.println("HTML Button clicked");
    }
}

// Creator abstract class
abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    // Factory Method
    public abstract Button createButton();
}

// Concrete Creator
class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

// Concrete Creator
class WebDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}

public class Refactor {
    public static void main(String[] args) {
        List<Dialog> dialogs = new ArrayList<>();
        dialogs.add(new WindowsDialog());
        dialogs.add(new WebDialog());

        for (Dialog dialog : dialogs) {
            dialog.renderWindow();
        }
    }
}
