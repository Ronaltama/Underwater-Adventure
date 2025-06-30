import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class player extends Actor
{
    final GreenfootImage[][] sprite = {
        { new GreenfootImage("1.png") }, // atas
        { new GreenfootImage("1.png") }, // kanan
        { new GreenfootImage("1.png") }, // idle/bawah
        { new GreenfootImage("2.png") }  // kiri
    };

    final int kecepatan = 3;
    int indexSprite = 2;
    int frame = 0;
    final int frameInterval = 8;

    public void act()
    {
        GerakkanAktor();
    }

    public void GerakkanAktor() {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - kecepatan);
            indexSprite = 0;
        } else if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + kecepatan);
            indexSprite = 2;
        }

        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - kecepatan, getY());
            indexSprite = 3;
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + kecepatan, getY());
            indexSprite = 1;
        }

        if (!Greenfoot.isKeyDown("up") && !Greenfoot.isKeyDown("down") &&
            !Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")) {
            setImage(sprite[2][0]); // Gambar idle (diam)
        } else {
            AnimasiJalan(indexSprite);
        }
    }

    public void AnimasiJalan(int arah) {
        // Animasi sederhana hanya pakai 1 frame (karena sprite hanya 1 gambar per arah)
        setImage(sprite[arah][0]);
    }
}
