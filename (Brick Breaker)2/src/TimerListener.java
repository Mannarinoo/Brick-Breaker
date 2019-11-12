import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;




public class TimerListener implements ActionListener{
	//Instance Variables
    private BrickPanel panel;
    private ControlPanel controlPanel;
    private Timer _timer;
    private MainPanel _mainPanel;
	//Constructor
    public TimerListener(BrickPanel p, ControlPanel cp, Timer T, MainPanel mp) {
    	panel = p;
    	
    	controlPanel = cp;
    	_timer = T;
    	_mainPanel = mp;
		
    }
	//Instance Method
    @Override
    public void actionPerformed(ActionEvent e) {
    	//move the ball, update the score, and call repaint with every tick
   
    	controlPanel.updateScore();
		_mainPanel.moveBall();
		panel.repaint();
    
		//call repaint !
    }
}
