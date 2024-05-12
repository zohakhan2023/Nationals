package Entity;

import main.KeyHandler;
import main.gamePanel;
import java.awt.Color;
import java.awt.Graphics2D;

public class player extends entity {
    gamePanel gp;
    KeyHandler keyH;

    public player(gamePanel gp, KeyHandler key) {
        this.gp = gp;
        keyH = key;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 5;
            direction = "down";
        }
    
        public void getPlayerImage() {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/art/player_up_1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/art/player_up_2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/art/player_down_1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/art/player_down_2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/art/player_right_1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/art/player_right_2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/art/player_left_1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/art/player_left_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        public void update() {
            if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true
                    || keyH.downPressed == true) {
                if (keyH.upPressed == true) {
                    direction = "up";
                    y -= speed;
                }
                if (keyH.downPressed == true) {
                    direction = "down";
                    y += speed;
                }
                if (keyH.leftPressed == true) {
                    direction = "left";
                    x -= speed;
                }
                if (keyH.rightPressed == true) {
                    direction = "right";
                    x += speed;
                }
                spriteCounter++;
                if (spriteCounter > 15) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            }
        }
    
        public void Draw(Graphics2D g2D) {
            BufferedImage img = null;
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        img = up1;
                    }
                    if (spriteNum == 2) {
                        img = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        img = down1;
                    }
                    if (spriteNum == 2) {
                        img = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        img = left1;
                    }
                    if (spriteNum == 2) {
                        img = left2;
                    }
                    break;
    
                case "right":
                    if (spriteNum == 1) {
                        img = right1;
                    }
                    if (spriteNum == 2) {
                        img = right2;
                    }
                    break;
            }
            g2D.drawImage(img, x, y, gp.tileSize, gp.tileSize, null);
        }
    }
    