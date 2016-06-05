package game.tools;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * 
 * @author Leibniz H. Berihuete
 * 
 * Date Started: 6/01/2016 7:46 AM
 * Last Modification: 6/01/2016 8:31 PM
 * 
 * MenuButton class
 * This class creates an interactive menu-button
 * so that the Menu class can use it. This class also inherits 
 * from the StackPane class; a container that puts any node
 * at the center.
 */
public class MenuButton extends StackPane {
	// Default Values:
	private static final int WIDTH = 150;
	private static final int HEIGHT = 40;
	private static final int FONT_SIZE = 16;
	private static final double OPACITY = 0.7;
	private static final Color DEFAULT_COLOR = Color.BLACK;
	private static final Color HOVER_COLOR = Color.CORAL;
	private static final Color PRESSED_COLOR = Color.CHARTREUSE;
	private static final Color TEXT_COLOR = Color.WHITE;
	
	
	// Components needed
	private Rectangle background;
	private Label text;
	
	// Colors
	private Color hoverColor;
	private Color pressedColor;
	
	// For a unique ID-- each menu button must have a unique id.
	private static int idCount = -1;
	private int id;
	
/* ***********************
 *     CONSTRUCTORS
 * **********************/
	/**
	 * Default Constructor
	 * Initializes the button's background and text with
	 * default values: 
	 *   background color: CORNFLOWERBLUE,
	 *   background size: 150 x 40;
	 *   background opacity: 80%
	 *   text: 'Menu Button #number'
	 *   text color: WHITE
	 *   text size: 16.0 
	 *   hover color: CORAL;
	 */
	public MenuButton(){
		id = ++idCount;
		
		// Initialize background:
		background = new Rectangle(WIDTH, HEIGHT);
		background.setFill(DEFAULT_COLOR);
		background.setOpacity(OPACITY);
		
		// Initialize text
		text = new Label("Menu Button# " + id);
		text.setTextFill(TEXT_COLOR);
		text.setFont(Font.font(FONT_SIZE));
		
		// initialize Color
		setHoverColor(HOVER_COLOR);
		setPressedColor(PRESSED_COLOR);
		
		this.setRotate(this.getRotate()+5);
		
		buildButtonFunctionality();
		
		// Add it to this StackPane
		this.getChildren().addAll(background, text);
	}
	
	/**
	 * Constructor(String)
	 * Initializes the button's background and text with
	 * default values: 
	 *   background color: CORNFLOWERBLUE,
	 *   background size: 150 x 40;
	 *   background opacity: 80% 
	 *   text color: WHITE
	 *   text size: 16.0 
	 *   hover color: CORAL;
	 * @param textStr holds the text of the menuButton  
	 */
	public MenuButton(String textStr){
		id = ++idCount;
		
		// Initialize background:
		background = new Rectangle(WIDTH, HEIGHT);
		background.setFill(DEFAULT_COLOR);
		background.setOpacity(OPACITY);
		
		// Initialize text
		text = new Label(textStr);
		text.setTextFill(TEXT_COLOR);
		text.setFont(Font.font(FONT_SIZE));
		
		// initialize Color
		setHoverColor(HOVER_COLOR);
		setPressedColor(PRESSED_COLOR);
		
		this.setRotate(this.getRotate()+5);
		
		buildButtonFunctionality();
		
		// Add it to this StackPane
		this.getChildren().addAll(background, text);
	}
	
	/**
	 * Constructor(double, double)
	 * Initializes the button's background and text with
	 * default values: 
	 *   background color: CORNFLOWERBLUE,
	 *   background opacity: 80%
	 *   text: 'Menu Button #number'
	 *   text color: WHITE
	 *   text size: 16.0 
	 *   hover color: CORAL;
	 *  @param width holds the width of menu button's background
	 *  @param height holds the height of menu button's background
	 */
	public MenuButton(double width, double height){
		id = ++idCount;
		
		// Initialize background:
		background = new Rectangle(width, height);
		background.setFill(DEFAULT_COLOR);
		background.setOpacity(OPACITY);
		
		
		// Initialize text
		text = new Label("Menu Button# " + id);
		text.setTextFill(TEXT_COLOR);
		text.setFont(Font.font(FONT_SIZE));
		
		// initialize Color
		setHoverColor(HOVER_COLOR);
		setPressedColor(PRESSED_COLOR);
		
		this.setRotate(this.getRotate()+5);
		
		buildButtonFunctionality();
		
		// Add it to this StackPane
		this.getChildren().addAll(background, text);
	}
	
	/**
	 * Constructor(String, double, double)
	 * Initializes the button's background and text with
	 * default values: 
	 *   background color: CORNFLOWERBLUE,
	 *   background opacity: 80%
	 *   text color: WHITE
	 *   text size: 16.0 
	 *   hover color: CORAL;
	 *  @param textStr holds the text of the menuButton  
	 *  @param width holds the width of menu button's background
	 *  @param height holds the height of menu button's background
	 */
	public MenuButton(String textStr, double width, double height){
		id = ++idCount;
		
		// Initialize background:
		background = new Rectangle(width, height);
		background.setFill(DEFAULT_COLOR);
		background.setOpacity(OPACITY);
		
		
		// Initialize text
		text = new Label(textStr);
		text.setTextFill(TEXT_COLOR);
		text.setFont(Font.font(FONT_SIZE));
		
		// initialize Color
		setHoverColor(HOVER_COLOR);
		setPressedColor(PRESSED_COLOR);
		
		this.setRotate(this.getRotate()+5);
		
		buildButtonFunctionality();
		
		// Add it to this StackPane
		this.getChildren().addAll(background, text);
	}
	
	
	
	
/* *********************
 *      MUTATORS
 * *********************/
	/**
	 * text Setter:
	 * @param text holds the name of the menu button
	 */
	public void setText(String text) {
		this.text.setText(text);
	}
	
