import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.Button;
import java.awt.Event;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JList;

public class Main {
	static JComboBox<Object> comboBox_1= new JComboBox<>();
	static JLabel lblNewLabel_4 = new JLabel("New label");
	static JComboBox comboBox = new JComboBox(getUserID());
	static JFrame frame3 = new JFrame("Filmes recomendados");
	static JFrame frame4 = new JFrame("Usuários recomendados");
	static JFrame frame2 = new JFrame("Classificação");
	static JFrame frame = new JFrame("Menu");
	static MovieRunnerSimilarRatings mClassification = new MovieRunnerSimilarRatings();
	static JList<String> list = new JList<String>();
	static JComboBox comboBox_2 = new JComboBox(getUserID());
	static JComboBox comboBox_3 = new JComboBox(getMoviesIDAll());
	static JPanel panel = new JPanel();
	static JPanel panel2 = new JPanel();


	private static final JButton btnNewButton_1 = new JButton("Voltar");
	private static final JButton btnNewButton_3 = new JButton("Voltar");
	private static DefaultListModel<String> filmes;
	private static DefaultListModel<String> users;
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {




		// TODO Auto-generated method stub
//teste();
		janela1();
		//janela4();
		//janela2();
		//janela3();
		//getUserID();
		//getMoviesID();
		//getMoviesIDAll();

	}
	public static void teste(){
		RaterDatabase.initialize("ratings.csv ");
		
		System.out.println(RaterDatabase.getRater("65"));
	}
	
	public static Integer[] getUserID(){
		RaterDatabase.initialize("ratings.csv ");
		ArrayList<Rater> raters = RaterDatabase.getRaters();

		Set<Integer> set = new HashSet<Integer>();

		for(Rater r: raters) {
			set.add(Integer.parseInt(r.getID())); 
		}

		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);		
		Integer[] raterID =list.toArray(new Integer[0]);

