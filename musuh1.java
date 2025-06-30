import greenfoot.*;

public class musuh1 extends Actor
{
    private int speed = 2; // Kecepatan musuh

    public void act()
    {
        // Gerakkan musuh ke kiri
        moveLeft();

        // Periksa jika musuh sudah melewati tepi kiri layar
        if (getX() <= 0) {
            respawnRight();
        }
    }

    /**
     * Menggerakkan aktor ke kiri berdasarkan kecepatan.
     */
    private void moveLeft()
    {
        setLocation(getX() - speed, getY());
    }

    /**
     * Memindahkan aktor ke sisi kanan layar pada posisi Y yang acak.
     */
    private void respawnRight()
    {
        World world = getWorld();
        if (world != null) {
            int worldWidth = world.getWidth();
            int worldHeight = world.getHeight();
            int randomY = Greenfoot.getRandomNumber(worldHeight);
            
            // Atur lokasi ke sisi paling kanan (lebar dunia - 1)
            setLocation(worldWidth - 1, randomY);
        }
    }
}