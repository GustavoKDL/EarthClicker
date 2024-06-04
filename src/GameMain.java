import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.Font; 


public class GameMain {
	
	JLabel contadorTitulo;
	int contadorMundo, x, adubo,a = 0 , y=3,jardineiro, faseMundo = 0;
	double valorAdubo,valorFazendeiro,valorReflorestamento;
	boolean ligado=false;
	Timer timer;

	public static void main(String[] args) {
		
		new GameMain();
	}
	
	public GameMain(){
		
		valorAdubo = 7;
		valorFazendeiro = 18;
		valorReflorestamento = 500;
		x = 1; 
	    contadorMundo = 0;
	    adubo = 0;	    
		criarJanela();
		
	}
	
	public void criarJanela() {
		
		DecimalFormat aduboConvert = new DecimalFormat("#,###.00");
		DecimalFormat jardineiroConvert = new DecimalFormat("#,###.00");

		
		ImageIcon mundo1 = new ImageIcon(getClass().getClassLoader().getResource("Mundo1.png"));
		ImageIcon mundo2 = new ImageIcon(getClass().getClassLoader().getResource("planeta1.png"));
		ImageIcon mundo3 = new ImageIcon(getClass().getClassLoader().getResource("planeta2.png"));
		ImageIcon mundo4 = new ImageIcon(getClass().getClassLoader().getResource("planeta3.png"));
		ImageIcon mundo5 = new ImageIcon(getClass().getClassLoader().getResource("planeta4.png"));
		ImageIcon fundo = new ImageIcon(getClass().getClassLoader().getResource("fundo.png"));
		ImageIcon contadorImg = new ImageIcon(getClass().getClassLoader().getResource("contador.png"));
		ImageIcon aduboImg = new ImageIcon(getClass().getClassLoader().getResource("adubo.png"));
		ImageIcon jardineiroImg = new ImageIcon(getClass().getClassLoader().getResource("jardineiro.png"));
		ImageIcon reflorestamentoImg = new ImageIcon(getClass().getClassLoader().getResource("arvore.png"));
		
		JFrame janela = new JFrame();
		janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setBackground(Color.black);
		janela.getContentPane().setLayout(null);
		
		JLabel contadorAdubo = new JLabel("Adubo =" + aduboConvert.format(valorAdubo));
		contadorAdubo.setForeground(new Color(255, 255, 255));
		contadorAdubo.setBounds(482, 183, 103, 14);
		janela.getContentPane().add(contadorAdubo);
		
		JLabel contadorJardineiro = new JLabel("Jardineiro = "+ jardineiroConvert.format(valorFazendeiro));
		contadorJardineiro.setForeground(new Color(255, 255, 255));
		contadorJardineiro.setBounds(482, 319, 120, 23);
		janela.getContentPane().add(contadorJardineiro);
		
		JLabel contadorReflorestamento = new JLabel("Reflorestamento = 500");
		contadorReflorestamento.setForeground(new Color(255, 255, 255));
		contadorReflorestamento.setBounds(482, 463, 132, 23);
		janela.getContentPane().add(contadorReflorestamento);
		
		JLabel contadorTitulo_1 = new JLabel(contadorMundo+" arvores");
		contadorTitulo_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contadorTitulo_1.setBounds(156, 142, 110, 33);
		janela.getContentPane().add(contadorTitulo_1);
		contadorTitulo_1.setForeground(Color.white);
		
		
		JLabel vitoriapainel = new JLabel("VITORIA !!!");
		vitoriapainel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		vitoriapainel.setForeground(new Color(255, 255, 255));
		vitoriapainel.setBounds(145, 72, 110, 39);
		janela.getContentPane().add(vitoriapainel);
		vitoriapainel.setVisible(false);
		
		////////////////////////////////////////
		
		JButton mundoClicker = new JButton();
		mundoClicker.setBounds(99, 237, 202, 202);
		mundoClicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mundoClicker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contadorMundo += x;
				contadorTitulo_1.setText(contadorMundo+" arvores");
			}
		});
		mundoClicker.setBackground(null);
		mundoClicker.setBorder(null);
		janela.getContentPane().add(mundoClicker);
		mundoClicker.setIcon(mundo1);
		mundoClicker.setContentAreaFilled(false);
		mundoClicker.setBorderPainted(false);
		mundoClicker.setFocusPainted(false);

		
		JButton botaoAdubo = new JButton("" );
		botaoAdubo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoAdubo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(contadorMundo < valorAdubo) {}
				else {
					contadorMundo -= valorAdubo;
					valorAdubo = valorAdubo*1.8;
					adubo++;
					x ++;
					contadorTitulo_1.setText(contadorMundo+" arvores");
					contadorAdubo.setText("Adubo =" + aduboConvert.format(valorAdubo));
					
				}
					
			}
		});
		botaoAdubo.setBounds(414, 72, 250, 100);
		janela.getContentPane().add(botaoAdubo);
		botaoAdubo.setIcon(aduboImg);
		botaoAdubo.setContentAreaFilled(false);
		botaoAdubo.setBorderPainted(false);
		botaoAdubo.setFocusPainted(false);
		
		
		JButton botaoJardineiro = new JButton("");
		botaoJardineiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoJardineiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(contadorMundo < valorFazendeiro) {}
				else {
					if(ligado==false) {
						timer = new Timer (1000,new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
										
							contadorMundo += y;
							contadorTitulo_1.setText(contadorMundo+" arvores");
										
							}
							});
							timer.start();
							ligado = true;
							contadorMundo -= valorFazendeiro;
							valorFazendeiro = valorFazendeiro*1.8;
							jardineiro++;
							contadorJardineiro.setText("Jardineiro = "+ jardineiroConvert.format(valorFazendeiro));
					}
					else {
						contadorMundo -= valorFazendeiro;
						valorFazendeiro = valorFazendeiro*2.2;
						jardineiro++;
						y += 3;
						contadorJardineiro.setText("Jardineiro = "+ jardineiroConvert.format(valorFazendeiro));
					}					
				}
				
			}
		});
		botaoJardineiro.setBounds(414, 208, 250, 100);
		janela.getContentPane().add(botaoJardineiro);
		botaoJardineiro.setIcon(jardineiroImg);
		botaoJardineiro.setContentAreaFilled(false);
		botaoJardineiro.setBorderPainted(false);
		botaoJardineiro.setFocusPainted(false);
		
		JButton botaoReflorestamento = new JButton("");
		botaoReflorestamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoReflorestamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(contadorMundo < valorReflorestamento) {}
				else {
					contadorMundo -= valorReflorestamento;
					faseMundo ++;
						switch(faseMundo) {
							case 1:
								mundoClicker.setIcon(mundo2);
								break;
							case 2:
								mundoClicker.setIcon(mundo3);
								break;
							case 3:
								mundoClicker.setIcon(mundo4);
								break;
							case 4:
								mundoClicker.setIcon(mundo5);
								vitoriapainel.setVisible(true);
								break;
						
						}
				}
				
			}
		});
		
		
		botaoReflorestamento.setBounds(414, 353, 250, 100);
		janela.getContentPane().add(botaoReflorestamento);
		botaoReflorestamento.setIcon(reflorestamentoImg);
		botaoReflorestamento.setContentAreaFilled(false);
		botaoReflorestamento.setBorderPainted(false);
		botaoReflorestamento.setFocusPainted(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(99, 122, 200, 75);
		janela.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(contadorImg);
		
		JLabel painelFundo = new JLabel("");
		painelFundo.setBounds(0, 0, 784, 575);
		janela.getContentPane().add(painelFundo);
		painelFundo.setIcon(fundo);
	
		
		
		
		
		
		
		
		
		System.out.println(y);
		
		
		
		janela.setVisible(true);
		
		
	}
}

