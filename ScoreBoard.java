import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class ScoreBoard implements ActionListener {
	JFrame mainScreen;
	JButton addHome, addAway, doubleScore, resetToOne, resetScore;
	JLabel homeTeam, awayTeam, vs, homeScore, awayScore, winner, title;
	public int HomeLabelScore, AwayLabelScore = 0;
	public int willAddHome = 1;
    public int willAddAway = 1;
	public ScoreBoard() {
		mainScreen = new JFrame();
		mainScreen.setSize(500, 650);
		mainScreen.setResizable(false);
		mainScreen.setTitle("Score Board");
		mainScreen.setContentPane(makePanel());
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	public JPanel makePanel() {
		JPanel panel = new JPanel();
		vs = new JLabel("VS");
		title = new JLabel("SCORE KEEPER",SwingConstants.CENTER);
		awayTeam = new JLabel("Bills");
		homeTeam = new JLabel("Patriots");
		homeScore = new JLabel("" + HomeLabelScore);
		awayScore = new JLabel("" + AwayLabelScore);
		addHome = new JButton("Add "+willAddHome+" Points.");
		addAway = new JButton("Add "+willAddAway+" Points.");
		doubleScore = new JButton("Click to double the amount of points you can add to the score.");
		resetToOne = new JButton("Reset Adders.");
		resetScore = new JButton("Reset Score.");
		winner = new JLabel("The game is tied",SwingConstants.CENTER);
		Font teamFont = new Font("impact", Font.BOLD, 35);
		Font titleFont = new Font("Haettenschweiler", Font.ITALIC, 60);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		title.setFont(titleFont);
		title.setLocation(25, 10);
		title.setSize(450, 50);
		awayTeam.setSize(175, 50);
		homeTeam.setSize(175, 50);
		homeTeam.setLocation(65, 75);
		awayTeam.setLocation(315, 75);
		homeTeam.setToolTipText("New England Patriots");
		awayTeam.setToolTipText("Buffalo Bills");
		homeTeam.setFont(teamFont);
		awayTeam.setFont(teamFont);
		vs.setSize(50, 50);
		vs.setLocation(245, 80);
		JPanel scorePanel = new JPanel();
		JPanel scorePanel2 = new JPanel();
		scorePanel.setSize(75, 60);
		scorePanel2.setSize(75, 60);
		scorePanel.setToolTipText("Patriots Score");
		scorePanel2.setToolTipText("Bills Score");
		scorePanel.setBackground(Color.WHITE);
		scorePanel2.setBackground(Color.WHITE);
		scorePanel.setLocation(95, 125);
		scorePanel2.setLocation(315, 125);
		scorePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		scorePanel2.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel scoreLine = new JPanel();
		scoreLine.setBackground(Color.RED);
		scoreLine.setSize(500, 5);
		scoreLine.setLocation(0, 220);
		scoreLine.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel scoreLine5 = new JPanel();
		scoreLine5.setBackground(Color.RED);
		scoreLine5.setSize(500, 3);
		scoreLine5.setLocation(0, 50);
		scoreLine5.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel scoreLine6 = new JPanel();
		scoreLine6.setBackground(Color.RED);
		scoreLine6.setSize(500, 3);
		scoreLine6.setLocation(0, 30);
		scoreLine6.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel scoreLine7 = new JPanel();
		scoreLine7.setBackground(Color.RED);
		scoreLine7.setSize(500, 3);
		scoreLine7.setLocation(0, 10);
		scoreLine7.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel scoreLine2 = new JPanel();
		scoreLine2.setBackground(Color.RED);
		scoreLine2.setSize(500, 3);
		scoreLine2.setLocation(0, 20);
		scoreLine2.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel scoreLine3 = new JPanel();
		scoreLine3.setBackground(Color.RED);
		scoreLine3.setSize(500, 3);
		scoreLine3.setLocation(0, 40);
		scoreLine3.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel scoreLine4 = new JPanel();
		scoreLine4.setBackground(Color.RED);
		scoreLine4.setSize(500, 3);
		scoreLine4.setLocation(0, 60);
		scoreLine4.setBorder(BorderFactory.createLineBorder(Color.black));
		homeScore.setFont(teamFont);
		awayScore.setFont(teamFont);
		scorePanel.add(homeScore);
		scorePanel2.add(awayScore);
		addHome.setLocation(25, 230);
		addAway.setLocation(275, 230);
		addHome.setSize(200, 100);
		addAway.setSize(200, 100);
		addHome.addActionListener(this);
		addAway.addActionListener(this);
		doubleScore.setSize(450, 75);
		doubleScore.setLocation(25, 350);
		doubleScore.addActionListener(this);
		resetToOne.setSize(120, 40);
		resetToOne.setLocation(190, 445);
		resetToOne.addActionListener(this);
		resetScore.setSize(120, 40);
		resetScore.setLocation(190, 495);
		resetScore.addActionListener(this);
		winner.setSize(450,50);
		winner.setLocation(25,545);
		winner.setFont(teamFont);
		winner.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(title);
		panel.add(winner);
		panel.add(resetScore);
		panel.add(resetToOne);
		panel.add(doubleScore);
		panel.add(addHome);
		panel.add(addAway);
		panel.add(scoreLine);
		panel.add(scoreLine2);
		panel.add(scoreLine3);
		panel.add(scoreLine4);
		panel.add(scoreLine5);
		panel.add(scoreLine6);
		panel.add(scoreLine7);
		panel.add(scorePanel);
		panel.add(scorePanel2);
		panel.add(vs);
		panel.add(homeTeam);
		panel.add(awayTeam);
		return panel;
	}
	public static void main(String[] args) {
		new ScoreBoard();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addHome) {
			HomeLabelScore += willAddHome;
			homeScore.setText("" +HomeLabelScore);
			findWinner();
		} else if (e.getSource() == addAway) {
			AwayLabelScore += willAddAway;
			awayScore.setText("" +AwayLabelScore);
			findWinner();
		} else if (e.getSource() == doubleScore) {
			willAddHome = willAddHome * 2;
			willAddAway = willAddAway * 2;
			addHome.setText("Add "+willAddHome+" Points.");
			addAway.setText("Add "+willAddAway+" Points.");
			findWinner();
		} else if (e.getSource() == resetToOne) {
			willAddHome = 1;
			willAddAway = 1;
			addHome.setText("Add "+willAddHome+" Points.");
			addAway.setText("Add "+willAddAway+" Points.");
			findWinner();
		} else if (e.getSource() == resetScore) {
			HomeLabelScore = 0;
			AwayLabelScore = 0;
			homeScore.setText(""+HomeLabelScore);
			awayScore.setText(""+AwayLabelScore);
			findWinner();
		}
	}
	private void findWinner() {
		if(HomeLabelScore > AwayLabelScore){
			winner.setText("The Patriots are Winning!");
		}else if(AwayLabelScore > HomeLabelScore){
			winner.setText("The Bills are Winning!");
		}else if(AwayLabelScore == HomeLabelScore){
			winner.setText("The game is tied!");
		}		
	}
}
