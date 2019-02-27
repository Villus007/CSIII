import mayflower.*;
public class Animation
{
  private Picture[] frames;
  private int frameRate;
  private int currentFrame;
  public Animation(int frame ,String[] file)
  {
   frames = new Picture[file.length];
   for(int j = 0; j < file.length; j++)
   {
     frames[j] = new Picture(file[j]);
   }
  }
  public int getFrameRate()
  {
     return frameRate;
  }
  Picture getNextFrame()
  {
     currentFrame = (currentFrame + 1)% (frames.length); 
     Picture p = frames[currentFrame];   
     return p;
  }
  public void resize (int w, int h)
  {
     for(int k = 0; k < frames.length; k++)
     {
       frames[k].resize(w, h); 
     }
  }
}
