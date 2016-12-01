import javax.swing.JFrame;
public class P1Frame extends JFrame{
	public P1Frame(String str){
		P1Panel panel = new P1Panel(str);
		this.add(panel);
		this.setSize(400,200);
		this.setTitle(str);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
