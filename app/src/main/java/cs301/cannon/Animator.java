package cs301.cannon;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * An interface that defines an object that is capable of drawing an animation.
 * It is intended to be used with the AnimationCanvas class.
 * 
 * @author Steve Vegdahl
 * @author Andrew Nuxoll
 * @author Daniel Rothschilds
 * @version November 1st 2015
 */

public interface Animator {

	/**
	 * The time interval (in milliseconds) between animation frames. Thus, for
	 * example, to draw a frame 20 times per second, you would return 50. This
	 * method is called once at the beginning of the animation, so changing the
	 * value during the animation will have no effect.
	 * 
	 * @return the time interval (in milliseconds) between calls to this class'
	 *         "tick" method.
	 */
	public int interval();

	/**
	 * The background color with which to paint the canvas before the animation
	 * frame is drawn. This method is called at each tick, so the background
	 * color can change dynamically by having this method return different
	 * values.
	 * 
	 * @return the desired background color
	 */
	public int backgroundColor();

	/**
	 * Tells whether the animation should be paused.
	 * 
	 * @return a true/false value that says whether the animation should be
	 *         paused.
	 */
	public boolean doPause();

	/**
	 * Tells whether the animation should be stopped.
	 * 
	 * @return true/false value that tells whether to terminate the animation.
	 */
	public boolean doQuit();

	/**
	 * Called once every clock tick (frequency specified by the "interval"
	 * method) to draw the next animation-frame. Typically this is used to
	 * update the animation's data to reflect the passage of time (e.g., to
	 * modify an instance variable that gives the position of an object) before
	 * the frame is drawn.
	 * 
	 * @param canvas
	 *            the Canvas object on which to draw the animation-frame.
	 */
	public void tick(Canvas canvas);

	/**
	 * reloadAndFire:
	 * Called when the user clicks the fire button with the values inputed by the user.
	 * The reason for making it a method in the interface is so the CannonMainActivity can call the method from the main activity
	 * @param velocity
	 * @param theta
	 * @param gravity
	 */
	public void reloadAndFire(double velocity, double theta, double gravity);

	/**
	 * Method to reset the Cannon and the shot
	 */
	public void reset();


	/**
	 * Called whenever the user touches the AnimationCanvas so that the
	 * animation can respond to the event.
	 * 
	 * @param event a MotionEvent describing the touch
	 */
	public void onTouch(MotionEvent event); 
}
