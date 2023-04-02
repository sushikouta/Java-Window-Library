import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Test {
    public static void main(String[] args) {
        new window("Test Window", 600, 400, true) {
            @Override public void init() {
                set_close_listener(EXIT_ON_CLOSE);
                set_location_center();

                add_click_listener(this::on_click);
                add_keybind_listener(this::on_keybind);

                new Thread(() -> {
                    while (true) {
                        repaint();
                    }
                }) {{
                    start();
                }};
            }

            @Override public void draw(BufferedImage window, Graphics2D g) {
                if (is_enter && mouse_x <= 200 && mouse_y <= 200) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.RED);
                }
                g.fillRect(0, 0, 200, 200);
            }

            public void on_click(window.click_event event) {
                System.out.println(event);
            }
            public void on_keybind(window.keybind_event event) {
                System.out.println(event);
            }
        };
    }
}