	/**
	 * text color Setter:
	 * @param color holds the color of the menu button's text
	 */
	public void setTextColor(Color color) {
		this.text.setTextFill(color);
	}
	
	/**
	 * text size Setter
	 * @param textSize holds the font size of the menu button's text
	 */
	public void setTextSize(double textSize) {
		this.text.setFont(Font.font(textSize));
	}
	
	
	/**
	 * Background Width Setter:
	 * @param width holds the width of the menu button's background.
	 */
	public void setRectBackgroundWidth(double width) {
		this.background.setWidth(width);
	}
	
	/**
	 * Background Height Setter:
	 * @param height holds the height of the menu button's background.
	 */
	public void setRectBackgroundHeight(double height) {
		this.background.setHeight(height);
	}
	
	/**
	 * background color Setter:
	 * @param color holds the color of the menu button's text
	 */
	public void setRectBackgroundColor(Color color) {
		this.background.setFill(color);
	}
	
	/**
	 * hoverColor Setter:
	 * @param color holds the color that appears when mouse
	 * hovers the menu button
	 */
	public void setHoverColor(Color color) {
		this.hoverColor = color;
	}
	
	/**
	 * pressedColor Setter:
	 * @param color holds the color that appears when mouse
	 * presses the menu button
	 */
	public void setPressedColor(Color color) {
		this.pressedColor = color;
	}
	
	
	
/* *********************
 *      ACCESSORS
 * *********************/
	/**
	 * text Getter:
	 * @return the text of the menu button
	 */
	public String getText() {
		return text.getText();
	}
	
	/**
	 * text color Getter:
	 * @return the color of the menu button's text.
	 */
	public Color getTextColor() {
		return (Color) text.getTextFill();
	}
	
	/**
	 * text Size Getter:
	 * @return the size of the menu button's text.
	 */
	public double getTextSize() {
		return text.getFont().getSize();
	}
	
	/**
	 * Background Getter:
	 * @return the background of the menu button.
	 */
	public Rectangle getRectBackground() {
		return background;
	}
	
	/**
	 * background color Getter:
	 * @return the color of the menu button's background.
	 */
	public Color getRectBackgroundColor() {
		return (Color)background.getFill();
	}
	
	/**
	 * background Width Getter:
	 * @return the width of the menu button's background
	 */
	public double getRectBackgroundWidth() {
		return background.getWidth();
	}
	
	/**
	 * background height Getter:
	 * @return the height of the menu button's background
	 */
	public double getRectBackgroundHeight() {
		return background.getHeight();
	}
	
	/**
	 * hoverColor Getter:
	 * @return the color that appears when the mouse
	 * hovers the menu button.
	 */
	public Color getHoverColor() {
		return hoverColor;
	}
	
	/**
	 * pressedColor Getter:
	 * @return the color that appears when the mouse
	 * presses the menu button.
	 */
	public Color getPressedColor() {
		return pressedColor;
	}
	
	
/* *********************
 *      OTHERS
 * *********************/	
	/**
	 * buildButtonFunctionality
	 *  this method deals with events such as
	 *  the mouse hovering, pressing, clicking, and releasing. 
	 *  It also handles animations of the menuButton
	 */
	private void buildButtonFunctionality() {
		// Get the current color of the background
		Color originalColor = getRectBackgroundColor();
		
		// When mouse hovers this button
		this.setOnMouseEntered(e->{
			setRectBackgroundColor(hoverColor);
			
			// Moves the menu button 10 pixels to the right
			TranslateTransition tt = new TranslateTransition(Duration.millis(100), this);
			tt.setByX(20);
			tt.play();
			
			// Fades the background of the menu button by 30%
			FadeTransition ft = new FadeTransition(Duration.millis(200),background);
			ft.setFromValue(OPACITY);
			ft.setToValue(OPACITY*0.70);
			ft.play();
		});
		
		// When mouse exits(no hover) this button
		this.setOnMouseExited(e-> {
			setRectBackgroundColor(originalColor);
			
			// Moves the menu button back to its original position
			TranslateTransition tt = new TranslateTransition(Duration.millis(100), this);
			tt.setByX(-this.getTranslateX());
			tt.play();
			
			// Fades back in to its original opacity
			FadeTransition ft = new FadeTransition(Duration.millis(200),background);
			ft.setFromValue(OPACITY*0.70);
			ft.setToValue(OPACITY);
			ft.play();
		});
		
		// When mouse presses this button
		this.setOnMousePressed(e-> {
			setRectBackgroundColor(pressedColor);
			
		});
		
		
		// When mouse releases this button
		this.setOnMouseReleased(e-> {
			setRectBackgroundColor(originalColor);
			
		
		});
		
		
	}
	
	
}
