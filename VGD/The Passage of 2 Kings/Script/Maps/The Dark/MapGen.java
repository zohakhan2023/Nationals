import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MapGen extends JPanel {
    private static final int MAP_SIZE = 100;
    private static final int TILE_SIZE = 32;
    private BufferedImage[] tiles;

    public MapGenerator() {
        try {
            tiles = new BufferedImage[3]; // Adjust based on the number of tiles you're using
                tiles[0] = ImageIO.read(new File("art/grass_tile.png")); // Example tile
                tiles[1] = ImageIO.read(new File("art/dirt_tile.png")); // Example tile
                tiles[2] = ImageIO.read(new File("art/water_tile.png")); // Example tile
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int y = 0; y < MAP_SIZE; y++) {
                for (int x = 0; x < MAP_SIZE; x++) {
                    double noiseValue = PerlinNoiseGenerator.noise(x / 10.0, y / 10.0);
                    int tileIndex = (int) (noiseValue * tiles.length); // Adjust based on the number of tiles
                    g.drawImage(tiles[tileIndex], x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
                }
            }
        }
    
        public static void main(String[] args) {
            JFrame frame = new JFrame("Map Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(MAP_SIZE * TILE_SIZE, MAP_SIZE * TILE_SIZE);
            frame.add(new MapGenerator());
            frame.setVisible(true);
        }
    }
    