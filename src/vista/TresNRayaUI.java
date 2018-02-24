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
import java.awt.GridBagLayout;
import javax.swing.JButton;

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
		botonera.setBounds(0, 55, 380, 380);
		botonera.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(botonera);
		botonera.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTresEnRaya = new JLabel("TRES EN RAYA");
		lblTresEnRaya.setOpaque(true);
		lblTresEnRaya.setBackground(Color.DARK_GRAY);
		lblTresEnRaya.setHorizontalAlignment(SwingConstants.CENTER);
		lblTresEnRaya.setForeground(Color.WHITE);
		lblTresEnRaya.setFont(new Font("Arial", Font.ITALIC, 25));
		lblTresEnRaya.setBounds(0, 0, 380, 52);
		contentPane.add(lblTresEnRaya);
		
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
		txtJugada.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugada.setFont(new Font("Arial", Font.BOLD, 12));
		txtJugada.setBounds(343, 442, 37, 14);
		contentPane.add(txtJugada);
		
		txtTurno = new JLabel("");
		txtTurno.setHorizontalAlignment(SwingConstants.CENTER);
		txtTurno.setFont(new Font("Arial", Font.BOLD, 30));
		txtTurno.setBounds(4, 439, 30, 30);
		contentPane.add(txtTurno);
		
		JLabel lblJugadaActual = new JLabel("Jugada actual");
		lblJugadaActual.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblJugadaActual.setBounds(270, 442, 80, 14);
		contentPane.add(lblJugadaActual);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBorder(null);
		btnReiniciar.setBackground(Color.LIGHT_GRAY);
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReiniciar.setVisible(false);
		btnReiniciar.setBounds(10, 530, 358, 30);
		contentPane.add(btnReiniciar);
	}
}
