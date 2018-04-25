/**
 * 
 */

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * @author Velma and Queen
 *
 */
public class MusicFile {

	/**
	 * 
	 */
	public MusicFile() {
		
	}

	
	public static void main(String[] args) {
		
		File Enya = new File("enyaonebyone.wav");
		System.out.println(Enya.exists());
        //File Enya = null;
        PlaySound(Enya);
        System.out.println("Enjoy the music");

	}
	
	static void PlaySound (File sound){
        try
        {
           Clip clip=AudioSystem.getClip(); 
           clip.open(AudioSystem.getAudioInputStream(sound));
           clip.start();
      Thread.sleep(clip.getMicrosecondLength()/1000);
            
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "Error");
    }
        																													
}

}