		return raterID;
	}

	public static String[] getMoviesID(String userID){
		RaterDatabase.initialize("ratings.csv ");
		ArrayList<Rater> raters = RaterDatabase.getRaters();
		ArrayList<String> lista = new ArrayList<String>();
		for(Rater r: raters) {
			if(userID.equalsIgnoreCase(r.getID())){
				lista = r.getItemsRated(); 		
			}
		}
		String[] moviesID =lista.toArray(new String[0]);
		//System.out.println(lista.toString());


		return moviesID;
	}
	
	public static Integer[] getMoviesIDAll(){
		RaterDatabase.initialize("ratings.csv ");
		ArrayList<Rater> raters = RaterDatabase.getRaters();
		Set<Integer> set = new HashSet<Integer>();
		ArrayList<String> lista_aux = new ArrayList<String>();
		

		for(Rater r: raters) {
			lista_aux = r.getItemsRated();
			for(int i=0; i<lista_aux.size(); i++){
				set.add(Integer.parseInt(lista_aux.get(i)));
			}
		}

		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);		
		Integer[] raterID =list.toArray(new Integer[0]);
		
		System.out.println(raterID[234]);

		return raterID;
	}

	public static String getRating(String userID,String movieID){
		RaterDatabase.initialize("ratings.csv ");
		ArrayList<Rater> raters = RaterDatabase.getRaters();
		ArrayList<String> lista = new ArrayList<String>();
		String rating="";
		for(Rater r: raters) {
			if(userID.equalsIgnoreCase(r.getID())){
				lista = r.getItemsRated();	
				r.getRating(movieID);
				for(String a: lista){
					if(movieID.equalsIgnoreCase(a))
						rating = Double.toString(r.getRating(movieID));
				}
			}
		}


		return rating;
	}
	


	public static void janela1(){



		JTextField textField;
		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblAsdnAsd = new JLabel((String) null);

		JLabel lblNewLabel = new JLabel("1) Classifica\u00E7\u00E3o");

		JLabel lblNewLabel_1 = new JLabel("2) Recomenda\u00E7\u00E3o de usu\u00E1rios para um filme");

		JLabel lblNewLabel_2 = new JLabel("3) Recomenda\u00E7\u00E3o de filmes para um usu\u00E1rio");

		JLabel lblNewLabel_3 = new JLabel("0) Sair");

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch ( Integer.parseInt((textField.getText()))) {
				case 0:
					System.exit(0);

				case 1:
					frame.dispose();
					janela2();
					break;
				case 2:
					frame.dispose();
					janela4();
					break;
				case 3:
					frame.dispose();
					janela3();
					break;
				default:
					System.err.println ( "Unrecognized option" );
					break;
				}
				System.out.println ("\n\n\n");
			}


		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(35)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(textField)
												.addGap(18)
												.addComponent(btnNewButton))
										.addComponent(lblNewLabel_2, Alignment.LEADING)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblAsdnAsd))))
						.addContainerGap(18, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(31)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(26)
										.addComponent(lblAsdnAsd))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addComponent(lblNewLabel_1)))
						.addGap(18)
						.addComponent(lblNewLabel_2)
						.addGap(18)
						.addComponent(lblNewLabel_3)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addContainerGap(28, Short.MAX_VALUE))
				);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(groupLayout);
		frame.setLocationRelativeTo(null); 
		frame.pack();
		frame.setVisible(true);

	}

	public static void janela2(){



		JLabel lblUserId = new JLabel("USER ID");

		JLabel lblMovie = new JLabel("MOVIE");


		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame2.dispose();
				frame.setVisible(true);
			}
		});



		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setModel(new DefaultComboBoxModel<Object> (getMoviesID(String.valueOf(((Integer)comboBox.getSelectedItem())))));
				lblNewLabel_4.setText("Rating: "+getRating(String.valueOf(((Integer)comboBox.getSelectedItem())),(String)comboBox_1.getSelectedItem()));
			}
		});

		comboBox_1 = new JComboBox<Object>(getMoviesID(String.valueOf(((Integer)comboBox.getSelectedItem()))));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_4.setText("Rating: "+getRating(String.valueOf(((Integer)comboBox.getSelectedItem())),(String)comboBox_1.getSelectedItem()));
			}
		});
		lblNewLabel_4.setText("Rating: "+getRating(String.valueOf(((Integer)comboBox.getSelectedItem())),(String)comboBox_1.getSelectedItem()));

		GroupLayout groupLayout = new GroupLayout(frame2.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblUserId)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(comboBox_1, 0, 195, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnNewButton_1))
												.addComponent(lblMovie)))
								.addComponent(lblNewLabel_4))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblMovie)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNewButton_1)))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblUserId)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addComponent(lblNewLabel_4)
						.addContainerGap(20, Short.MAX_VALUE))
				);
		frame2.getContentPane().setLayout(groupLayout);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLocationRelativeTo(null); 
		frame2.pack();
		frame2.setVisible(true);
	}

	public static void janela3(){

		panel = new JPanel();
		JLabel lblUserid = new JLabel("USERID");		

		filmes = new DefaultListModel<String>();

		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame3.dispose();
				frame.setVisible(true);
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame3.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(lblUserid)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
										.addComponent(btnNewButton_3)))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblUserid)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3))
						.addGap(11)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addContainerGap())
				);

		String lista [] = mClassification.printSimilarRatings(String.valueOf(((Integer)comboBox_2.getSelectedItem())));
		for(int i=0; i<lista.length; i++){
			filmes.addElement(lista[i]);
		}
		list = new JList<String>(filmes);
		panel.add(list);

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel = new JPanel();
				String lista [] = mClassification.printSimilarRatings(String.valueOf(((Integer)comboBox_2.getSelectedItem())));
				list.setListData(lista);
				
			}
		});



		frame3.getContentPane().setLayout(groupLayout);

		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(groupLayout);
		frame3.setLocationRelativeTo(null); 
		frame3.pack();
		frame3.setVisible(true);

	}
	
	public static void janela4(){

		panel2 = new JPanel();
		JLabel lblMovieID = new JLabel("MOVIEID");		

		users = new DefaultListModel<String>();

		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame4.dispose();
				frame.setVisible(true);
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame4.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(lblMovieID)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
										.addComponent(btnNewButton_3)))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblMovieID)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3))
						.addGap(11)
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addContainerGap())
				);

		String lista [] = new String[1];//mClassification.printSimilarRatings(String.valueOf(((Integer)comboBox_3.getSelectedItem())));
		for(int i=0; i<lista.length; i++){
			users.addElement(lista[i]);
		}
		list = new JList<String>(users);
		panel2.add(list);

		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2 = new JPanel();
				String lista [] = mClassification.printSimilarRatings(String.valueOf(((Integer)comboBox_3.getSelectedItem())));
				list.setListData(lista);
				
			}
		});

		frame4.getContentPane().setLayout(groupLayout);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(groupLayout);
		frame4.setLocationRelativeTo(null); 
		frame4.pack();
		frame4.setVisible(true);

	}
}
