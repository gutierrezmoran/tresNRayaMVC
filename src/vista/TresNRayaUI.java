package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Cursor;

public class TresNRayaUI extends JFrame {

	protected JPanel contentPane;
	protected Botonera botonera;
	protected JLabel txtMensaje;
	protected JLabel txtTurno;
	protected JLabel txtJugada;
	protected JButton btnReiniciar;

	/**
	 * Create the frame.
	 */
	public TresNRayaUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		botonera=new Botonera();
		botonera.setBackground(new Color(220, 220, 220));
		botonera.setBounds(0, 55, 380, 380);
		botonera.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(botonera);
		botonera.setLayout(new BorderLayout(0, 0));
		
		JPanel Titulo = new JPanel();
		Titulo.setOpaque(true);
		Titulo.setBackground(Color.DARK_GRAY);
		Titulo.setForeground(Color.WHITE);
		Titulo.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		Titulo.setBounds(0, 0, 380, 52);
		contentPane.add(Titulo);
		Titulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("TRES EN RAYA");
		lblTitulo.setForeground(SystemColor.controlHighlight);
		lblTitulo.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 40));
		lblTitulo.setBounds(10, 0, 370, 47);
		Titulo.add(lblTitulo);
		
		txtMensaje = new JLabel("");
		txtMensaje.setVisible(false);
		txtMensaje.setOpaque(true);
		txtMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtMensaje.setForeground(Color.DARK_GRAY);
		txtMensaje.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		txtMensaje.setBackground(Color.ORANGE);
		txtMensaje.setBounds(0, 571, 380, 35);
		contentPane.add(txtMensaje);
		
		txtJugada = new JLabel("");
		txtJugada.setHorizontalAlignment(SwingConstants.RIGHT);
		txtJugada.setFont(new Font("Arial", Font.BOLD, 12));
		txtJugada.setBounds(341, 437, 27, 14);
		contentPane.add(txtJugada);
		
		txtTurno = new JLabel("");
		txtTurno.setHorizontalAlignment(SwingConstants.CENTER);
		txtTurno.setFont(new Font("Arial", Font.BOLD, 30));
		txtTurno.setBounds(4, 439, 30, 30);
		contentPane.add(txtTurno);
		
		JLabel lblJugadaActual = new JLabel("Jugada actual");
		lblJugadaActual.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblJugadaActual.setBounds(277, 437, 74, 14);
		contentPane.add(lblJugadaActual);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReiniciar.setBorder(null);
		btnReiniciar.setBackground(Color.ORANGE);
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReiniciar.setVisible(false);
		btnReiniciar.setFocusPainted(false);
		btnReiniciar.setBounds(219, 516, 149, 44);
		btnReiniciar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btnReiniciar.setBackground(new Color(255, 219, 86));
			}

			public void mouseExited(MouseEvent e) {
				btnReiniciar.setBackground(Color.ORANGE);
			}
		});
		contentPane.add(btnReiniciar);
	}
}
