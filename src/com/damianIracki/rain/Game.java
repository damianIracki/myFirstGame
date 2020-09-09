package com.damianIracki.rain;

import com.damianIracki.rain.entity.mob.Player;
import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.input.Keyboard;
import com.damianIracki.rain.levels.Level;
import com.damianIracki.rain.levels.RandomLevel;
import com.damianIracki.rain.levels.SpawnLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable{

    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    public static String title = "Rain";

    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Level level;
    private Player player;
    private boolean running = false;

    private Screen screen;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();        //converting image object into ray of integers

    public Game(){
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        level = new SpawnLevel("/textures/level.png");
        player = new Player(key);
        addKeyListener(key);
    }

    public synchronized void start(){
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;   //60 fps
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta  >= 1){
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frame.setTitle(title + " | " + "frames: " + frames + ", updates: " + updates);
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public void update(){
        key.update();
        player.update();
    }

    public void render(){
        BufferStrategy bufferStrategy = getBufferStrategy();
        if(bufferStrategy == null){
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        //location a player on the screen
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        level.render(xScroll, yScroll, screen);
        player.render(screen);

        for(int i = 0; i < pixels.length; i++){
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.WHITE);
        //g.setFont(new Font("Verdana", 0, 50));
        //g.drawString("X: "+ player.x + ", Y: " + player.y, 450, 400);
        g.dispose();
        bufferStrategy.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(Game.title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }

}
